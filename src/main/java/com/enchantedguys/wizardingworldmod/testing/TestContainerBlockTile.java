package com.enchantedguys.wizardingworldmod.testing;

import com.enchantedguys.wizardingworldmod.common.tile.ContainerTile;
import com.enchantedguys.wizardingworldmod.common.util.FunctionalIntReferenceHolder;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.BooleanSupplier;

public class TestContainerBlockTile extends ContainerTile {

    public TestContainerBlockTile(TileEntityType<?> tileEntityTypeIn, int inventorySlots) {
        super(tileEntityTypeIn, inventorySlots);
    }

    /**
     * Use this to read saved data
     * @param nbt
     */
    @Override
    public void readData(CompoundNBT nbt) {

    }

    /**
     * Use this to write saved data
     * @param nbt
     * @return
     */
    @Override
    public CompoundNBT writeData(CompoundNBT nbt) {
        return null;
    }

    private int variable;

    /**
     * If you want to sync data (ONLY INTEGERS) with the container and screen you have to add a {@link FunctionalIntReferenceHolder} in this list.
     *
     * Example:
     *
     * Lists.newArrayListy(new FunctionalIntReferenceHolder(() -> variable, v -> varaible = v))
     *
     *
     * Return null if you have no data to sync
     * @return
     */
    @Override
    public List<FunctionalIntReferenceHolder> getIntReferenceHolder() {
        return Lists.newArrayList(new FunctionalIntReferenceHolder(() -> variable, v -> variable = v));
    }

    /**
     *
     * Use this method to check if a item is valid for the slot
     *
     * @param slot the slot index
     * @param stack the stack to check
     * @return null if nothing to check
     */
    @Override
    public BooleanSupplier isItemValid(int slot, ItemStack stack) {
        switch (slot) {
            case 0:
                if(stack.getItem() == Items.DIAMOND)
                    return () -> true;
            case 1:
                if(stack.getItem() == Items.IRON_INGOT)
                    return () -> true;
        }
        return null;
    }

    /**
     * Display name of the container
     * @return
     */
    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

    /**
     * The container instance
     * @param p_createMenu_1_
     * @param p_createMenu_2_
     * @param p_createMenu_3_
     * @return
     */
    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return null;
    }
}
