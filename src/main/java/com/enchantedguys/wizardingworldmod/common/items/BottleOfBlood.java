package com.enchantedguys.wizardingworldmod.common.items;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.util.Pair;
import com.google.common.collect.ImmutableList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;


/**
*  This Item is used to summon the voldemort
 */
public class BottleOfBlood extends ConsumeItem {
    public BottleOfBlood() {
        super(new Item.Properties()
                .group(WizardingWorldMod.MATERIALS)
                .maxStackSize(1)

        );
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof ServerPlayerEntity)
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) entityLiving, stack);

        if(!worldIn.isRemote) {
            Random random = worldIn.rand;
            double rand = random.nextDouble();
            if(rand <= 1.0)
                entityLiving.addPotionEffect(new EffectInstance(Effects.HUNGER, 60, 7));
            if(rand <= 0.6)
                entityLiving.addPotionEffect(new EffectInstance(Effects.POISON, 30, 2));
            if(rand <= 0.4)
                entityLiving.addPotionEffect(new EffectInstance(Effects.NAUSEA, 130, 2));
        }

        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }


    @Nullable
    @Override
    public ImmutableList<Pair<ItemStack, Boolean>> itemsToGive(ItemStack stack) {
        return ImmutableList.of(new Pair<>(Items.GLASS_BOTTLE.getDefaultInstance(), true));
    }

    @Override
    public void playSound(World world, PlayerEntity playerEntity) {

    }

    /**
     * How long it takes to use or consume an item
     */
    public int getUseDuration(ItemStack stack) {
        return 20;
    }


    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }


    /**
     * Called to trigger the item's innate right click behavior. To handle when this item is used on a Block
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return DrinkHelper.func_234707_a_(worldIn, playerIn, handIn);
    }

}
