package com.enchantedguys.wizardingworldmod.common.items.wands;

import com.enchantedguys.wizardingworldmod.common.util.helpers.KeyboardHelper;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class AbstractWandItem extends Item implements IWandItem {

    public static final int ON_RIGHT_CLICK = 1;
    public static final int ON_USE = 2;
    public static final int ON_USE_FINISH = 3;

    protected final Supplier<List<ITextComponent>> description;

    public AbstractWandItem(Properties properties, Supplier<List<ITextComponent>> description) {
        super(properties);
        this.description = description;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if ((description == null || description.get() == null) && !KeyboardHelper.isHoldingShift()) return;
        List<ITextComponent> desc = description.get();
        tooltip.addAll(desc);
    }

    /**
     * This method will be called when the item is been used, right clicked or finished with using.
     *
     * @param itemStack the item as ItemStack
     * @param player the player who using the item
     * @param world the world
     * @param hittetEntities the entities in a 5 block radius which been hittet
     * @param hittetBlock the block who the player look at
     */
    public abstract void performAttack(ItemStack itemStack, PlayerEntity player, World world, List<LivingEntity> hittetEntities, BlockState hittetBlock);

    /**
     * This is used to check when the attack be peformed
     *
     * @return ON_RIGHT_CLICK for the onItemRightClick method
     * ON_USE for the onItemUse method
     * ON_USE_FINISH for the onItemUseFinish method
     */
    public abstract int actionType();

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (this.actionType() == ON_RIGHT_CLICK) {
            Vector3d eye = playerIn.getEyePosition(1.0F);
            Vector3d look = playerIn.getLookVec();
            RayTraceContext context = new RayTraceContext(eye, look.add(eye), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, playerIn);
            BlockRayTraceResult rayTraceResult = worldIn.rayTraceBlocks(context);
            this.performAttack(playerIn.getHeldItem(handIn), playerIn, worldIn, this.getEntities(eye, look, rayTraceResult.subHit, worldIn, playerIn), worldIn.getBlockState(rayTraceResult.getPos()));
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        if (this.actionType() == ON_USE) {
            Vector3d eye = context.getPlayer().getEyePosition(1.0F);
            Vector3d look = context.getPlayer().getLookVec();
            RayTraceContext rayContext = new RayTraceContext(eye, look.add(eye), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, context.getPlayer());
            BlockRayTraceResult rayTraceResult = context.getWorld().rayTraceBlocks(rayContext);
            this.performAttack(context.getItem(), context.getPlayer(), context.getWorld(), this.getEntities(eye, look, rayTraceResult.subHit, context.getWorld(), context.getPlayer()), context.getWorld().getBlockState(rayTraceResult.getPos()));
        }
        return super.onItemUse(context);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (this.actionType() == ON_USE_FINISH) {
            PlayerEntity playerIn = (PlayerEntity) entityLiving;
            Vector3d eye = playerIn.getEyePosition(1.0F);
            Vector3d look = playerIn.getLookVec();
            RayTraceContext context = new RayTraceContext(eye, look.add(eye), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, playerIn);
            BlockRayTraceResult rayTraceResult = worldIn.rayTraceBlocks(context);
            this.performAttack(stack, playerIn, worldIn, this.getEntities(eye, look, rayTraceResult.subHit, worldIn, playerIn), worldIn.getBlockState(rayTraceResult.getPos()));


        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    protected List<LivingEntity> getEntities(Vector3d pos, Vector3d direction, double range, World world, PlayerEntity player) {
        List<LivingEntity> entities = Lists.newArrayList();
        Vector3d vec1 = pos.add(direction.mul(range / 5, range / 5, range / 5));
        AxisAlignedBB aabb1 = new AxisAlignedBB(vec1.add(range / 5, range / 5, range / 5), vec1.subtract(range / 5, range / 5, range / 5));
        Vector3d vec2 = pos.add(direction.mul(3 * range / 5, 3 * range / 5, 3 * range / 5));
        AxisAlignedBB aabb2 = new AxisAlignedBB(vec2.add(2 * range / 5, 2 * range / 5, 2 * range / 5), vec2.subtract(2 * range / 5, 2 * range / 5, 2 * range / 5));

        Predicate<Entity> filter = entity -> entity != null && entity.canBeCollidedWith() && entity.isAlive() && !entity.isSpectator() && entity instanceof LivingEntity && entity.getUniqueID() != player.getUniqueID();

        entities.addAll(world.getEntitiesInAABBexcluding(null, aabb1, filter).stream().map(e -> (LivingEntity) e).collect(Collectors.toList()));
        entities.addAll(world.getEntitiesInAABBexcluding(null, aabb2, filter).stream().map(e -> (LivingEntity) e).collect(Collectors.toList()));

        return entities;
    }

}
