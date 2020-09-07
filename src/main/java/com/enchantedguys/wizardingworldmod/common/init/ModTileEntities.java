package com.enchantedguys.wizardingworldmod.common.init;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.tile.WizardingBenchTile;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, WizardingWorldMod.MOD_ID);

    public static final RegistryObject<TileEntityType<WizardingBenchTile>> WIZARDING_BENCH = registerTile("wizarding_bench", WizardingBenchTile::new, ModBlocks.WIZARDING_BENCH);

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> registerTile(String id, Supplier<T> supplier, RegistryObject<Block> block) {
        return TILE_ENTITIES.register(id, () -> TileEntityType.Builder.create(supplier, block.get()).build(null));
    }

}
