package com.enchantedguys.wizardingworldmod.data;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModBlocks;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Consumer;

public class RecipeDataGen extends RecipeProvider {

    public RecipeDataGen(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(ModItems.BEER_GLASS.get()).key('g', Items.GLASS).patternLine("g g").patternLine("ggg").addCriterion("has_item", hasItem(itemPredicate(Items.GLASS))).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModItems.BERTIE_BOTTS_BEANS.get()).key('p', Items.PAPER).key('f', Items.PUFFERFISH).key('s', Items.SUGAR).patternLine(" p ").patternLine("pfp").patternLine("psp").addCriterion("has_item", hasItem(itemPredicate(Items.PAPER), itemPredicate(Items.PUFFERFISH), itemPredicate(Items.SUGAR))).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.BUTTER.get()).addIngredient(ModItems.YOGURT.get()).addCriterion("has_item", hasItem(itemPredicate(ModItems.YOGURT.get()))).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.BUTTER_BEER.get()).addIngredient(ModItems.WATER_GLASS.get()).addIngredient(ModItems.BUTTER.get()).addIngredient(Items.SUGAR, 2).addCriterion("has_item", hasItem(itemPredicate(ModItems.WATER_GLASS.get()), itemPredicate(ModItems.BUTTER.get()), itemPredicate(Items.SUGAR))).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModItems.GOLDEN_KNIFE.get()).key('x', Items.GOLD_INGOT).key('y', Items.STICK).patternLine(" x ").patternLine(" y ").addCriterion("has_item", hasItem(itemPredicate(Items.GOLD_INGOT), itemPredicate(Items.STICK))).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModItems.HAGRIDS_ROCK_CAKE.get(), 12).key('w', Items.WHEAT).key('c', Items.COCOA_BEANS).key('m', Items.MILK_BUCKET).patternLine("wcw").patternLine(" m ").addCriterion("has_item", hasItem(itemPredicate(Items.WHEAT), itemPredicate(Items.COCOA_BEANS), itemPredicate(Items.MILK_BUCKET))).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModItems.IRON_KNIFE.get()).key('x', Items.IRON_INGOT).key('y', Items.STICK).patternLine(" x ").patternLine(" y ").addCriterion("has_item", hasItem(itemPredicate(Items.IRON_INGOT), itemPredicate(Items.STICK))).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModItems.OBSIDIAN_BRICKS_ITEM.get()).key('x', Items.OBSIDIAN).patternLine("xx").patternLine("xx").addCriterion("has_item", hasItem(itemPredicate(Items.OBSIDIAN))).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.PUMPKIN_JUICE.get()).addIngredient(Items.PUMPKIN).addIngredient(Items.SUGAR).addIngredient(Items.GLASS_BOTTLE).addIngredient(Items.WATER_BUCKET).addCriterion("has_item", hasItem(itemPredicate(Items.PUMPKIN), itemPredicate(Items.SUGAR), itemPredicate(Items.GLASS_BOTTLE), itemPredicate(Items.WATER_BUCKET))).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.WIZARDING_BENCH.get()).key('r', Items.RED_CARPET).key('o', Items.ORANGE_CARPET).key('l', ItemTags.LOGS).key('s', ItemTags.WOODEN_SLABS).key('p', ModItems.PHOENIX_FEATHER.get()).patternLine("ror").patternLine("lpl").patternLine("lsl").addCriterion("has_item", hasItem(itemPredicate(Items.RED_CARPET), itemPredicate(Items.ORANGE_BANNER), tagPredicate(ItemTags.LOGS), tagPredicate(ItemTags.WOODEN_SLABS), itemPredicate(ModItems.PHOENIX_FEATHER.get()))).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.YOGURT.get()).addIngredient(Items.BUCKET).addIngredient(Items.MILK_BUCKET).addIngredient(Items.BOWL).addCriterion("has_item", hasItem(itemPredicate(Items.BUCKET), itemPredicate(Items.MILK_BUCKET), itemPredicate(Items.BOWL))).build(consumer);


        registerColoredObsidianBricks(ModItems.BLACK_OBSIDIAN_BRICKS_ITEM, Items.BLACK_DYE, consumer);
        registerColoredObsidianBricks(ModItems.BLUE_OBSIDIAN_BRICKS_ITEM, Items.BLUE_DYE, consumer);
        registerColoredObsidianBricks(ModItems.BROWN_OBSIDIAN_BRICKS_ITEM, Items.BROWN_DYE, consumer);
        registerColoredObsidianBricks(ModItems.CYAN_OBSIDIAN_BRICKS_ITEM, Items.CYAN_DYE, consumer);
        registerColoredObsidianBricks(ModItems.GRAY_OBSIDIAN_BRICKS_ITEM, Items.GRAY_DYE, consumer);
        registerColoredObsidianBricks(ModItems.GREEN_OBSIDIAN_BRICKS_ITEM, Items.GREEN_DYE, consumer);
        registerColoredObsidianBricks(ModItems.LIGHT_BLUE_OBSIDIAN_BRICKS_ITEM, Items.LIGHT_BLUE_DYE, consumer);
        registerColoredObsidianBricks(ModItems.LIGHT_GRAY_OBSIDIAN_BRICKS_ITEM, Items.LIGHT_GRAY_DYE, consumer);
        registerColoredObsidianBricks(ModItems.LIME_OBSIDIAN_BRICKS_ITEM, Items.LIME_DYE, consumer);
        registerColoredObsidianBricks(ModItems.MAGENTA_OBSIDIAN_BRICKS_ITEM, Items.MAGENTA_DYE, consumer);
        registerColoredObsidianBricks(ModItems.ORANGE_OBSIDIAN_BRICKS_ITEM, Items.ORANGE_DYE, consumer);
        registerColoredObsidianBricks(ModItems.PINK_OBSIDIAN_BRICKS_ITEM, Items.PINK_DYE, consumer);
        registerColoredObsidianBricks(ModItems.RED_OBSIDIAN_BRICKS_ITEM, Items.RED_DYE, consumer);
        registerColoredObsidianBricks(ModItems.WHITE_OBSIDIAN_BRICKS_ITEM, Items.WHITE_DYE, consumer);
        registerColoredObsidianBricks(ModItems.YELLOW_OBSIDIAN_BRICKS_ITEM, Items.YELLOW_DYE, consumer);

    }

    private void registerColoredObsidianBricks(RegistryObject<Item> item, Item dye, Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapelessRecipe(item.get())
                .addIngredient(ModItems.OBSIDIAN_BRICKS_ITEM.get())
                .addIngredient(dye)
                .addCriterion("has_item", hasItem(itemPredicate(ModBlocks.OBSIDIAN_BRICKS.get()), itemPredicate(dye)))
                .build(consumer);
    }

    private ItemPredicate tagPredicate(ITag<Item> tag) {
        return ItemPredicate.Builder.create().tag(tag).build();
    }

    private ItemPredicate itemPredicate(IItemProvider item) {
        return ItemPredicate.Builder.create().item(item).build();
    }
}
