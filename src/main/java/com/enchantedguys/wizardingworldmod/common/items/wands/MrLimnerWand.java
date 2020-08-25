package com.enchantedguys.wizardingworldmod.common.items.wands;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.util.ModEntries;
import com.enchantedguys.wizardingworldmod.common.util.helpers.KeyboardHelper;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MrLimnerWand extends Item {
    public MrLimnerWand() {
        super(new Item.Properties()
                .group(WizardingWorldMod.WANDS)
                .maxStackSize(1)
        );
    }

    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return !player.isCreative();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if (KeyboardHelper.isHoldingShift())
        {

            tooltip.add(new StringTextComponent(ModEntries.WandInformation("Alder", "phoenix feather",
                    "12 ¼ and slightly springy")));

        } else {

            tooltip.add(new StringTextComponent(ModEntries.HoldShiftToolTip));

        }

        super.addInformation(stack, worldIn, tooltip, flagIn);
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
}
