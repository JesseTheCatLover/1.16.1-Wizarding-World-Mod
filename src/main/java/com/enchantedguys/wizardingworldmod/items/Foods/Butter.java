package com.enchantedguys.wizardingworldmod.items.Foods;

import com.enchantedguys.wizardingworldmod.WizardingWorldMod;
import net.minecraft.item.Item;

public class Butter extends Item {
    public Butter() {
        super(new Item.Properties()
                .group(WizardingWorldMod.MATERIALS)
                .maxStackSize(16)
        );
    }
}
