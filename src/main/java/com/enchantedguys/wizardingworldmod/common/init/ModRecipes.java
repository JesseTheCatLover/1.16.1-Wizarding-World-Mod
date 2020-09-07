package com.enchantedguys.wizardingworldmod.common.init;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.recipe.serializer.WizardingBenchRecipeSerializer;
import com.enchantedguys.wizardingworldmod.common.recipe.wizarding_bench.IWizardingBenchRecipe;
import com.enchantedguys.wizardingworldmod.common.recipe.wizarding_bench.WizardingBenchRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModRecipes {

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, WizardingWorldMod.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<IWizardingBenchRecipe>> WIZARDING_BENCH_SERIALIZER =
            registerSerializer(IWizardingBenchRecipe.TYPE_ID, () -> new WizardingBenchRecipeSerializer<>(WizardingBenchRecipe::new));

    public static final RecipeType<IWizardingBenchRecipe> WIZARDING_BENCH = registerType(IWizardingBenchRecipe.TYPE_ID);

    private static <T extends IRecipeType<?>> T registerType(ResourceLocation id) {
        return (T) Registry.register(Registry.RECIPE_TYPE, id, new RecipeType<>());
    }

    private static <T extends IRecipe<?>, S extends IRecipeSerializer<T>> RegistryObject<IRecipeSerializer<T>> registerSerializer(ResourceLocation id, Supplier<? extends S> supplier) {
        return RECIPE_SERIALIZER.register(id.getPath(), supplier);
    }

    private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

}
