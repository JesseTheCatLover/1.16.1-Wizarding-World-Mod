package com.enchantedguys.wizardingworldmod.common.spells;

import net.minecraft.util.ResourceLocation;

public interface ISpell {

    ResourceLocation getTexture();

    int getSpellId();

    double getExpCostPerUsage();

}
