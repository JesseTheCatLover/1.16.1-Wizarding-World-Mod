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

public class WizardingBenchTile extends ContainerTile{

    public WizardingBenchTile() {
        super(ModTileEntities.WIZARDING_BENCH.get(), 2);
    }

    @Override
    public void readData(CompoundNBT nbt) {

    }

    @Override
    public CompoundNBT writeData(CompoundNBT nbt) {
        return null;
    }

    @Override
    public List<FunctionalIntReferenceHolder> getIntReferenceHolder() {
        return null;
    }

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

    @Override
    public ITextComponent getDisplayName() {
        return TextComponentHelper.translate(WizardingWorldMod.MOD_ID + ".container.wizarding_bench");
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return new WizardingBenchContainer(p_createMenu_1_, p_createMenu_2_, this);
    }
}
