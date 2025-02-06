package com.dragn0007.preycritters.world;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.blocks.CTCBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.function.Predicate;

public class CTCPlacedFeatures {

    public static final ResourceKey<PlacedFeature> WHITE_BIRD_NEST_PLACED = registerKey("white_bird_nest_placed");
    public static final ResourceKey<PlacedFeature> BLUE_BIRD_NEST_PLACED = registerKey("blue_bird_nest_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, WHITE_BIRD_NEST_PLACED, configuredFeatures.getOrThrow(CTCConfigFeatures.WHITE_BIRD_NEST),
                List.of(RarityFilter.onAverageOnceEvery(256),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.noFluid())));

        register(context, BLUE_BIRD_NEST_PLACED, configuredFeatures.getOrThrow(CTCConfigFeatures.BLUE_BIRD_NEST),
                List.of(RarityFilter.onAverageOnceEvery(512),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.noFluid())));
    }

    private static ResourceKey<PlacedFeature> registerKey (String name){
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CrittersForCats.MODID, name));
    }
    private static void register
    (BootstapContext < PlacedFeature > context, ResourceKey < PlacedFeature > key, Holder < ConfiguredFeature < ?, ?>>
    configuration,
            List < PlacementModifier > modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
