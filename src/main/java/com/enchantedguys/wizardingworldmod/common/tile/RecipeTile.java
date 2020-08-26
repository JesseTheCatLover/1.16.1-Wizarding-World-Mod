package com.enchantedguys.wizardingworldmod.common.tile;

import com.enchantedguys.wizardingworldmod.common.recipe.IModRecipe;
import com.enchantedguys.wizardingworldmod.common.util.FunctionalIntReferenceHolder;
import com.enchantedguys.wizardingworldmod.common.util.helpers.CraftingHelper;
import com.enchantedguys.wizardingworldmod.common.util.helpers.MethodsHelper;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public abstract class RecipeTile<R extends IModRecipe<RecipeWrapper>> extends ContainerTile implements ITickableTileEntity {

    public static final int DEFAULT_ARROW_WIDTH = 24;

    public int workingTicks = 0;
    public int maxWorkTicks = 0;
    public int animTime = 0;
    public R currentRecipe;
    public boolean craftingFlag = false;
    public boolean idle = false;

    public RecipeTile(TileEntityType<?> tileEntityTypeIn, int inventorySlots) {
        super(tileEntityTypeIn, inventorySlots);
    }


    protected R getRecipe() {
        Set<R> recipes = (Set<R>) CraftingHelper.findModRecipesByType(this.getRecipeType(), this.getWorld());
        if (recipes.isEmpty())
            return null;
        for (R rec : recipes) {
            if (rec.matches(new RecipeWrapper(this.inventory), this.world)) {
                return rec;
            }
        }
        return null;
    }

    public abstract IRecipeType<R> getRecipeType();

    public abstract boolean canCraft();

    public abstract void craft(@Nullable R recipe);

    public abstract int[] getInputSlots();

    public abstract boolean notIdle();

    public void changeBlockState() {

    }

    /**
     * Overwrite if you have to add more data to sync
     *
     * @return a list of {@link FunctionalIntReferenceHolder}
     */
    @Override
    public List<FunctionalIntReferenceHolder> getIntReferenceHolder() {
        return Lists.newArrayList(new FunctionalIntReferenceHolder(() -> workingTicks, v -> workingTicks = v),
                new FunctionalIntReferenceHolder(() -> animTime, v -> animTime = v),
                new FunctionalIntReferenceHolder(() -> maxWorkTicks, v -> maxWorkTicks = v));
    }

    @Override
    public void tick() {
        if (world == null || world.isRemote) return;

        if (!idle) {
            boolean flag = false;
            boolean flag1 = this.isWorking();

            if (this.isWorking()) {
                this.animTime++;
                this.workingTicks--;
            }

            if (this.workingTicks == 0 && this.craftingFlag) {
                this.craft(this.currentRecipe);
                this.craftingFlag = false;
            }

            if (!this.isWorking()) {
                if (this.canCraft()) {
                    ItemStack[] inputs = this.getCurrentInputItems();
                    if (!MethodsHelper.containsEmptyElement(inputs)) {
                        this.currentRecipe = this.getRecipe();
                        this.workingTicks = this.currentRecipe.getWorkingTime() * 20;
                        this.maxWorkTicks = workingTicks;
                        this.inputsBiConsumer((slot, stack) -> {
                            if (stack.hasContainerItem())
                                inventory.setStackInSlot(slot, stack.getContainerItem());
                            else {
                                stack.shrink(1);
                                inventory.setStackInSlot(slot, stack);
                            }
                        });
                        flag = true;
                        this.craftingFlag = true;
                    }
                }
            }

            if (flag1 != this.isWorking()) {
                flag = true;
                this.changeBlockState();
            }

            if (flag)
                this.markDirty();
        } else {
            if (this.notIdle())
                this.idle = false;
        }
    }

    private void inputsBiConsumer(BiConsumer<Integer, ItemStack> biConsumer) {
        ItemStack[] inputs = this.getCurrentInputItems();
        if (getInputSlots().length != inputs.length) return;
        for (int i = 0; i < inputs.length; i++) {
            biConsumer.accept(getInputSlots()[i], inputs[i]);
        }
    }

    protected void finishCrafting() {
        this.workingTicks = 0;
        this.animTime = 0;
        this.currentRecipe = null;
        this.craftingFlag = false;
    }

    protected ItemStack[] getCurrentInputItems() {
        ItemStack[] stacks = new ItemStack[this.getInputSlots().length];
        for (int i = 0; i < this.getInputSlots().length; i++)
            stacks[i] = this.inventory.getStackInSlot(this.getInputSlots()[i]);
        return stacks;
    }

    protected boolean isWorking() {
        return this.workingTicks > 0;
    }

}
