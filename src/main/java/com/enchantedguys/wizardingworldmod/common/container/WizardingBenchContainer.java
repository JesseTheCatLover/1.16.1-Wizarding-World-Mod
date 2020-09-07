package com.enchantedguys.wizardingworldmod.common.container;

import com.enchantedguys.wizardingworldmod.common.init.ModContainers;
import com.enchantedguys.wizardingworldmod.common.init.ModRecipes;
import com.enchantedguys.wizardingworldmod.common.inventory.slot.SlotCraftingResult;
import com.enchantedguys.wizardingworldmod.common.recipe.wizarding_bench.IWizardingBenchRecipe;
import com.enchantedguys.wizardingworldmod.common.tile.WizardingBenchTile;
import com.enchantedguys.wizardingworldmod.common.util.helpers.ContainerHelper;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.SlotItemHandler;

public class WizardingBenchContainer extends CraftingBaseContainer<IWizardingBenchRecipe, WizardingBenchTile> {

    public WizardingBenchContainer(int id, PlayerInventory playerInventory, PacketBuffer data) {
        this(id, playerInventory, ContainerHelper.getTileEntity(WizardingBenchTile.class, playerInventory, data));
    }

    public WizardingBenchContainer(int id, PlayerInventory playerInventory, WizardingBenchTile tile) {
        super(ModContainers.WIZARDING_BENCH.get(), id, playerInventory, tile, 1);

        this.addSlot(new SlotItemHandler(tile.inventory, 0, 27, 46));
        this.addSlot(new SlotItemHandler(tile.inventory, 1, 79, 46));

        this.addSlot(new SlotCraftingResult(resultHandler, player, this, 0, 137, 46));

        this.playerInventory(8, 84);
        this.playerHotbar(8, 142);

    }

    @Override
    public IRecipeType<IWizardingBenchRecipe> recipeType() {
        return ModRecipes.WIZARDING_BENCH;
    }
}
