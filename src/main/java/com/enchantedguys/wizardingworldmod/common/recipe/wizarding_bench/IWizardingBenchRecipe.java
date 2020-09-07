package com.enchantedguys.wizardingworldmod.common.recipe.wizarding_bench;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.recipe.IMultipleInputOneOutputRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nonnull;

public interface IWizardingBenchRecipe extends IMultipleInputOneOutputRecipe {

    ResourceLocation TYPE_ID = WizardingWorldMod.rl("wizarding_bench");


    @Nonnull
    @Override
    default IRecipeType<?> getType() {
        return Registry.RECIPE_TYPE.getValue(TYPE_ID).get();
    }
}
