package com.enchantedguys.wizardingworldmod.common.items.foods;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import com.enchantedguys.wizardingworldmod.common.items.ConsumeItem;
import com.enchantedguys.wizardingworldmod.common.util.Pair;
import com.enchantedguys.wizardingworldmod.common.util.math.ModMath;
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
import java.util.stream.IntStream;


public class BertieBottsBeans extends ConsumeItem {

    public static final String NBT_BEANS = "BeanIDs";
    public static final String NBT_COUNT = "BeanCount";

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
        if (tag == null)
            return true;
        int[] beans = getBeans(tag.getString(NBT_BEANS));
        return beans == null;
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack itemStack = new ItemStack(this);
        CompoundNBT tag = itemStack.getOrCreateTag();
        tag.putString(NBT_BEANS, randomBeans());
        tag.putInt(NBT_COUNT, ModMath.getRandomNumberWithinIntRange(7, 9));
        itemStack.setTag(tag);
        return itemStack;
    }


    @Nullable
    @Override
    public ImmutableList<Pair<ItemStack, Boolean>> itemsToGive(ItemStack stack) {
        ItemStack beanStack = getRandomBean(stack);
        if (stack.isEmpty())
            return null;
        return ImmutableList.of(new Pair<>(beanStack, true));
    }

    @Override
    public void playSound(World worldIn, PlayerEntity playerentity) {
        worldIn.playSound(null, playerentity.getPosX(), playerentity.getPosY(),
                playerentity.getPosZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, null,
                0.8F, 2.1F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
    }

    public static ItemStack getRandomBean(ItemStack stack) {
        CompoundNBT tag = stack.getOrCreateTag();
        int count = getBeanCount(stack);
        if (count == -1) {
            count = ModMath.getRandomNumberWithinIntRange(7, 9);
            setBeanCount(stack, count);
        }
        if(count == 0)
            return ItemStack.EMPTY;
        int[] beans = getBeans(tag.contains(NBT_BEANS) ? tag.getString(NBT_BEANS) : randomBeans());
        if (beans == null)
            return ItemStack.EMPTY;
        Random random = new Random();
        int beansId = beans[random.nextInt(beans.length)];
        ItemStack beanStack = ModItems.BEANS.get().getDefaultInstance().copy();
        beanStack = BeansItem.setColor(beanStack, BeansItem.BeansColor.getById(beansId));
        int[] newBeansId = removeOne(beans, beansId);
        tag.putString(NBT_BEANS, intArrayToString(newBeansId));
        stack.setTag(tag);
        setBeanCount(stack, --count);
        return beanStack;
    }

    private static int[] removeOne(int[] array, int value) {
        return IntStream.range(0, array.length).filter(i -> i != value).map(i -> array[i]).toArray(); //Using IntStream now
    }

    private static int[] getBeans(String string) {
        if (string.equalsIgnoreCase("none"))
            return null;
        String[] splitted = string.split(":");
        if (splitted.length == 0)
            return null;
        int[] beans = new int[splitted.length];
        for (int i = 0; i < beans.length; i++)
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
            cache[i] = beanId;
        }
        return intArrayToString(cache);
    }

    private static String intArrayToString(int[] array) {
        if (array.length == 0)
            return "none";
        StringBuilder builder = new StringBuilder();
        for (int c : array)
            builder.append(c).append(":");
        return builder.substring(0, builder.length() - 1);
    }

    private static int getBeanCount(ItemStack stack) {
        if (stack.getTag() == null || !stack.getTag().contains(NBT_COUNT))
            return -1;
        return stack.getTag().getInt(NBT_COUNT);
    }

    private static void setBeanCount(ItemStack stack, int newCount) {
        CompoundNBT nbt = stack.getTag();
        if (nbt == null)
            nbt = new CompoundNBT();
        nbt.putInt(NBT_COUNT, newCount);
        stack.setTag(nbt);
    }

    private static boolean containsDuplicate(int[] cache, int i) {
        for (int j : cache)
            if (j == i)
                return true;
        return false;
    }

}