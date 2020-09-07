package com.enchantedguys.wizardingworldmod.common.recipe.wizarding_bench;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class WizardingBenchRecipe implements IWizardingBenchRecipe{

    private final ResourceLocation id;
    private final Ingredient[] inputs;
    private final ItemStack output;

    public WizardingBenchRecipe(ResourceLocation id, Ingredient[] inputs, ItemStack output) {
        this.id = id;
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public Ingredient[] getInputs() {
        return this.inputs;
    }

    @Override
    public int getWorkingTime() {
        return -1;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        for(int i = 0; i < inputs.length; i++)
            try {
                if(!inputs[i].test(inv.getStackInSlot(i)))
                    return false;
            } catch (Exception e) {
                WizardingWorldMod.LOGGER.error("Can not match recipe with id: " + id.getPath());
                return false;
            }
        return true;
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return this.output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return null;
    }
}
