package com.dragn0007.preycritters.world;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class CTCPlacedFeatures {

    public static final ResourceKey<PlacedFeature> WHITE_BIRD_NEST_PLACED = registerKey("white_bird_nest_placed");
    public static final ResourceKey<PlacedFeature> BLUE_BIRD_NEST_PLACED = registerKey("blue_bird_nest_placed");
    public static final ResourceKey<PlacedFeature> DIRT_VOLE_BURROW_PLACED = registerKey("dirt_vole_burrow_placed");
    public static final ResourceKey<PlacedFeature> SNOW_VOLE_BURROW_PLACED = registerKey("snow_vole_burrow_placed");
    public static final ResourceKey<PlacedFeature> BUG_LOG_PLACED = registerKey("bug_log_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, WHITE_BIRD_NEST_PLACED, configuredFeatures.getOrThrow(CTCConfigFeatures.WHITE_BIRD_NEST),
                List.of(RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.anyOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.LEAVES))))));

        register(context, BLUE_BIRD_NEST_PLACED, configuredFeatures.getOrThrow(CTCConfigFeatures.BLUE_BIRD_NEST),
                List.of(RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.anyOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.LEAVES))))));

        register(context, DIRT_VOLE_BURROW_PLACED, configuredFeatures.getOrThrow(CTCConfigFeatures.DIRT_VOLE_BURROW),
                List.of(RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT)))));

        register(context, SNOW_VOLE_BURROW_PLACED, configuredFeatures.getOrThrow(CTCConfigFeatures.SNOW_VOLE_BURROW),
                List.of(RarityFilter.onAverageOnceEvery(48),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.anyOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.SNOW))))));

        register(context, BUG_LOG_PLACED, configuredFeatures.getOrThrow(CTCConfigFeatures.BUG_LOG),
                List.of(RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT)))));
    }

    public static ResourceKey<PlacedFeature> registerKey (String name){
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CrittersForCats.MODID, name));
    }
    public static void register
    (BootstapContext < PlacedFeature > context, ResourceKey < PlacedFeature > key, Holder < ConfiguredFeature < ?, ?>>
    configuration,
            List < PlacementModifier > modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
