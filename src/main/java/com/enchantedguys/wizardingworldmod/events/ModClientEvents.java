package com.enchantedguys.wizardingworldmod.events;

import com.enchantedguys.wizardingworldmod.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.util.ModEntries;
import net.minecraft.command.Commands;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.crypto.spec.PSource;

@Mod.EventBusSubscriber(modid = WizardingWorldMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onPlayerKillingCurse(RegisterCommandsEvent event)
    {
        event.getDispatcher().register(Commands.literal("Avada")
                .then(Commands.literal("Kedavra").executes(PSource ->{
                    return ModEntries.KillingCurse(PSource.getSource().asPlayer());
                })));
    }

}
