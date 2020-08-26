package com.enchantedguys.wizardingworldmod.common.inventory;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.IItemHandler;

public class ModCraftingInventory extends CraftingInventory {

    public ModCraftingInventory(Container eventHandlerIn, int width, int height, NonNullList<ItemStack> inv) {
        super(eventHandlerIn, width, height);
        for (int i = 0; i < width * height; i++) this.stackList.set(i, inv.get(i));

    }

    /**
     * The first 4 slots will be converted to a CraftingInventory
     */
    public ModCraftingInventory(Container eventHandlerIn, int width, int height, IItemHandler invIn) {
        super(eventHandlerIn, width, height);
        for (int i = 0; i < width * height; i++) this.stackList.set(i, invIn.getStackInSlot(i));
    }

}
