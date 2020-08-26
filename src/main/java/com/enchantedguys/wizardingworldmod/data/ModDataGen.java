package com.enchantedguys.wizardingworldmod.data;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = WizardingWorldMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new LootTableDataGen(generator));
            generator.addProvider(new RecipeDataGen(generator));
        }

        if (event.includeClient()) {
        }
    }

}
