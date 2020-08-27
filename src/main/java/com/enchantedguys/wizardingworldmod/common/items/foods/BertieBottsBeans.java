package com.enchantedguys.wizardingworldmod.common.items.foods;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import com.enchantedguys.wizardingworldmod.common.items.ConsumeItem;
import com.google.common.collect.ImmutableList;
import javafx.util.Pair;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;


public class BertieBottsBeans extends ConsumeItem {
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

    @Nullable
    @Override
    public ImmutableList<Pair<ItemStack, Boolean>> itemsToGive() {
        ItemStack itemStack = ModItems.BEANS.get().getDefaultInstance().copy();
        itemStack = BeansItem.setColor(itemStack, BeansItem.BeansColor.VALUES[new Random().nextInt(BeansItem.BeansColor.VALUES.length)]);
        return ImmutableList.of(new Pair<>(itemStack, true));
    }

    @Override
    public void playSound(World worldIn, PlayerEntity playerentity) {
        worldIn.playSound(null, playerentity.getPosX(), playerentity.getPosY(),
                playerentity.getPosZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, null,
                0.8F, 2.1F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
    }
}