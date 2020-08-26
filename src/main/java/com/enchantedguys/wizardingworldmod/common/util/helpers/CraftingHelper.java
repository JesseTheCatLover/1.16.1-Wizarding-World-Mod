package com.enchantedguys.wizardingworldmod.common.util.helpers;

import com.enchantedguys.wizardingworldmod.common.recipe.IModRecipe;
import com.google.common.collect.Sets;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import java.util.Set;
import java.util.stream.Collectors;

public class CraftingHelper {

    public static <T extends RecipeWrapper, R extends IRecipe<T>> Set<IModRecipe<T>> findModRecipesByType(IRecipeType<R> type, World world) {
        Set<IRecipe<?>> recipes = world.getRecipeManager().getRecipes().stream().filter(r -> r.getType() == type).collect(Collectors.toSet());
        Set<IModRecipe<T>> modRecipes = Sets.newHashSet();
        for (IRecipe<?> rec : recipes) {
            if (rec instanceof IModRecipe)
                modRecipes.add((IModRecipe<T>) rec);
        }
        return modRecipes;
    }

}
