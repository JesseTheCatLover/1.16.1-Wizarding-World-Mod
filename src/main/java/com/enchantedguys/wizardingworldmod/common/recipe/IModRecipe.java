package com.enchantedguys.wizardingworldmod.common.recipe;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface IModRecipe<W extends RecipeWrapper> extends IRecipe<W> {

    int getWorkingTime();

}
