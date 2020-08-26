package com.enchantedguys.wizardingworldmod.common.events;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.util.ModEntries;
import net.minecraft.command.Commands;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WizardingWorldMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onPlayerKillingCurse(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("Avada")
                .then(Commands.literal("Kedavra").executes(PSource -> {
                    return ModEntries.KillingCurse(PSource.getSource().asPlayer());
                })));
    }


}
