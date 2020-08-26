package com.enchantedguys.wizardingworldmod.testing;

import com.enchantedguys.wizardingworldmod.common.container.BaseContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

import javax.annotation.Nullable;

public class TestContainerBlockContainer extends BaseContainer<TestContainerBlockTile> {

    public TestContainerBlockContainer(@Nullable ContainerType<?> type, int id, PlayerInventory playerInventory, TestContainerBlockTile tile) {
        super(type, id, playerInventory, tile);

        /*
            Just setup the container here... with addSlot and the BaseContainer class will do all
         */

    }
}
