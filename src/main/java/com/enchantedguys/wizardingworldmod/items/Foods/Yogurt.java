package com.enchantedguys.wizardingworldmod.items.Foods;

import com.enchantedguys.wizardingworldmod.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Yogurt extends Item {
    public Yogurt() {
        super(new Item.Properties()
                .group(WizardingWorldMod.FOODS)
                .maxStackSize(1)
                .food(new Food.Builder()
                        .hunger(2)
                        .saturation(1.2f)
                        .build()
                )
        );
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 10;
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        // Preparing playerentity Variable
        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;

        if (playerentity.getHeldItemMainhand().isEmpty()) {
            playerentity.setHeldItem(Hand.MAIN_HAND, new ItemStack(Items.BOWL));
        } else if (!playerentity.inventory.addItemStackToInventory(new ItemStack(Items.BOWL))) {
            playerentity.dropItem(new ItemStack(Items.BOWL), false);
        }

        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
