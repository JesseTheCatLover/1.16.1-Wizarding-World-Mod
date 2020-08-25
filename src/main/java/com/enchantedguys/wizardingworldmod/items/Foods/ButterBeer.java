package com.enchantedguys.wizardingworldmod.items.Foods;

import com.enchantedguys.wizardingworldmod.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ButterBeer extends Item {
    public ButterBeer() {
        super(new Item.Properties()
                .group(WizardingWorldMod.FOODS)
                .maxStackSize(1)
                .food(new Food.Builder()
                        .hunger(8)
                        .saturation(14f)
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
        return 60;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (stack.isEmpty()) {
            return new ItemStack(ModItems.BEER_GLASS.get());
        } else {
            if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
                ItemStack itemstack = new ItemStack(ModItems.BEER_GLASS.get());
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
