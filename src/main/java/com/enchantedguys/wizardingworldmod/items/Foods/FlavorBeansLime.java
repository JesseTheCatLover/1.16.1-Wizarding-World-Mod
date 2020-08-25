package com.enchantedguys.wizardingworldmod.items.Foods;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FlavorBeansLime extends Item {
    public FlavorBeansLime() {
        super(new Properties()
                .maxStackSize(16)
                .food(new Food.Builder()
                        .hunger(1)
                        .effect(new EffectInstance(Effects.NAUSEA, 25 * 5, 1 ),1.0f)
                        .setAlwaysEdible()
                        .build()
                ));
    }
}
