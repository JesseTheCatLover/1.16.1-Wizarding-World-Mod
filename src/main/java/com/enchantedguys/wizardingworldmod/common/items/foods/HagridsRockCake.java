package com.enchantedguys.wizardingworldmod.common.items.foods;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HagridsRockCake extends Item {
    public HagridsRockCake() {
        super(new Item.Properties()
                .group(WizardingWorldMod.FOODS)
                .maxStackSize(64)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(0.4f)
                        .build()
                )
        );
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 60;
    }
}
