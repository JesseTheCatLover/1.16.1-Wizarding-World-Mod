package com.enchantedguys.wizardingworldmod.items;

import com.enchantedguys.wizardingworldmod.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.init.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Random;


/**
*  This Item is used to summon the voldemort
 */
public class BottleOfBlood extends Item {
    public BottleOfBlood() {
        super(new Item.Properties()
                .group(WizardingWorldMod.MATERIALS)
                .maxStackSize(1)

                );
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
            if (playerentity instanceof ServerPlayerEntity) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) playerentity, stack);
            }

            if (!worldIn.isRemote) {
                Random rand = new Random();
                double random = rand.nextDouble();

                if (random <= 1.0f) {
                    entityLiving.addPotionEffect(new EffectInstance(Effects.HUNGER, 60, 7));
                }

                if (random <= 0.6f) {
                    entityLiving.addPotionEffect(new EffectInstance(Effects.POISON, 30, 2));
                }

                if (random <= 0.4f) {
                    entityLiving.addPotionEffect(new EffectInstance(Effects.NAUSEA, 130, 2));
                }

            }

            if (playerentity != null) {
                playerentity.addStat(Stats.ITEM_USED.get(this));
                if (!playerentity.abilities.isCreativeMode) {
                    stack.shrink(1);
                }
            }

            if (playerentity == null || !playerentity.abilities.isCreativeMode) {
                if (stack.isEmpty()) {
                    return new ItemStack(Items.GLASS_BOTTLE);
                }

                if (playerentity != null) {
                    playerentity.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
                }
            }

        return stack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getUseDuration(ItemStack stack) {
        return 20;
    }


    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }


    /**
     * Called to trigger the item's innate right click behavior. To handle when this item is used on a Block
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return DrinkHelper.func_234707_a_(worldIn, playerIn, handIn);
    }

}
