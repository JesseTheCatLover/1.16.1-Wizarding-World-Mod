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

    // Preparing Numbers Of Beans
    int BeansInPocket = 12;

    // Preparing Right Click Event
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

       /* // Preparing playerentity Variable
        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;

        // Default itemStack Variable
        ItemStack itemStack = new ItemStack(ModItems.FLAVOR_BEANS_BLACK.get());

        for (int x = 6; x > 0; x--) {

            if (!playerentity.abilities.isCreativeMode) {
                //BeansInPocket -= 1;
            }

            switch (ModMath.getRandomNumberWithinIntRange(1, 16)) {
                case 1:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_BLACK.get());
                    break;

                case 2:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_BLUE.get());
                    break;

                case 3:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_BROWN.get());
                    break;

                case 4:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_CYAN.get());
                    break;

                case 5:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_GREEN.get());
                    break;

                case 6:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_LIGHT_BLUE.get());
                    break;

                case 7:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_LIGHT_GREY.get());
                    break;

                case 8:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_LIME.get());
                    break;

                case 9:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_ORANGE.get());
                    break;

                case 10:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_PINK.get());
                    break;

                case 11:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_PURPLE.get());
                    break;

                case 12:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_RED.get());
                    break;

                case 13:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_TAN.get());
                    break;

                case 14:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_WHITE.get());
                    break;

                case 15:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_YELLOW.get());
                    break;

                case 16:
                    itemStack = new ItemStack(ModItems.FLAVOR_BEANS_GREY.get());
                    break;

            }

            if (playerentity.getHeldItemMainhand().isEmpty()) {
                playerentity.setHeldItem(Hand.MAIN_HAND, new ItemStack(itemStack.getItem()));
            } else if (!playerentity.inventory.addItemStackToInventory(new ItemStack(itemStack.getItem()))) {
                playerentity.dropItem(new ItemStack(itemStack.getItem()), false);
            }

            worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
                    playerentity.getPosZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, null,
                    0.8F, 2.1F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
        } //else  {
           /* if (playerentity != null && !playerentity.abilities.isCreativeMode) {
                playerentity.addStat(Stats.ITEM_USED.get(this));
                stack.shrink(1);
                BeansInPocket = 12;
        if (playerentity != null && !playerentity.abilities.isCreativeMode) {
            playerentity.addStat(Stats.ITEM_USED.get(this));
            stack.shrink(1);

        }*/
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
