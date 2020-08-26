package com.enchantedguys.wizardingworldmod.common.container;

import com.enchantedguys.wizardingworldmod.common.recipe.IModRecipe;
import com.enchantedguys.wizardingworldmod.common.tile.ContainerTile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CraftingBaseContainer<R extends IModRecipe<RecipeWrapper>, TILE extends ContainerTile> extends BaseContainer<TILE> {

    protected final ItemStackHandler resultHandler;
    protected final PlayerEntity player;
    protected R lastRecipe;

    public CraftingBaseContainer(@Nullable ContainerType<?> type, int id, PlayerInventory playerInventory, TILE tile, int resultSlot) {
        super(type, id, playerInventory, tile);
        this.player = playerInventory.player;
        this.resultHandler = new ItemStackHandler(resultSlot);
        this.updateRecipe();
    }

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, PlayerEntity player) {
        this.updateRecipe();
        return super.slotClick(slotId, dragType, clickTypeIn == ClickType.PICKUP_ALL ? ClickType.PICKUP : clickTypeIn, player);
    }

    public abstract IRecipeType<R> recipeType();

    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            int craftingGridSize = this.tile.inventory.getSlots() + 1;


            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 0) {
                this.canInteract.consume((world, pos) -> itemstack1.getItem().onCreated(itemstack1, world, playerIn));
                if (!this.mergeItemStack(itemstack1, craftingGridSize, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= craftingGridSize && index < this.inventoryItemStacks.size()) {
                if (!this.mergeItemStack(itemstack1, 1, craftingGridSize, false)) {
                    if (index < 31) {
                        if (!this.mergeItemStack(itemstack1, this.inventorySlots.size() - 9, this.inventorySlots.size(), false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.mergeItemStack(itemstack1, craftingGridSize, this.inventorySlots.size() - 9, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.mergeItemStack(itemstack1, 5, this.inventorySlots.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);
            if (index == 0) {
                playerIn.dropItem(itemstack2, false);
            }
        }
        return itemstack;
    }

    protected void findRecipe(int id, World worldIn, PlayerEntity playerIn, IItemHandlerModifiable inventoryIn, IItemHandlerModifiable inventoryResult) {
        if (!worldIn.isRemote) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) playerIn;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<R> toolrecipe = worldIn.getServer().getRecipeManager().getRecipe(recipeType(), new RecipeWrapper(inventoryIn), worldIn);
            if (toolrecipe.isPresent()) {
                R recipe = toolrecipe.get();
                this.lastRecipe = recipe;
                itemstack = recipe.getCraftingResult(new RecipeWrapper(inventoryIn));
            }

            inventoryResult.setStackInSlot(0, itemstack);
            serverplayerentity.connection.sendPacket(new SSetSlotPacket(id, 0, itemstack));
        }
    }

    public void onCraftMatrixChanged(@Nullable IInventory inventoryIn) {
        updateRecipe();
    }

    private void updateRecipe() {
        this.canInteract.consume((world, pos) -> findRecipe(this.windowId, world, this.player, this.tile.inventory, this.resultHandler));
    }

    @SuppressWarnings("unchecked")
    public void craft() {
        if (this.lastRecipe == null || this.player.world.isRemote) return;
        ServerPlayerEntity serverplayer = (ServerPlayerEntity) this.player;
        List<Integer> slotstoupdate = new ArrayList<>();

        //REMOVE AND HANDLE REMAINING ITEMS
        NonNullList<ItemStack> itemsremaining = this.lastRecipe.getRemainingItems(new RecipeWrapper(this.tile.inventory));

        for (int i = 0; i < itemsremaining.size(); ++i) {
            ItemStack itemstack = this.tile.inventory.getStackInSlot(i);
            ItemStack remaining = itemsremaining.get(i);
            if (!itemstack.isEmpty()) {
                this.tile.inventory.extractItem(i, 1, false);
                slotstoupdate.add(i);
                itemstack = this.tile.inventory.getStackInSlot(i);
            }

            if (!remaining.isEmpty()) {
                if (itemstack.isEmpty()) {
                    this.tile.inventory.setStackInSlot(i, remaining);
                    slotstoupdate.add(i);
                } else if (ItemStack.areItemsEqual(itemstack, remaining) && ItemStack.areItemStackTagsEqual(itemstack, remaining)) {
                    remaining.grow(itemstack.getCount());
                    this.tile.inventory.setStackInSlot(i, remaining);
                    slotstoupdate.add(i);
                } else if (!player.inventory.addItemStackToInventory(remaining)) {
                    player.dropItem(remaining, false);
                }
            }
        }
        updateRecipe();

        slotstoupdate.forEach(i -> serverplayer.connection.sendPacket(new SSetSlotPacket(this.windowId, i + 1, this.tile.inventory.getStackInSlot(i))));
    }

}
