package com.enchantedguys.wizardingworldmod.common;

import com.enchantedguys.wizardingworldmod.client.screens.charmbook.CharmBookScreenManager;
import com.enchantedguys.wizardingworldmod.client.screens.charmbook.KillingCurseBookScreen;
import com.enchantedguys.wizardingworldmod.common.items.charmbooks.KillingCurseCharmBook;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class SetupEvents {

    public static void clientSetup(FMLClientSetupEvent event) {
        CharmBookScreenManager charmBookScreenManager = WizardingWorldMod.getCharmBookScreenManager();
        charmBookScreenManager.registerScreen(KillingCurseCharmBook.class, new KillingCurseBookScreen());
    }

    public static void commonSetup(FMLCommonSetupEvent event) {

    }

}
