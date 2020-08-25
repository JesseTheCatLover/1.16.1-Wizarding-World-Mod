package com.enchantedguys.wizardingworldmod.init;

import com.enchantedguys.wizardingworldmod.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WizardingWorldMod.MOD_ID);

    // Blocks

    public static final RegistryObject<Block> WIZARDING_BENCH = BLOCKS.register("wizarding_bench", WizardingBlock::new);

    public static final RegistryObject<Block> BLACK_OBSIDIAN_BRICKS = BLOCKS.register("black_obsidian_bricks", BlackObsidianBricks::new);

    public static final RegistryObject<Block> OBSIDIAN_BRICKS = BLOCKS.register("obsidian_bricks", ObsidianBricks::new);

    public static final RegistryObject<Block> BLUE_OBSIDIAN_BRICKS = BLOCKS.register("blue_obsidian_bricks", BlueObsidianBricks::new);

    public static final RegistryObject<Block> BROWN_OBSIDIAN_BRICKS = BLOCKS.register("brown_obsidian_bricks", BrownObsidianBricks::new);

    public static final RegistryObject<Block> CYAN_OBSIDIAN_BRICKS = BLOCKS.register("cyan_obsidian_bricks", CyanObsidianBricks::new);

    public static final RegistryObject<Block> GRAY_OBSIDIAN_BRICKS = BLOCKS.register("gray_obsidian_bricks", GrayObsidianBricks::new);

    public static final RegistryObject<Block> GREEN_OBSIDIAN_BRICKS = BLOCKS.register("green_obsidian_bricks", GreenObsidianBricks::new);

    public static final RegistryObject<Block> LIGHT_BLUE_OBSIDIAN_BRICKS = BLOCKS.register("light_blue_obsidian_bricks", LightBlueObsidianBricks::new);

    public static final RegistryObject<Block> LIGHT_GRAY_OBSIDIAN_BRICKS = BLOCKS.register("light_gray_obsidian_bricks", LightGrayObsidianBricks::new);

    public static final RegistryObject<Block> LIME_OBSIDIAN_BRICKS = BLOCKS.register("lime_obsidian_bricks", LimeObsidianBricks::new);

    public static final RegistryObject<Block> MAGENTA_OBSIDIAN_BRICKS = BLOCKS.register("magenta_obsidian_bricks", MagentaObsidianBricks::new);

    public static final RegistryObject<Block> ORANGE_OBSIDIAN_BRICKS = BLOCKS.register("orange_obsidian_bricks", OrangeObsidianBricks::new);

    public static final RegistryObject<Block> PINK_OBSIDIAN_BRICKS = BLOCKS.register("pink_obsidian_bricks", PinkObsidianBricks::new);

    public static final RegistryObject<Block> RED_OBSIDIAN_BRICKS = BLOCKS.register("red_obsidian_bricks", RedObsidianBricks::new);

    public static final RegistryObject<Block> WHITE_OBSIDIAN_BRICKS = BLOCKS.register("white_obsidian_bricks", WhiteObsidianBricks::new);

    public static final RegistryObject<Block> YELLOW_OBSIDIAN_BRICKS = BLOCKS.register("yellow_obsidian_bricks", YellowObsidianBricks::new);

}

