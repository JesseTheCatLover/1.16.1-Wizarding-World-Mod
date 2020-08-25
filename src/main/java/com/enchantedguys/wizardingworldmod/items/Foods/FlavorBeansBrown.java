package com.enchantedguys.wizardingworldmod.items.Foods;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FlavorBeansBrown extends Item {
    public FlavorBeansBrown() {
        super(new Properties()
                .maxStackSize(16)
                .food(new Food.Builder()
                        .hunger(1)
                        .effect(new EffectInstance(Effects.WEAKNESS, 25 * 5, 1 ),1.0f)
                        .setAlwaysEdible()
                        .build()
                ));
    }
}
