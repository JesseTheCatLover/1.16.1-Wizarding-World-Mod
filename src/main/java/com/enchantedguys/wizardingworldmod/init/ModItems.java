package com.enchantedguys.wizardingworldmod.init;

import com.enchantedguys.wizardingworldmod.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.items.BeerGlass;
import com.enchantedguys.wizardingworldmod.items.BottleOfBlood;
import com.enchantedguys.wizardingworldmod.items.CharmBooks.KillingCurseCharmBook;
import com.enchantedguys.wizardingworldmod.items.Foods.*;
import com.enchantedguys.wizardingworldmod.items.KnifeItem;
import com.enchantedguys.wizardingworldmod.items.Wands.MrLimnerWand;
import com.enchantedguys.wizardingworldmod.items.Wands.REDX000Wand;
import com.enchantedguys.wizardingworldmod.items.WaterGlass;
import com.enchantedguys.wizardingworldmod.util.enums.ModBannerPattern;
import net.minecraft.item.*;
import net.minecraft.tileentity.BannerPattern;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WizardingWorldMod.MOD_ID);

    // Materials

    public static final RegistryObject<Item> PHOENIX_FEATHER = ITEMS.register("phoenix_feather",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).group(WizardingWorldMod.MATERIALS)));

    public static final RegistryObject<BottleOfBlood> BOTTLE_OF_BLOOD = ITEMS.register("bottle_of_blood", BottleOfBlood::new);

    public static final RegistryObject<BeerGlass> BEER_GLASS = ITEMS.register("beer_glass", BeerGlass::new);

    public static final RegistryObject<WaterGlass> WATER_GLASS = ITEMS.register("water_glass", WaterGlass::new);

    // Tools

    public static final RegistryObject<KnifeItem> IRON_KNIFE = ITEMS.register("iron_knife",
            () -> new KnifeItem(ItemTier.IRON, 1, 1.2f, new Item.Properties().group(WizardingWorldMod.OTHER)));

    public static final RegistryObject<KnifeItem> GOLDEN_KNIFE = ITEMS.register("golden_knife",
            () -> new KnifeItem(ItemTier.GOLD, 1, 1.2f, new Item.Properties().group(WizardingWorldMod.OTHER)));

    // Foods

    public static final RegistryObject<HagridsRockCake> HAGRIDS_ROCK_CAKE = ITEMS.register("hagrids_rock_cake", HagridsRockCake::new );

    public static final RegistryObject<PumpkinJuice> PUMPKIN_JUICE = ITEMS.register("pumpkin_juice", PumpkinJuice::new);

    public static final RegistryObject<BertieBottsBeans> BERTIE_BOTTS_BEANS = ITEMS.register("bertie_botts_beans", BertieBottsBeans::new);

    public static final RegistryObject<FlavorBeansBlack> FLAVOR_BEANS_BLACK = ITEMS.register("flavor_beans_black", FlavorBeansBlack::new);

    public static final RegistryObject<FlavorBeansBlue> FLAVOR_BEANS_BLUE = ITEMS.register("flavor_beans_blue", FlavorBeansBlue::new);

    public static final RegistryObject<FlavorBeansBrown> FLAVOR_BEANS_BROWN = ITEMS.register("flavor_beans_brown", FlavorBeansBrown::new);

    public static final RegistryObject<FlavorBeansCyan> FLAVOR_BEANS_CYAN = ITEMS.register("flavor_beans_cyan", FlavorBeansCyan::new);

    public static final RegistryObject<FlavorBeansGreen> FLAVOR_BEANS_GREEN = ITEMS.register("flavor_beans_green", FlavorBeansGreen::new);

    public static final RegistryObject<FlavorBeansGrey> FLAVOR_BEANS_GREY = ITEMS.register("flavor_beans_grey", FlavorBeansGrey::new);

    public static final RegistryObject<FlavorBeansLightBlue> FLAVOR_BEANS_LIGHT_BLUE = ITEMS.register("flavor_beans_light_blue", FlavorBeansLightBlue::new);

    public static final RegistryObject<FlavorBeansLightGrey> FLAVOR_BEANS_LIGHT_GREY = ITEMS.register("flavor_beans_light_grey", FlavorBeansLightGrey::new);

    public static final RegistryObject<FlavorBeansLime> FLAVOR_BEANS_LIME = ITEMS.register("flavor_beans_lime", FlavorBeansLime::new);

    public static final RegistryObject<FlavorBeansOrange> FLAVOR_BEANS_ORANGE = ITEMS.register("flavor_beans_orange", FlavorBeansOrange::new);

    public static final RegistryObject<FlavorBeansPink> FLAVOR_BEANS_PINK = ITEMS.register("flavor_beans_pink", FlavorBeansPink::new);

    public static final RegistryObject<FlavorBeansPurple> FLAVOR_BEANS_PURPLE = ITEMS.register("flavor_beans_purple", FlavorBeansPurple::new);

    public static final RegistryObject<FlavorBeansRed> FLAVOR_BEANS_RED = ITEMS.register("flavor_beans_red", FlavorBeansRed::new);

    public static final RegistryObject<FlavorBeansTan> FLAVOR_BEANS_TAN = ITEMS.register("flavor_beans_tan", FlavorBeansTan::new);

    public static final RegistryObject<FlavorBeansWhite> FLAVOR_BEANS_WHITE = ITEMS.register("flavor_beans_white", FlavorBeansWhite::new);

    public static final RegistryObject<FlavorBeansYellow> FLAVOR_BEANS_YELLOW = ITEMS.register("flavor_beans_yellow", FlavorBeansYellow::new);

    public static final RegistryObject<Yogurt> YOGURT = ITEMS.register("yogurt", Yogurt::new);

    public static final RegistryObject<Butter> BUTTER = ITEMS.register("butter", Butter::new);

    public static final RegistryObject<ButterBeer> BUTTER_BEER = ITEMS.register("butter_beer", ButterBeer::new);

    public static final RegistryObject<ChocolateFrog> CHOCOLATE_FROG = ITEMS.register("chocolate_frog", ChocolateFrog::new);

    public static final RegistryObject<ChocolateFrogCard> CHOCOLATE_FROG_CARD = ITEMS.register("chocolate_frog_card", ChocolateFrogCard::new);

    // Banner Patterns

    public static final RegistryObject<BannerPatternItem> HOGWARTS_BANNER_PATTERN =
            ITEMS.register("hogwarts_banner_pattern",
                    () -> new BannerPatternItem(BannerPattern.create(String.valueOf(ModBannerPattern.HOGWARTS), "hogwarts","hog",true)
                            ,new Item.Properties().rarity(Rarity.RARE).group((WizardingWorldMod.OTHER))));

    public static final RegistryObject<BannerPatternItem> DEATH_EATER_BANNER_PATTERN =
            ITEMS.register("death_eater_banner_pattern",
                    () -> new BannerPatternItem(BannerPattern.create(String.valueOf(ModBannerPattern.DEATH_EATER), "death_eater","dea",true)
                            ,new Item.Properties().rarity(Rarity.RARE).group((WizardingWorldMod.OTHER))));

    public static final RegistryObject<BannerPatternItem> GRYFFINDOR_BANNER_PATTERN =
            ITEMS.register("gryffindor_banner_pattern",
                    () -> new BannerPatternItem(BannerPattern.create(String.valueOf(ModBannerPattern.GRYFFINDOR), "gryffindor","gry",true)
                            ,new Item.Properties().rarity(Rarity.RARE).group((WizardingWorldMod.OTHER))));

    public static final RegistryObject<BannerPatternItem> SLYTHERIN_BANNER_PATTERN =
            ITEMS.register("slytherin_banner_pattern",
                    () -> new BannerPatternItem(BannerPattern.create(String.valueOf(ModBannerPattern.SLYTHERIN), "slytherin","sly",true)
                            ,new Item.Properties().rarity(Rarity.RARE).group((WizardingWorldMod.OTHER))));

    public static final RegistryObject<BannerPatternItem> HUFFLEPUFP_BANNER_PATTERN =
            ITEMS.register("hufflepufp_banner_pattern",
                    () -> new BannerPatternItem(BannerPattern.create(String.valueOf(ModBannerPattern.HUFFLEPUFP), "hufflepufp","huf",true)
                            ,new Item.Properties().rarity(Rarity.RARE).group((WizardingWorldMod.OTHER))));

    public static final RegistryObject<BannerPatternItem> RAVENCLAW_BANNER_PATTERN =
            ITEMS.register("ravenclaw_banner_pattern",
                    () -> new BannerPatternItem(BannerPattern.create(String.valueOf(ModBannerPattern.RAVENCLAW), "ravenclaw","rav",true)
                            ,new Item.Properties().rarity(Rarity.RARE).group((WizardingWorldMod.OTHER))));

    // Music Discs

    public static final RegistryObject<MusicDiscItem> MUSIC_DISC_HARRY_POTTER_THEME =
            ITEMS.register("music_disc_harry_potter_theme",
                    () -> new MusicDiscItem(14, ModSounds.LAZY_HARRY_POTTER_THEME_MUSIC ,
                            new Item.Properties().group(WizardingWorldMod.OTHER).maxStackSize(1).rarity(Rarity.RARE)));

    // Charm Books

    public static final RegistryObject<KillingCurseCharmBook> KILLING_CURSE_CHARM_BOOK= ITEMS.register("killing_curse_charm_book", KillingCurseCharmBook::new);

    // Wands

    public static final RegistryObject<MrLimnerWand> MR_LIMNER_WAND = ITEMS.register("mr_limner_wand", MrLimnerWand::new);

    public static final RegistryObject<REDX000Wand> RED_X_000_WAND = ITEMS.register("red_x_000_wand", REDX000Wand::new);

    // Block Items

    public static final RegistryObject<Item> WIZARDING_BENCH_ITEM = ITEMS.register("wizarding_bench",
            () -> new BlockItem(ModBlocks.WIZARDING_BENCH.get(), new Item.Properties().group(WizardingWorldMod.CHARMS)));

    public static final RegistryObject<Item> BLACK_OBSIDIAN_BRICKS_ITEM = ITEMS.register("black_obsidian_bricks",
            () -> new BlockItem(ModBlocks.BLACK_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> OBSIDIAN_BRICKS_ITEM = ITEMS.register("obsidian_bricks",
            () -> new BlockItem(ModBlocks.OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> BLUE_OBSIDIAN_BRICKS_ITEM = ITEMS.register("blue_obsidian_bricks",
            () -> new BlockItem(ModBlocks.BLUE_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> BROWN_OBSIDIAN_BRICKS_ITEM = ITEMS.register("brown_obsidian_bricks",
            () -> new BlockItem(ModBlocks.BROWN_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> CYAN_OBSIDIAN_BRICKS_ITEM = ITEMS.register("cyan_obsidian_bricks",
            () -> new BlockItem(ModBlocks.CYAN_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> GRAY_OBSIDIAN_BRICKS_ITEM = ITEMS.register("gray_obsidian_bricks",
            () -> new BlockItem(ModBlocks.GRAY_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> GREEN_OBSIDIAN_BRICKS_ITEM = ITEMS.register("green_obsidian_bricks",
            () -> new BlockItem(ModBlocks.GREEN_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> LIGHT_BLUE_OBSIDIAN_BRICKS_ITEM = ITEMS.register("light_blue_obsidian_bricks",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> LIGHT_GRAY_OBSIDIAN_BRICKS_ITEM = ITEMS.register("light_gray_obsidian_bricks",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> LIME_OBSIDIAN_BRICKS_ITEM = ITEMS.register("lime_obsidian_bricks",
            () -> new BlockItem(ModBlocks.LIME_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> MAGENTA_OBSIDIAN_BRICKS_ITEM = ITEMS.register("magenta_obsidian_bricks",
            () -> new BlockItem(ModBlocks.MAGENTA_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> ORANGE_OBSIDIAN_BRICKS_ITEM = ITEMS.register("orange_obsidian_bricks",
            () -> new BlockItem(ModBlocks.ORANGE_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> PINK_OBSIDIAN_BRICKS_ITEM = ITEMS.register("pink_obsidian_bricks",
            () -> new BlockItem(ModBlocks.PINK_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> RED_OBSIDIAN_BRICKS_ITEM = ITEMS.register("red_obsidian_bricks",
            () -> new BlockItem(ModBlocks.RED_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> WHITE_OBSIDIAN_BRICKS_ITEM = ITEMS.register("white_obsidian_bricks",
            () -> new BlockItem(ModBlocks.WHITE_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

    public static final RegistryObject<Item> YELLOW_OBSIDIAN_BRICKS_ITEM = ITEMS.register("yellow_obsidian_bricks",
            () -> new BlockItem(ModBlocks.YELLOW_OBSIDIAN_BRICKS.get(), new Item.Properties().group(WizardingWorldMod.BUILDINGBLOCKS)));

}
