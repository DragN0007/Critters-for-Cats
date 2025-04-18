package com.dragn0007.preycritters.datagen;

import com.dragn0007.preycritters.items.CTCItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class CTCRecipeMaker extends RecipeProvider implements IConditionBuilder {
    public CTCRecipeMaker(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL)
                .requires(CTCItems.SMALL_ANIMAL_BONE.get())
                .unlockedBy("has_bone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.BONE)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation("preycritters", "bone_meal_small_bone"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL)
                .requires(CTCItems.SMALL_ANIMAL_SKULL_ITEM.get())
                .unlockedBy("has_bone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.BONE)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation("preycritters", "bone_meal_small_skull"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL)
                .requires(CTCItems.SMALL_FISH_SKELETON.get())
                .unlockedBy("has_bone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.BONE)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation("preycritters", "bone_meal_fish_skeleton"));
    }
}