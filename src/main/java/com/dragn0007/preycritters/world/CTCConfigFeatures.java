package com.dragn0007.preycritters.world;


import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.blocks.CTCBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class CTCConfigFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_BIRD_NEST = registerKey("white_bird_nest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_BIRD_NEST = registerKey("blue_bird_nest");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, WHITE_BIRD_NEST, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(CTCBlocks.WHITE_BIRD_NEST.get())));
        register(context, BLUE_BIRD_NEST, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(CTCBlocks.BLUE_BIRD_NEST.get())));
        
    }
    
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CrittersForCats.MODID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}


