package com.enchantedguys.wizardingworldmod.common.util;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import com.enchantedguys.wizardingworldmod.common.items.foods.BeansItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = WizardingWorldMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        //ItemModelsProperties.func_239418_a_(ModItems.BEANS.get(), new ResourceLocation("color"), BeansItem::getPropertyOverrite);
    }

    @SubscribeEvent
    public static void colorRegister(ColorHandlerEvent.Item event) {
        event.getItemColors().register(new BeansItem.BeansItemColor(), ModItems.BEANS.get());
    }
}
