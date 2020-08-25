package com.enchantedguys.wizardingworldmod.common.items;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WaterGlass extends Item {
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

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

        if (playerentity.getHeldItemMainhand().isEmpty()) {
            playerentity.setHeldItem(Hand.MAIN_HAND, new ItemStack(ModItems.BEER_GLASS.get()));
        } else if (!playerentity.inventory.addItemStackToInventory(new ItemStack(ModItems.BEER_GLASS.get()))) {
            playerentity.dropItem(new ItemStack(ModItems.BEER_GLASS.get()), false);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
