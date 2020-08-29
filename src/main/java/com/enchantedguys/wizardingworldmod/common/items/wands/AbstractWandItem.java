package com.enchantedguys.wizardingworldmod.common.items.wands;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public abstract class AbstractWandItem extends Item implements IWandItem {

    protected final Supplier<List<ITextComponent>> description;

    public AbstractWandItem(Properties properties, Supplier<List<ITextComponent>> description) {
        super(properties);
        this.description = description;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (description == null || description.get() == null) return;
        List<ITextComponent> desc = description.get();
        tooltip.addAll(desc);
    }

    public abstract int performAttack();

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
