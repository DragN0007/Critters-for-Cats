package com.dragn0007.preycritters.world;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeHitter {
    public static final ResourceKey<BiomeModifier> ADD_WHITE_BIRD_NEST = registerKey("add_white_bird_nest");
    public static final ResourceKey<BiomeModifier> ADD_BLUE_BIRD_NEST = registerKey("add_blue_bird_nest");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

         context.register(ADD_WHITE_BIRD_NEST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                 biomes.getOrThrow(Tags.Biomes.IS_DENSE),
                 HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.WHITE_BIRD_NEST_PLACED)),
                 GenerationStep.Decoration.VEGETAL_DECORATION));

         context.register(ADD_WHITE_BIRD_NEST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_LUSH),
                HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.WHITE_BIRD_NEST_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BLUE_BIRD_NEST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DENSE),
                HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.BLUE_BIRD_NEST_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BLUE_BIRD_NEST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_LUSH),
                HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.BLUE_BIRD_NEST_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CrittersForCats.MODID, name));
    }
}