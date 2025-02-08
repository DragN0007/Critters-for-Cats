package com.dragn0007.preycritters.world;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.entities.EntityTypes;
import com.dragn0007.preycritters.util.CrittersForCatsCommonConfig;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.stream.Collectors;

public class BiomeHitter {
    public static final ResourceKey<BiomeModifier> ADD_WHITE_BIRD_NEST = registerKey("add_white_bird_nest");
    public static final ResourceKey<BiomeModifier> ADD_BLUE_BIRD_NEST = registerKey("add_blue_bird_nest");

    public static final ResourceKey<BiomeModifier> SPAWN_MOUSE_FORESTS = registerKey("spawn_mouse_forests");
    public static final ResourceKey<BiomeModifier> SPAWN_MOUSE_HILLS = registerKey("spawn_mouse_hills");
    public static final ResourceKey<BiomeModifier> SPAWN_MOUSE_PLAINS = registerKey("spawn_mouse_plains");


    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

         context.register(ADD_WHITE_BIRD_NEST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                 biomes.getOrThrow(BiomeTags.IS_FOREST),
                 HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.WHITE_BIRD_NEST_PLACED)),
                 GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BLUE_BIRD_NEST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.BLUE_BIRD_NEST_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));



        context.register(SPAWN_MOUSE_FORESTS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.MOUSE_ENTITY.get(),
                        10,
                        1,
                        3
                ))));
        context.register(SPAWN_MOUSE_HILLS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_HILL),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.MOUSE_ENTITY.get(),
                        10,
                        1,
                        3
                ))));
        context.register(SPAWN_MOUSE_PLAINS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.MOUSE_ENTITY.get(),
                        10,
                        1,
                        3
                ))));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CrittersForCats.MODID, name));
    }
}