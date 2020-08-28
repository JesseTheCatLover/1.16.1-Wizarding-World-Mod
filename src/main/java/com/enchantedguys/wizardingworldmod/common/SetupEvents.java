package com.enchantedguys.wizardingworldmod.common;

import com.enchantedguys.wizardingworldmod.client.renderer.ChocolateFrogRenderer;
import com.enchantedguys.wizardingworldmod.client.screens.charmbook.CharmBookScreenManager;
import com.enchantedguys.wizardingworldmod.client.screens.charmbook.KillingCurseBookScreen;
import com.enchantedguys.wizardingworldmod.common.entities.ChocolateFrogEntity;
import com.enchantedguys.wizardingworldmod.common.init.ModEntities;
import com.enchantedguys.wizardingworldmod.common.items.charmbooks.KillingCurseCharmBook;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class SetupEvents {

    public static void clientSetup(FMLClientSetupEvent event) {
        CharmBookScreenManager charmBookScreenManager = WizardingWorldMod.getCharmBookScreenManager();
        charmBookScreenManager.registerScreen(KillingCurseCharmBook.class, new KillingCurseBookScreen());

        RenderingRegistry.registerEntityRenderingHandler(ModEntities.CHOCOLATE_FROG.get(), ChocolateFrogRenderer::new);

    }

    public static void commonSetup(FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(ModEntities.CHOCOLATE_FROG.get(), ChocolateFrogEntity.getEntityAttributes().create());
    }

}
