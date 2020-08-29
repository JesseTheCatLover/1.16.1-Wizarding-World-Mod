package com.enchantedguys.wizardingworldmod.common.items.wands;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class MrLimnerWand extends AbstractWandItem {
    public MrLimnerWand() {
        super(new Item.Properties()
                        .group(WizardingWorldMod.WANDS)
                        .maxStackSize(1)
                , () -> Lists.newArrayList(new StringTextComponent(""))); //Edit here the information
    }

    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return !player.isCreative();
    }

    @Override
    public void performAttack(ItemStack itemStack, PlayerEntity player, World world, List<LivingEntity> hittetEntities, BlockState hittetBlock) {

    }

    @Override
    public int actionType() {
        return 0;
    }


    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.create("mr_limner", TextFormatting.BLUE);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 300;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 10000;
    }

    @Override
    public Item getWandItem() {
        return this;
    }
}
