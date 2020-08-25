package com.enchantedguys.wizardingworldmod.common.items.foods;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PumpkinJuice extends Item {
    public PumpkinJuice() {
        super(new Item.Properties()
                .group(WizardingWorldMod.FOODS)
                .maxStackSize(1)
                .food(new Food.Builder()
                        .hunger(6)
                        .saturation(5f)
                        .build())
        );
    }

    // Prepare Animation
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    // Prepare Duration Drink
    @Override
    public int getUseDuration(ItemStack stack) {
        return 20;
    }

    // Prepare Replacing Empty Bottle
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
                ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                PlayerEntity playerentity = (PlayerEntity) entityLiving;
                if (playerentity.getHeldItemMainhand().isEmpty()) {
                    playerentity.setHeldItem(Hand.MAIN_HAND, new ItemStack(itemstack.getItem()));
                } else if (!playerentity.inventory.addItemStackToInventory(new ItemStack(itemstack.getItem()))) {
                    playerentity.dropItem(new ItemStack(itemstack.getItem()), false);
                }
            }

            return super.onItemUseFinish(stack, worldIn, entityLiving);
        }
    }
}