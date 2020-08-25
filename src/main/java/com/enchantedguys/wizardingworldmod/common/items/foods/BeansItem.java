package com.enchantedguys.wizardingworldmod.common.items.foods;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BeansItem extends BaseFoodItem {

    public static final String NBT_COLOR = "Color";

    public BeansItem() {
        super(new Properties()
                .maxStackSize(16)
                .group(WizardingWorldMod.FOODS));
    }

    public static int getPropertyOverrite(ItemStack itemStack, @Nullable World world, @Nullable LivingEntity livingEntity) {
        BeansColor color = getColor(itemStack);
        if (color == null)
            return 0;
        return color.getId();
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isInGroup(group)) {
            for (BeansColor color : BeansColor.VALUES) {
                ItemStack subItemStack = new ItemStack(this, 1);
                setColor(subItemStack, color);
                items.add(subItemStack);
            }
        }
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return super.getTranslationKey(stack) + "." + Objects.requireNonNull(getColor(stack)).getName();
    }

    /*
                    Override the default code, but with our food
                */
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!this.isFood())
            return stack;
        BeansColor color = getColor(stack);
        if (color == null)
            return stack;
        Food food = getFoodByColor(color);
        worldIn.playSound(null, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.NEUTRAL, 1.0F, 1.0F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.4F);
        for (Pair<EffectInstance, Float> pair : food.getEffects()) {
            if (!worldIn.isRemote && pair.getFirst() != null && worldIn.rand.nextFloat() < pair.getSecond())
                entityLiving.addPotionEffect(new EffectInstance(pair.getFirst()));
        }
        if (!(entityLiving instanceof PlayerEntity) || !((PlayerEntity) entityLiving).abilities.isCreativeMode)
            stack.shrink(1);
        return stack;
    }

    /**
     * If the stack has no color then it returned null
     *
     * @param stack - the stack to get the color
     * @return the color
     */
    @Nullable
    public static BeansColor getColor(ItemStack stack) {
        if (!hasColor(stack))
            return null;
        CompoundNBT tag = stack.getTag();
        return BeansColor.getById(tag.getInt(NBT_COLOR));
    }

    /**
     * Set the color for the stack
     *
     * @param stack the stack to set the color
     * @param color the color
     */
    public static void setColor(ItemStack stack, BeansColor color) {
        CompoundNBT tag = stack.getOrCreateTag();
        tag.putInt(NBT_COLOR, color.getId());
        stack.setTag(tag);
    }

    private static Food getFoodByColor(BeansColor color) {
        switch (color) {
            case BLACK:
            default:
                return FoodList.BLACK_BEAN;
            case BLUE:
                return FoodList.BLUE_BEAN;
            case BROWN:
                return FoodList.BROWN_BEAN;
            case CYAN:
                return FoodList.CYAN_BEAN;
            case GREEN:
                return FoodList.GREEN_BEAN;
            case GREY:
                return FoodList.GREY_BEAN;
            case LIGHT_BLUE:
                return FoodList.LIGHT_BLUE_BEAN;
            case LIGHT_GREY:
                return FoodList.LIGHT_GREY_BEAN;
            case LIME:
                return FoodList.LIME_BEAN;
            case ORANGE:
                return FoodList.ORANGE_BEAN;
            case PINK:
                return FoodList.PINK_BEAN;
            case PURPLE:
                return FoodList.PURPLE_BEAN;
            case TAN:
                return FoodList.TAN_BEAN;
            case WHITE:
                return FoodList.WHITE_BEAN;
            case YELLOW:
                return FoodList.YELLOW_BEAN;
        }
    }

    /**
     * Checks if the stack has the NBT_COLOR tag
     *
     * @param stack the stack to check
     * @return true if the stack has a color, and false if not
     */
    public static boolean hasColor(ItemStack stack) {
        if (stack.getTag() == null)
            return false;
        return stack.getTag().contains(NBT_COLOR);
    }

    public enum BeansColor implements IStringSerializable {

        BLACK(0, "black", Color.BLACK),
        BLUE(1, "blue", Color.BLUE),
        BROWN(2, "brown", new Color(139, 69, 19)),
        CYAN(3, "cyan", Color.CYAN),
        GREEN(4, "green", Color.GREEN),
        GREY(5, "grey", Color.GRAY),
        LIGHT_BLUE(6, "light_blue", new Color(51, 153, 255)),
        LIGHT_GREY(7, "light_grey", Color.LIGHT_GRAY),
        LIME(8, "lime", new Color(0, 204, 102)),
        ORANGE(9, "orange", Color.ORANGE),
        PINK(10, "pink", Color.PINK),
        PURPLE(11, "purple", new Color(128, 0, 128)),
        TAN(12, "tan", new Color(210, 180, 140)),
        WHITE(13, "white", Color.WHITE),
        YELLOW(14, "yellow", Color.YELLOW);

        private static final BeansColor[] VALUES = values();

        private static final Map<Integer, BeansColor> BY_ID = Arrays.stream(values()).collect(Collectors.toMap(BeansColor::getId, (id) -> id));

        private int id;
        private String name;
        private Color color;

        BeansColor(int id, String name, Color color) {
            this.id = id;
            this.name = name;
            this.color = color;
        }

        @Override
        public String getString() {
            return this.name;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public Color getColor() {
            return color;
        }

        public static BeansColor getById(int id) {
            if (id < 0 || id > VALUES.length)
                throw new IndexOutOfBoundsException("Id for beans color not found: " + id);
            return BY_ID.get(id);
        }
    }

    public static class BeansItemColor implements IItemColor {

        @Override
        public int getColor(ItemStack stack, int tintIndex) {
            {
                if (tintIndex == 0) {
                    BeansColor beansColor = BeansItem.getColor(stack);
                    return beansColor.getColor().getRGB();
                }
                return Color.BLACK.getRGB();
            }
        }
    }

}
