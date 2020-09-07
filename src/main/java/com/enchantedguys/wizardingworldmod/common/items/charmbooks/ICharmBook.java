package com.enchantedguys.wizardingworldmod.common.items.charmbooks;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public interface ICharmBook extends Cloneable {

    /**
     * @return the item instance himself
     */
    Item getCharmBookItem();

    ResourceLocation getTypeId();

    ICharmBook cloneBook() throws CloneNotSupportedException;

}
