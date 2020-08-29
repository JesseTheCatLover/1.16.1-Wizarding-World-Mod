package com.enchantedguys.wizardingworldmod.common.items.foods;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import com.enchantedguys.wizardingworldmod.common.items.ConsumeItem;
import com.enchantedguys.wizardingworldmod.common.util.Pair;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Random;


public class BertieBottsBeans extends ConsumeItem {

    public static final String NBT_BEANS = "BeanIDs";

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

    @Override
    public boolean shouldShrink(ItemStack stack) {
        CompoundNBT tag = stack.getTag();
        if(tag == null)
            return true;
        int[] beans = getBeans(tag.getString(NBT_BEANS));
        return beans == null;
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack itemStack = new ItemStack(this);
        CompoundNBT tag = itemStack.getOrCreateTag();
        tag.putString(NBT_BEANS, randomBeans());
        itemStack.setTag(tag);
        return itemStack;
    }


    @Nullable
    @Override
    public ImmutableList<Pair<ItemStack, Boolean>> itemsToGive(ItemStack stack) {
        return ImmutableList.of(new Pair<>(getRandomBean(stack), true));
    }

    @Override
    public void playSound(World worldIn, PlayerEntity playerentity) {
        worldIn.playSound(null, playerentity.getPosX(), playerentity.getPosY(),
                playerentity.getPosZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, null,
                0.8F, 2.1F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
    }

    @Nullable
    public static ItemStack getRandomBean(ItemStack stack) {
        CompoundNBT tag = stack.getTag();
        if(tag == null)
            tag = new CompoundNBT();
        int[] beans = getBeans(tag.contains(NBT_BEANS) ? tag.getString(NBT_BEANS) : randomBeans());
        if(beans == null)
            return ItemStack.EMPTY;
        Random random = new Random();
        int beansId = beans[random.nextInt(beans.length)];
        ItemStack beanStack = ModItems.BEANS.get().getDefaultInstance().copy();
        beanStack = BeansItem.setColor(beanStack, BeansItem.BeansColor.getById(beansId));
        int[] newBeansId = removeOne(beans, beansId);
        tag.remove(NBT_BEANS);
        tag.putString(NBT_BEANS, Arrays.toString(newBeansId).replace("[", "").replace("]", ""));
        stack.setTag(tag);
        return beanStack;
    }

    private static int[] removeOne(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                array[i] = -1;
                break;
            }
        }
        int[] result = new int[array.length - 1];
        for(int i = 0; i < array.length; i++) {
            int current = array[i];
            if(current == -1)
                continue;
            result[i] = array[i];
        }
        return result;
    }

    private static int[] getBeans(String string) {
        string = string.trim();
        String[] splitted = string.split(",");
        if(splitted.length == 0)
            return null;
        int[] beans = new int[splitted.length];
        for(int i = 0; i < beans.length; i++)
            beans[i] = Integer.parseInt(splitted[i]);
        return beans;
    }

    private static String randomBeans() {
        Random random = new Random();
        int[] cache = new int[7];
        Arrays.fill(cache, -1);
        for (int i = 0; i < cache.length; i++) {
            int beanId;
            do {
                beanId = BeansItem.BeansColor.VALUES[random.nextInt(BeansItem.BeansColor.VALUES.length)].getId();
            } while (containsDuplicate(cache, beanId));
        }
        String res = Arrays.toString(cache);
        return res.replace("[", "").replace("]", "");
    }

    private static boolean containsDuplicate(int[] cache, int i) {
        for (int j : cache)
            if (j == i)
                return true;
        return false;
    }

}