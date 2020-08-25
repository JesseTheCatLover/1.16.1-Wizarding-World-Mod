package com.enchantedguys.wizardingworldmod.items.Foods;

import com.enchantedguys.wizardingworldmod.WizardingWorldMod;
import net.minecraft.item.Item;

public class ChocolateFrogCard extends Item {
    public ChocolateFrogCard() {
        super(new Item.Properties()
                .group(WizardingWorldMod.FOODS)
                .maxStackSize(1)
        );
    }
}
