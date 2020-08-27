package com.enchantedguys.wizardingworldmod.common.items;

import com.google.common.collect.ImmutableList;
import javafx.util.Pair;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public abstract class ConsumeItem extends Item {

    public ConsumeItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerEntity = (PlayerEntity) entityLiving;
        List<Pair<ItemStack, Boolean>> items = this.itemsToGive();
        boolean flag = false;
        if (items != null) {
            for (Pair<ItemStack, Boolean> pair : items) {
                if (pair.getValue() && !flag && playerEntity.getHeldItemMainhand().isEmpty()) {
                    flag = true;
                    playerEntity.setHeldItem(Hand.MAIN_HAND, pair.getKey());
                    continue;
                }
                if (!playerEntity.inventory.addItemStackToInventory(pair.getKey()))
                    playerEntity.dropItem(pair.getKey(), false);
            }
        }

        playSound(worldIn, playerEntity);
        playerEntity.addStat(Stats.ITEM_USED.get(this), 1);
        stack.shrink(1);

        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    /**
     * Return a list of {@link ItemStack}s
     * You can create the list with {@link ImmutableList#of()}.
     * Create new {@link Pair<ItemStack, Boolean>} instances, where the first parameter should the item you want to give to the player
     * and if you set the boolean to true then it would try to give it into the main hand
     * if the main hand is not empty, so it gives him the item into a empty inventory slot
     * otherwise it will drop
     * <p>
     * NOTICE: Only the first entry with the boolean true is set into the player hand. The other will add into the inventory
     *
     * @return the list of items, where you can give to the player
     * return null if you want no items to give
     */
    @Nullable
    public abstract ImmutableList<Pair<ItemStack, Boolean>> itemsToGive();

    /**
     * Override if you want to play a sound
     */
    public abstract void playSound(World world, PlayerEntity playerEntity);


}
