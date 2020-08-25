package com.enchantedguys.wizardingworldmod.common.inventory.slot;

import com.enchantedguys.wizardingworldmod.common.container.CraftingBaseContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class SlotCraftingResult extends SlotItemHandler {

    private CraftingBaseContainer<?, ?> container;
    private PlayerEntity player;
    private int amountCrafted;

    public SlotCraftingResult(IItemHandlerModifiable itemHandler, PlayerEntity player, CraftingBaseContainer<?, ?> container, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
        this.container = container;
        this.player = player;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    public ItemStack decrStackSize(int p_75209_1_) {
        if (this.getHasStack()) {
            this.amountCrafted += Math.min(p_75209_1_, this.getStack().getCount());
        }

        return super.decrStackSize(p_75209_1_);
    }

    protected void onCrafting(ItemStack output, int amount) {
        this.amountCrafted += amount;
        this.onCrafting(output);
    }

    protected void onSwapCraft(int amount) {
        this.amountCrafted += amount;
    }

    protected void onCrafting(ItemStack output) {
        if (this.amountCrafted > 0) {
            output.onCrafting(this.player.world, this.player, this.amountCrafted);
        }

        if (this.inventory instanceof IRecipeHolder) {
            ((IRecipeHolder) this.inventory).onCrafting(this.player);
        }

        this.amountCrafted = 0;
    }

    @Override
    public ItemStack onTake(PlayerEntity player, ItemStack stack) {
        this.onCrafting(stack);
        this.container.craft();
        return stack;
    }

}
