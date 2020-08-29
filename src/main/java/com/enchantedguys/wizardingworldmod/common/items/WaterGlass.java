package com.enchantedguys.wizardingworldmod.common.items;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import com.enchantedguys.wizardingworldmod.common.util.Pair;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WaterGlass extends ConsumeItem {
    public WaterGlass() {
        super(new Item.Properties()
                .group(WizardingWorldMod.MATERIALS)
                .maxStackSize(1)
                .food(new Food.Builder()
                        .setAlwaysEdible()
                        .build()
                )
        );
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 15;
    }

    @Nullable
    @Override
    public ImmutableList<Pair<ItemStack, Boolean>> itemsToGive() {
        return ImmutableList.of(new Pair<>(ModItems.BEER_GLASS.get().getDefaultInstance(), true));
    }

    @Override
    public void playSound(World world, PlayerEntity playerEntity) {

    }
}
