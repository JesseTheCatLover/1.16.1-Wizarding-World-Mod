package com.enchantedguys.wizardingworldmod.items;

import com.enchantedguys.wizardingworldmod.init.ModItems;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.Mod;

public class KnifeItem extends TieredItem implements IVanishable {
    private final float attackDamage;
    /**
     * Modifiers applied when the item is in the mainhand of a user.
     */
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public KnifeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties p_i48460_4_) {
        super(tier, p_i48460_4_);
        this.attackDamage = (float) attackDamageIn + tier.getAttackDamage();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double) attackSpeedIn, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return !player.isCreative();
    }

    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.isIn(Blocks.COBWEB)) {
            return 10.0F;
        } else {
            Material material = state.getMaterial();
            return material != Material.PLANTS && material != Material.TALL_PLANTS && material != Material.CORAL && !state.isIn(BlockTags.LEAVES) && material != Material.GOURD ? 1.0F : 1.5F;
        }
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, (p_220045_0_) -> {
            p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    /**
     * Called when a Block is destroyed using this Item. Return true to trigger the Use Item statistic.
     */
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (state.getBlockHardness(worldIn, pos) != 0.0F) {
            stack.damageItem(2, entityLiving, (p_220044_0_) -> {
                p_220044_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(BlockState blockIn) {
        return blockIn.isIn(Blocks.COBWEB);
    }

    /**
     * Gets a map of item attribute modifiers
     */
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        return equipmentSlot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot);
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }


    @Override
    public int getUseDuration(ItemStack stack) {
        return 20;
    }

    /**
     * Called to trigger the item's innate right click behavior. To handle when this item is used on a Block
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(),
                playerIn.getPosZ(), SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, null,
                0.7F, 2.5F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);

        if (playerIn.getHeldItemMainhand().getItem() == Items.GLASS_BOTTLE) {
            if (playerIn.getHeldItemOffhand().getItem() == ModItems.IRON_KNIFE.get()
                    || playerIn.getHeldItemOffhand().getItem() == ModItems.GOLDEN_KNIFE.get()) {

                if (playerIn != null) {
                    playerIn.addStat(Stats.ITEM_USED.get(this));

                    playerIn.performHurtAnimation();
                    playerIn.attackEntityFrom(DamageSource.GENERIC, 4);
                    if (playerIn != null) {
                        playerIn.addStat(Stats.ITEM_USED.get(this));
                        if (!playerIn.abilities.isCreativeMode) {
                            playerIn.getHeldItemMainhand().shrink(1);
                        }
                    }
                    if (playerIn.getHeldItemMainhand().isEmpty()) {
                        playerIn.setHeldItem(Hand.MAIN_HAND, new ItemStack(ModItems.BOTTLE_OF_BLOOD.get()));
                    } else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(ModItems.BOTTLE_OF_BLOOD.get()))) {
                        playerIn.dropItem(new ItemStack(ModItems.BOTTLE_OF_BLOOD.get()), false);
                    }
                }
                SoundCategory soundcategory = playerIn instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.PLAYERS;
                worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(),
                        playerIn.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL, soundcategory,
                        1.0F, 2.5F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);

                playerIn.getHeldItemOffhand().damageItem(20, playerIn, (p_220045_0_) -> {
                    p_220045_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
                });
            }
        }

        return DrinkHelper.func_234707_a_(worldIn, playerIn, handIn);
    }
}

