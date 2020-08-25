package com.enchantedguys.wizardingworldmod.items.Foods;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FlavorBeansBlack extends Item {
    public FlavorBeansBlack() {
        super(new Item.Properties()
                .maxStackSize(16)
                .food(new Food.Builder()
                        .hunger(1)
                        .effect(new EffectInstance(Effects.WITHER, 25 * 5, 1 ),1.0f)
                        .setAlwaysEdible()
                        .build()
                ));
    }
}
