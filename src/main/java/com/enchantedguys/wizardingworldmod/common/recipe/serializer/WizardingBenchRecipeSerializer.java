package com.enchantedguys.wizardingworldmod.common.recipe.serializer;

import com.enchantedguys.wizardingworldmod.common.handling.CharmBookTypeRegister;
import com.enchantedguys.wizardingworldmod.common.items.charmbooks.ICharmBook;
import com.enchantedguys.wizardingworldmod.common.items.wands.AbstractWandItem;
import com.enchantedguys.wizardingworldmod.common.recipe.wizarding_bench.IWizardingBenchRecipe;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class WizardingBenchRecipeSerializer<T extends IWizardingBenchRecipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {

    private IFactory<? extends IRecipe<?>> factory;

    public WizardingBenchRecipeSerializer(IFactory<T> factory) {
        this.factory = factory;
    }


    @Override
    public T read(ResourceLocation recipeId, JsonObject json) {
        Ingredient[] inputs = new Ingredient[2];
        for (int i = 0; i < inputs.length; i++)
            inputs[i] = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input_" + i));
        JsonObject outputStackObj = json.getAsJsonObject("output");
        ItemStack outputStack = CraftingHelper.getItemStack(JSONUtils.getJsonObject(outputStackObj, "output_item"), true);
        String charmBookId = JSONUtils.getString(outputStackObj, "charm_book");
        ICharmBook book = CharmBookTypeRegister.findById(charmBookId);
        if (book == null)
            throw new NullPointerException("Charm book with id: " + charmBookId + " not found");
        AbstractWandItem.setCharmBook(outputStack, book);
        return (T) factory.create(recipeId, inputs, outputStack);
    }

    @Nullable
    @Override
    public T read(ResourceLocation recipeId, PacketBuffer buffer) {
        Ingredient[] inputs = new Ingredient[2];
        for (int i = 0; i < inputs.length; i++)
            inputs[i] = Ingredient.read(buffer);
        return (T) factory.create(recipeId, inputs, buffer.readItemStack());
    }

    @Override
    public void write(PacketBuffer buffer, T recipe) {
        for (Ingredient in : recipe.getInputs())
            in.write(buffer);
        buffer.writeItemStack(recipe.getRecipeOutput());
    }

    public interface IFactory<T extends IWizardingBenchRecipe> {
        T create(ResourceLocation recipeId, Ingredient[] inputs, ItemStack output);
    }
}
