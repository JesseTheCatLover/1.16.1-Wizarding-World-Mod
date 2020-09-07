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

/**
 * This is very easy to understand.
 * If you have a Container (Inventory) where is based on recipes, like this. (The WizardingBench),
 * then you have to extend from {@link CraftingBaseContainer<>}. The first generic type is the interface from the recipe,
 * and the second generic type is the tile entity class.
 *
 */
public class WizardingBenchContainer extends CraftingBaseContainer<IWizardingBenchRecipe, WizardingBenchTile> {

    /**
     * You have to create this constructor in EVERY container class. This is be used from the server to create the container on server side
     * You can copy this to every container class, and just change the constructor name and the WizardingBenchTile.class parameter, to the tile entity
     * where you set in the second generic type
     *
     * @param id the window id
     * @param playerInventory the playerInventory object
     * @param data the data from the client
     */
    public WizardingBenchContainer(int id, PlayerInventory playerInventory, PacketBuffer data) {
        this(id, playerInventory, ContainerHelper.getTileEntity(WizardingBenchTile.class, playerInventory, data));
    }

    /**
     * Little different as above. This constructor is been used on the client side.
     *
     * @param id the window id
     * @param playerInventory the playerInventory object
     * @param tile the tile entity
     */
    public WizardingBenchContainer(int id, PlayerInventory playerInventory, WizardingBenchTile tile) {
        super(ModContainers.WIZARDING_BENCH.get(), id, playerInventory, tile, 1);

        /*
         * If you want to add simple input slots, use this:
         *
         * The first parameter is the inventory, you have to use the inventory from the tile entity.
         * The second parameter is the slot id. (e.g.: If you check the slots in the isItemValid method), you have to start with 0 and for every slot increase the id per 1
         * the third and fourth parameter is the x and y position from the slot. (The TOP LEFT corner from the slot (The white blank))
         *
         */
        this.addSlot(new SlotItemHandler(tile.inventory, 0, 27, 46));
        this.addSlot(new SlotItemHandler(tile.inventory, 1, 79, 46));

        /*
         * Then for your crafting result slot you have to use the SlotCraftingResult class.
         *
         * The first parameter is ALWAYS the resultHandler from the parent class.
         * The second parameter the player object, use the object from the parent class
         * The third parameter is the container class himself, just use "this"
         * The fourth parameter is the slot id, start with 0
         * The fifth and sixth parameter are the x and y position from the slot. (The TOP LEFT corner from the slot (The white blank))
         *
         */
        this.addSlot(new SlotCraftingResult(resultHandler, player, this, 0, 137, 46));

        /*
         * And finally you have to set the playerInventory and playerHotbar Slots.
         * Just call this two methods, and set the startX and startY for the playerInventory and for the hotbar set the startX and the y position.
         * The two methods will make the rest
         */
        this.playerInventory(8, 84);
        this.playerHotbar(8, 142);

    }

    /**
     * @return the recipe type
     */
    @Override
    public IRecipeType<IWizardingBenchRecipe> recipeType() {
        return ModRecipes.WIZARDING_BENCH;
    }
}
