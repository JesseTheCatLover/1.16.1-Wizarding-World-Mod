package com.enchantedguys.wizardingworldmod.common.init;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WizardingWorldMod.MOD_ID);

    // Blocks
    public static final RegistryObject<Block> WIZARDING_BENCH = registerDefaultBlock("wizarding_bench", AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2.5F, 14F));
    public static final RegistryObject<Block> OBSIDIAN_BRICKS = registerDefaultBlock("obsidian_bricks", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1200f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3).setRequiresTool().setLightLevel(value -> 8));
    public static final RegistryObject<Block> BLACK_OBSIDIAN_BRICKS = registerColoredObsidianBricks("black");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_BRICKS = registerColoredObsidianBricks("blue");
    public static final RegistryObject<Block> BROWN_OBSIDIAN_BRICKS = registerColoredObsidianBricks("brown");
    public static final RegistryObject<Block> CYAN_OBSIDIAN_BRICKS = registerColoredObsidianBricks("cyan");
    public static final RegistryObject<Block> GRAY_OBSIDIAN_BRICKS = registerColoredObsidianBricks("gray");
    public static final RegistryObject<Block> GREEN_OBSIDIAN_BRICKS = registerColoredObsidianBricks("green");
    public static final RegistryObject<Block> LIGHT_BLUE_OBSIDIAN_BRICKS = registerColoredObsidianBricks("light_blue");
    public static final RegistryObject<Block> LIGHT_GRAY_OBSIDIAN_BRICKS = registerColoredObsidianBricks("light_gray");
    public static final RegistryObject<Block> LIME_OBSIDIAN_BRICKS = registerColoredObsidianBricks("lime");
    public static final RegistryObject<Block> MAGENTA_OBSIDIAN_BRICKS = registerColoredObsidianBricks("magenta");
    public static final RegistryObject<Block> ORANGE_OBSIDIAN_BRICKS = registerColoredObsidianBricks("orange");
    public static final RegistryObject<Block> PINK_OBSIDIAN_BRICKS = registerColoredObsidianBricks("pink");
    public static final RegistryObject<Block> RED_OBSIDIAN_BRICKS = registerColoredObsidianBricks("red");
    public static final RegistryObject<Block> WHITE_OBSIDIAN_BRICKS = registerColoredObsidianBricks("white");
    public static final RegistryObject<Block> YELLOW_OBSIDIAN_BRICKS = registerColoredObsidianBricks("yellow");

    /**
     * Use this to register a block
     *
     * @param name       - the resource name
     * @param properties - the block properties
     * @return
     */
    private static RegistryObject<Block> registerDefaultBlock(String name, AbstractBlock.Properties properties) {
        return BLOCKS.register(name, () -> new Block(properties));
    }

    private static RegistryObject<Block> registerColoredObsidianBricks(String color) {
        return registerDefaultBlock(color + "_obsidian_bricks", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1200f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3).setRequiresTool().setLightLevel(value -> 8));
    }


}

