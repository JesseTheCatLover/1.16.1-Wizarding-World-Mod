package com.enchantedguys.wizardingworldmod.common.items.foods;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import com.enchantedguys.wizardingworldmod.common.util.ModMath;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;


public class BertieBottsBeans extends Item {
    public BertieBottsBeans() {
        super(new Item.Properties()
                .group(WizardingWorldMod.FOODS)
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        return DrinkHelper.func_234707_a_(worldIn, playerIn, handIn);
    }


    @Override
    public int getUseDuration(ItemStack stack) {
        return 10;
    }

    // Prepare picking beans
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;

        // Default itemStack Variable
        ItemStack itemStack = null;

        for (int x = ModMath.getRandomNumberWithinIntRange(7, 9); x > 0; x--) {


            BeansItem.setColor(itemStack, BeansItem.BeansColor.VALUES[worldIn.getRandom().nextInt(BeansItem.BeansColor.VALUES.length)]);


        if (playerentity.getHeldItemMainhand().isEmpty()) {
            playerentity.setHeldItem(Hand.MAIN_HAND, new ItemStack(itemStack.getItem()));
        } else if (!playerentity.inventory.addItemStackToInventory(new ItemStack(itemStack.getItem()))) {
            playerentity.dropItem(new ItemStack(itemStack.getItem()), false);
        }
    }
            worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
                    playerentity.getPosZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, null,
                    0.8F, 2.1F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);

        if (playerentity != null) {
            playerentity.addStat(Stats.ITEM_USED.get(this));
            stack.shrink(1);

            }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}