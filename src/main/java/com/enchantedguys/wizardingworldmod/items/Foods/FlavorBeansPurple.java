package com.enchantedguys.wizardingworldmod.items.Foods;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FlavorBeansPurple extends Item {
    public FlavorBeansPurple() {
        super(new Properties()
                .maxStackSize(16)
                .food(new Food.Builder()
                        .hunger(1)
                        .effect(new EffectInstance(Effects.NIGHT_VISION, 25 * 7, 1 ),1.0f)
                        .setAlwaysEdible()
                        .build()
                ));
    }
}
