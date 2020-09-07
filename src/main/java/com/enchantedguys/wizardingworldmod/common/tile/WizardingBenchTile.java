package com.enchantedguys.wizardingworldmod.common.tile;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.container.WizardingBenchContainer;
import com.enchantedguys.wizardingworldmod.common.init.ModTileEntities;
import com.enchantedguys.wizardingworldmod.common.items.charmbooks.ICharmBook;
import com.enchantedguys.wizardingworldmod.common.items.wands.IWandItem;
import com.enchantedguys.wizardingworldmod.common.util.FunctionalIntReferenceHolder;
import com.enchantedguys.wizardingworldmod.common.util.helpers.TextComponentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * For every block that has a inventory, you have to create the tile entity. This entity have to extend {@link ContainerTile}
 * or if it is a tile entity with a working recipe (e.g: Furnace) (NOT A WORKBENCH), then the tile entity have to extend from {@link WorkingTile}
 *
 */
public class WizardingBenchTile extends ContainerTile{

    public WizardingBenchTile() {
        super(ModTileEntities.WIZARDING_BENCH.get(), 2);
    }

    /**
     * If you have some custom written data, then you can read it here
     * @param nbt the nbt from where you get the data
     */
    @Override
    public void readData(CompoundNBT nbt) {

    }

    /**
     * If you want to write custom data, (e.g. variables) then you can do this here.
     * This method sync it with the server, and you can read the data from the readData method
     * @param nbt the nbt where you can put it in
     * @return the nbt object or null if you have no data to add
     */
    @Override
    public CompoundNBT writeData(CompoundNBT nbt) {
        return null;
    }

    /**
     * If you have integer/double/float variables, who have to sync with the container class (e.g. the burnTime value in the furnace),
     * then you can add this here.
     * {@link com.google.common.collect.Lists#newArrayList()} should help.
     * If you create new {@link FunctionalIntReferenceHolder} look into the {@link WorkingTile} class, for a example
     * @return the list with data to sync
     */
    @Override
    public List<FunctionalIntReferenceHolder> getIntReferenceHolder() {
        return null;
    }

    /**
     * This method is used, to check if the item is valid for the slot.
     * In this case, it checks if the LEFT SLOT (slot=0) is a valid wand item, and the second slot a valid charm book item.
     *
     * @param slot the slot to check
     *             default start with 0 and max is the number where you set by the constructor above "inventorySlots" - 1
     * @param stack the stack to check
     * @return true if the item is valid
     *         false if the item is not valid
     */
    @Override
    public BooleanSupplier isItemValid(int slot, ItemStack stack) {
        switch (slot) {
            case 0:
                if(stack.getItem() instanceof IWandItem)
                    return trueSupplier();
            case 1:
                if(stack.getItem() instanceof ICharmBook)
                    return trueSupplier();
        }
        return falseSupplier();
    }

    /**
     * @return the display name from the container
     */
    @Override
    public ITextComponent getDisplayName() {
        return TextComponentHelper.translate(WizardingWorldMod.MOD_ID + ".container.wizarding_bench");
    }

    /**
     * @param p_createMenu_1_ - windowId
     * @param p_createMenu_2_ - playerInventory object
     * @param p_createMenu_3_ - playerEntity object
     * @return the new container instance
     */
    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return new WizardingBenchContainer(p_createMenu_1_, p_createMenu_2_, this);
    }
}
