package com.enchantedguys.wizardingworldmod.common.recipe;

import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface IMultipleInputOneOutputRecipe extends IModRecipe<RecipeWrapper> {

    @Override
    default boolean canFit(int width, int height) {
        return false;
    }

    Ingredient[] getInputs();

}
