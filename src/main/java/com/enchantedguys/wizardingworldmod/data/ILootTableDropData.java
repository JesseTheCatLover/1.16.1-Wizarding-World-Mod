package com.enchantedguys.wizardingworldmod.data;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.util.NonNullList;

import java.util.List;

public interface ILootTableDropData {

    /**
     * @return the item, which the blocks should drop
     */
    NonNullList<Item> getDrops();

    /**
     * @return the block instance
     */
    Block dataBlock();

    /**
     * Override this method, if you want to add more conditions, like {@link com.enchantedguys.wizardingworldmod.common.util.helpers.LootConditionHelper#matchTool(Item)}
     *
     * @return the conditions list
     */
    default List<ILootCondition.IBuilder> lootConditions() {
        return Lists.newArrayList(SurvivesExplosion.builder());
    }
}
