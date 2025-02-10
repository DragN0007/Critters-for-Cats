package com.dragn0007.preycritters.world;


import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.blocks.CTCBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class CTCConfigFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_BIRD_NEST = registerKey("white_bird_nest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_BIRD_NEST = registerKey("blue_bird_nest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIRT_VOLE_BURROW = registerKey("dirt_vole_burrow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOW_VOLE_BURROW = registerKey("snow_vole_burrow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUG_LOG = registerKey("bug_log");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, WHITE_BIRD_NEST, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(CTCBlocks.WHITE_BIRD_NEST.get())));
        register(context, BLUE_BIRD_NEST, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(CTCBlocks.BLUE_BIRD_NEST.get())));
        register(context, DIRT_VOLE_BURROW, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(CTCBlocks.DIRT_VOLE_BURROW.get())));
        register(context, SNOW_VOLE_BURROW, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(CTCBlocks.SNOW_VOLE_BURROW.get())));
        register(context, BUG_LOG, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(CTCBlocks.BUG_LOG.get())));
    }
    
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CrittersForCats.MODID, name));
    }
    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
      ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}


