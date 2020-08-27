package com.enchantedguys.wizardingworldmod.common.items.foods;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
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

        ItemStack itemStack = ModItems.BEANS.get().getDefaultInstance().copy();
        itemStack = BeansItem.setColor(itemStack, BeansItem.BeansColor.VALUES[worldIn.getRandom().nextInt(BeansItem.BeansColor.VALUES.length)]);

        if (playerentity.getHeldItemMainhand().isEmpty()) {
            playerentity.setHeldItem(Hand.MAIN_HAND, itemStack);
        } else if (!playerentity.inventory.addItemStackToInventory(itemStack)) {
            playerentity.dropItem(itemStack, false);
        }

        worldIn.playSound(null, playerentity.getPosX(), playerentity.getPosY(),
                playerentity.getPosZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, null,
                0.8F, 2.1F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
        playerentity.addStat(Stats.ITEM_USED.get(this));
        stack.shrink(1);

        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}