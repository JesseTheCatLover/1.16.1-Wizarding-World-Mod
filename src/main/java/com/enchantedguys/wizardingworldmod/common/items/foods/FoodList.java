package com.enchantedguys.wizardingworldmod.common.items.foods;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodList {

    /**
     * You can change the food if you want
     */

    public static final Food BUTTER_BEAR = build(8, 14);
    public static final Food CHOCOLATE_FROG = build(4, 10);
    public static final Food CHOCOLATE_FROG_CARD = build(6, 12);
    public static final Food HAGRIDS_ROCK_CAKE = build(3, 0.4F);
    public static final Food PUMPKING_JUICE = build(6, 5);
    public static final Food YOGURT = build(2, 1.2F);
    public static final Food BLACK_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.WITHER, 25 * 5, 1), 1));
    public static final Food BLUE_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.SPEED, 25 * 7, 1), 1));
    public static final Food BROWN_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.WEAKNESS, 25 * 5, 1), 1));
    public static final Food CYAN_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.JUMP_BOOST, 25 * 7, 1), 1));
    public static final Food GREEN_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.POISON, 25 * 5, 1), 1));
    public static final Food GREY_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.SLOWNESS, 25 * 5, 1), 1));
    public static final Food LIGHT_BLUE_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.WATER_BREATHING, 25 * 7, 1), 1));
    public static final Food LIGHT_GREY_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.MINING_FATIGUE, 25 * 5, 1), 1));
    public static final Food LIME_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.NAUSEA, 25 * 5, 1), 1));
    public static final Food ORANGE_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 25 * 7, 1), 1));
    public static final Food PINK_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.BLINDNESS, 25 * 5, 1), 1));
    public static final Food PURPLE_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.NIGHT_VISION, 25 * 7, 1), 1));
    public static final Food RED_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.REGENERATION, 25 * 7, 1), 1));
    public static final Food TAN_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.STRENGTH, 25 * 7, 1), 1));
    public static final Food WHITE_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.GLOWING, 25 * 5, 1), 1));
    public static final Food YELLOW_BEAN = build(1, 1.0F, new FoodEffect(new EffectInstance(Effects.HASTE, 25 * 7, 1), 1));


    private static Food build(int hunger, float saturation, FoodEffect effect, boolean fastEat, boolean alwaysEat, boolean meat) {
        Food.Builder builder = new Food.Builder().hunger(hunger).saturation(saturation);
        if (effect != null)
            builder = builder.effect(() -> effect.effect, effect.duration);
        if (fastEat)
            builder = builder.fastToEat();
        if (alwaysEat)
            builder = builder.setAlwaysEdible();
        if (meat)
            builder = builder.meat();

        return builder.build();
    }

    private static Food build(int hunger, float saturation, FoodEffect effect) {
        return build(hunger, saturation, effect, false, false, false);
    }

    private static Food build(int hunger, float saturation) {
        return build(hunger, saturation, null, false, false, false);
    }

    static class FoodEffect {

        public final EffectInstance effect;
        public final int duration;

        public FoodEffect(EffectInstance effect, int duration) {
            this.effect = effect;
            this.duration = duration;
        }

    }

}
