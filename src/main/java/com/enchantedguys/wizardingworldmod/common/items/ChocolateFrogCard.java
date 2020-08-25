package com.enchantedguys.wizardingworldmod.common.items;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.item.Item;

public class ChocolateFrogCard extends Item {
    public ChocolateFrogCard() {
        super(new Item.Properties()
                .group(WizardingWorldMod.FOODS)
                .maxStackSize(1)
        );
    }
}