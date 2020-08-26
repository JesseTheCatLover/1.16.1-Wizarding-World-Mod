package com.enchantedguys.wizardingworldmod.common.util.helpers;

import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.item.Item;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;

public class LootConditionHelper {

    public static ILootCondition.IBuilder matchTool(Item tool) {
        return MatchTool.builder(ItemPredicate.Builder.create().item(tool));
    }

}
