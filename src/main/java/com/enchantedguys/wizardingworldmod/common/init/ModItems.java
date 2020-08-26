package com.enchantedguys.wizardingworldmod.common.init;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.items.*;
import com.enchantedguys.wizardingworldmod.common.items.charmbooks.KillingCurseCharmBook;
import com.enchantedguys.wizardingworldmod.common.items.foods.*;
import com.enchantedguys.wizardingworldmod.common.items.wands.MrLimnerWand;
import com.enchantedguys.wizardingworldmod.common.items.wands.REDX000Wand;
import com.enchantedguys.wizardingworldmod.common.util.enums.ModBannerPattern;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WizardingWorldMod.MOD_ID);


    // Materials
    public static final RegistryObject<Item> PHOENIX_FEATHER = registerItem("phoenix_feather", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).group(WizardingWorldMod.MATERIALS)));
    public static final RegistryObject<Item> BOTTLE_OF_BLOOD = registerItem("bottle_of_blood", BottleOfBlood::new);
    public static final RegistryObject<Item> BEER_GLASS = registerItem("beer_glass", BeerGlass::new);
    public static final RegistryObject<Item> WATER_GLASS = registerItem("water_glass", WaterGlass::new);

    public static final RegistryObject<Item> BUTTER = registerItem("butter", () -> new Item(new Item.Properties().group(WizardingWorldMod.MATERIALS).maxStackSize(16)));

    // Tools
    public static final RegistryObject<Item> IRON_KNIFE = registerItem("iron_knife", () -> new KnifeItem(ItemTier.IRON, 1, 1.2f, new Item.Properties().group(WizardingWorldMod.OTHER)));
    public static final RegistryObject<Item> GOLDEN_KNIFE = ITEMS.register("golden_knife", () -> new KnifeItem(ItemTier.GOLD, 1, 1.2f, new Item.Properties().group(WizardingWorldMod.OTHER)));

    // Foods
    public static final RegistryObject<Item> HAGRIDS_ROCK_CAKE = registerItem("hagrids_rock_cake", HagridsRockCake::new);
    public static final RegistryObject<Item> PUMPKIN_JUICE = registerItem("pumpkin_juice", PumpkinJuice::new);
    public static final RegistryObject<Item> YOGURT = registerItem("yogurt", Yogurt::new);
    public static final RegistryObject<Item> BUTTER_BEER = registerItem("butter_beer", ButterBeer::new);
    public static final RegistryObject<Item> CHOCOLATE_FROG = registerItem("chocolate_frog", ChocolateFrog::new);
    public static final RegistryObject<Item> CHOCOLATE_FROG_CARD = registerItem("chocolate_frog_dumbledoor_card", ChocolateFrogDumbledoreCard::new);
    public static final RegistryObject<Item> BEANS = registerItem("beans", BeansItem::new);

    // Banner Patterns
    public static final RegistryObject<Item> HOGWARTS_BANNER_PATTERN = registerBannerPattern(ModBannerPattern.HOGWARTS);
    public static final RegistryObject<Item> DEATH_EATER_BANNER_PATTERN = registerBannerPattern(ModBannerPattern.DEATH_EATER);
    public static final RegistryObject<Item> GRYFFINDOR_BANNER_PATTERN = registerBannerPattern(ModBannerPattern.GRYFFINDOR);
    public static final RegistryObject<Item> SLYTHERIN_BANNER_PATTERN = registerBannerPattern(ModBannerPattern.SLYTHERIN);
    public static final RegistryObject<Item> HUFFLEPUFP_BANNER_PATTERN = registerBannerPattern(ModBannerPattern.HUFFLEPUFP);
    public static final RegistryObject<Item> RAVENCLAW_BANNER_PATTERN = registerBannerPattern(ModBannerPattern.RAVENCLAW);

    // Music Discs
    public static final RegistryObject<Item> MUSIC_DISC_HARRY_POTTER_THEME = registerItem("music_disc_harry_potter_theme", () -> new MusicDiscItem(14, ModSounds.LAZY_HARRY_POTTER_THEME_MUSIC, new Item.Properties().group(WizardingWorldMod.OTHER).maxStackSize(1).rarity(Rarity.RARE)));

    // Charm Books
    public static final RegistryObject<Item> KILLING_CURSE_CHARM_BOOK = registerItem("killing_curse_charm_book", KillingCurseCharmBook::new);

    // Wands
    public static final RegistryObject<Item> MR_LIMNER_WAND = registerItem("mr_limner_wand", MrLimnerWand::new);
    public static final RegistryObject<Item> RED_X_000_WAND = registerItem("red_x_000_wand", REDX000Wand::new);

    // Block Items -> Registering in the main class
    public static final RegistryObject<Item> WIZARDING_BENCH_ITEM = registerBlockItem("wizarding_bench", ModBlocks.WIZARDING_BENCH, new Item.Properties().group(WizardingWorldMod.CHARMS));
    public static final RegistryObject<Item> OBSIDIAN_BRICKS_ITEM = registerBlockItem("obsidian_bricks", ModBlocks.OBSIDIAN_BRICKS, new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS));
    public static final RegistryObject<Item> BLACK_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("black");
    public static final RegistryObject<Item> BLUE_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("blue");
    public static final RegistryObject<Item> BROWN_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("brown");
    public static final RegistryObject<Item> CYAN_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("cyan");
    public static final RegistryObject<Item> GRAY_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("gray");
    public static final RegistryObject<Item> GREEN_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("green");
    public static final RegistryObject<Item> LIGHT_BLUE_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("light_blue");
    public static final RegistryObject<Item> LIGHT_GRAY_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("light_gray");
    public static final RegistryObject<Item> LIME_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("lime");
    public static final RegistryObject<Item> MAGENTA_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("magenta");
    public static final RegistryObject<Item> ORANGE_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("orange");
    public static final RegistryObject<Item> PINK_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("pink");
    public static final RegistryObject<Item> RED_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("red");
    public static final RegistryObject<Item> WHITE_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("white");
    public static final RegistryObject<Item> YELLOW_OBSIDIAN_BRICKS_ITEM = registerColoredObsidianBlock("yellow");

    public static final RegistryObject<BertieBottsBeans> BERTIE_BOTTS_BEANS = ITEMS.register("bertie_botts_beans", BertieBottsBeans::new);

    public static final Supplier<ImmutableList<ResourceLocation>> BLACKLIST = () -> createBlacklist(WIZARDING_BENCH_ITEM, OBSIDIAN_BRICKS_ITEM);

    private static RegistryObject<Item> registerColoredObsidianBlock(String color) {
        Item.Properties properties = new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS);
        Supplier<Block> supplier = null;
        switch (color) {
            case "black":
                supplier = ModBlocks.BLACK_OBSIDIAN_BRICKS;
            case "blue":
                supplier = ModBlocks.BLUE_OBSIDIAN_BRICKS;
            case "brown":
                supplier = ModBlocks.BROWN_OBSIDIAN_BRICKS;
            case "cyan":
                supplier = ModBlocks.CYAN_OBSIDIAN_BRICKS;
            case "gray":
                supplier = ModBlocks.GRAY_OBSIDIAN_BRICKS;
            case "green":
                supplier = ModBlocks.GREEN_OBSIDIAN_BRICKS;
            case "light_blue":
                supplier = ModBlocks.LIGHT_BLUE_OBSIDIAN_BRICKS;
            case "light_gray":
                supplier = ModBlocks.LIGHT_GRAY_OBSIDIAN_BRICKS;
            case "lime":
                supplier = ModBlocks.LIME_OBSIDIAN_BRICKS;
            case "magenta":
                supplier = ModBlocks.MAGENTA_OBSIDIAN_BRICKS;
            case "orange":
                supplier = ModBlocks.ORANGE_OBSIDIAN_BRICKS;
            case "pink":
                supplier = ModBlocks.PINK_OBSIDIAN_BRICKS;
            case "red":
                supplier = ModBlocks.RED_OBSIDIAN_BRICKS;
            case "white":
                supplier = ModBlocks.WHITE_OBSIDIAN_BRICKS;
            case "yellow":
                supplier = ModBlocks.YELLOW_OBSIDIAN_BRICKS;
        }
        if(supplier == null)
            throw new NullPointerException("Colored obsidian block not found: " + color);
        Supplier<Block> finalSupplier = supplier;
        return ITEMS.register(color + "_obsidian_bricks", () -> new BlockItem(finalSupplier.get(), properties));
    }

    private static RegistryObject<Item> registerDefaultFood(String name, Food food, int amount) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().group(WizardingWorldMod.FOODS).maxStackSize(amount).food(food)));
    }

    private static RegistryObject<Item> registerItem(String name, Supplier<? extends Item> supplier) {
        return ITEMS.register(name, supplier);
    }

    private static RegistryObject<Item> registerBannerPattern(ModBannerPattern pattern) {
        return registerItem(pattern.getName() + "_banner_pattern", () -> new BannerPatternItem(BannerPattern.create(String.valueOf(pattern), pattern.getName(), pattern.getHash(),
                pattern.isBool()), new Item.Properties().rarity(Rarity.RARE).group(WizardingWorldMod.OTHER)));
    }

    private static RegistryObject<Item> registerBlockItem(String name, RegistryObject<Block> ro, Item.Properties properties) {
        return ITEMS.register(name, () -> new BlockItem(ro.get(), properties));
    }

    private static ImmutableList<ResourceLocation> createBlacklist(RegistryObject<Item>... objects) {
        List<ResourceLocation> l = Lists.newArrayList();
        for (RegistryObject<Item> ro : objects)
            l.add(ro.get().getRegistryName());

        return ImmutableList.copyOf(l);
    }
}
