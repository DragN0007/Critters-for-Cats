package com.dragn0007.preycritters.world;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.entities.EntityTypes;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class BiomeHitter {
    public static final ResourceKey<BiomeModifier> ADD_WHITE_BIRD_NEST = registerKey("add_white_bird_nest");
    public static final ResourceKey<BiomeModifier> ADD_BLUE_BIRD_NEST = registerKey("add_blue_bird_nest");
    public static final ResourceKey<BiomeModifier> ADD_DIRT_VOLE_BURROW = registerKey("add_dirt_vole_burrow");
    public static final ResourceKey<BiomeModifier> ADD_SNOW_VOLE_BURROW = registerKey("add_snow_vole_burrow");
    public static final ResourceKey<BiomeModifier> ADD_BUG_LOG = registerKey("add_bug_log");
    public static final ResourceKey<BiomeModifier> ADD_MOUSE_BURROW = registerKey("add_mouse_burrow");

    public static final ResourceKey<BiomeModifier> SPAWN_MOUSE_FORESTS = registerKey("spawn_mouse_forests");
    public static final ResourceKey<BiomeModifier> SPAWN_MOUSE_HILLS = registerKey("spawn_mouse_hills");
    public static final ResourceKey<BiomeModifier> SPAWN_MOUSE_PLAINS = registerKey("spawn_mouse_plains");
    public static final ResourceKey<BiomeModifier> SPAWN_SQUIRREL_FORESTS = registerKey("spawn_squirrel_forests");
    public static final ResourceKey<BiomeModifier> SPAWN_VOLE_TAIGAS = registerKey("spawn_vole_taigas");
    public static final ResourceKey<BiomeModifier> SPAWN_VOLE_SNOWY = registerKey("spawn_vole_snowy");
    public static final ResourceKey<BiomeModifier> SPAWN_VOLE_FORESTS = registerKey("spawn_vole_forests");
    public static final ResourceKey<BiomeModifier> SPAWN_BEETLE = registerKey("spawn_beetle");
    public static final ResourceKey<BiomeModifier> SPAWN_COYOTE_FORESTS = registerKey("spawn_coyote_forests");
    public static final ResourceKey<BiomeModifier> SPAWN_COYOTE_HOT = registerKey("spawn_coyote_hot");
    public static final ResourceKey<BiomeModifier> SPAWN_SONGBIRD_FORESTS = registerKey("spawn_songbird_forests");
    public static final ResourceKey<BiomeModifier> SPAWN_FISH_RIVERS = registerKey("spawn_fish_rivers");
    public static final ResourceKey<BiomeModifier> SPAWN_FISH_SWAMPS = registerKey("spawn_fish_swamps");
    public static final ResourceKey<BiomeModifier> SPAWN_FISH_PLAINS = registerKey("spawn_fish_plains");
    public static final ResourceKey<BiomeModifier> SPAWN_FROGS_SWAMPS = registerKey("spawn_frogs_swamps");
    public static final ResourceKey<BiomeModifier> SPAWN_WOLVES_TAIGAS = registerKey("spawn_wolves_taigas");
    public static final ResourceKey<BiomeModifier> SPAWN_WOLVES_SNOWY = registerKey("spawn_wolves_snowy");
    public static final ResourceKey<BiomeModifier> SPAWN_FOXES_TAIGAS = registerKey("spawn_foxes_taigas");
    public static final ResourceKey<BiomeModifier> SPAWN_FOXES_FORESTS = registerKey("spawn_foxes_forests");
    public static final ResourceKey<BiomeModifier> SPAWN_SNAKES_FORESTS = registerKey("spawn_snakes_forests");
    public static final ResourceKey<BiomeModifier> SPAWN_VENOMOUS_SNAKES_HOT = registerKey("spawn_venomous_snakes_hot");
    public static final ResourceKey<BiomeModifier> SPAWN_LETHAL_SNAKES_HOT = registerKey("spawn_lethal_snakes_hot");


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

        context.register(ADD_DIRT_VOLE_BURROW, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.DIRT_VOLE_BURROW_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SNOW_VOLE_BURROW, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SNOWY),
                HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.SNOW_VOLE_BURROW_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BUG_LOG, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.BUG_LOG_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_MOUSE_BURROW, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(CTCPlacedFeatures.MOUSE_BURROW_PLACED)),
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


        context.register(SPAWN_SQUIRREL_FORESTS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.SQUIRREL_ENTITY.get(),
                        8,
                        1,
                        2
                ))));


        context.register(SPAWN_VOLE_TAIGAS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_TAIGA),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.VOLE_ENTITY.get(),
                        8,
                        1,
                        1
                ))));
        context.register(SPAWN_VOLE_SNOWY, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SNOWY),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.VOLE_ENTITY.get(),
                        6,
                        1,
                        1
                ))));
        context.register(SPAWN_VOLE_FORESTS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.VOLE_ENTITY.get(),
                        6,
                        1,
                        1
                ))));


        context.register(SPAWN_BEETLE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.BEETLE_ENTITY.get(),
                        6,
                        1,
                        1
                ))));


        context.register(SPAWN_COYOTE_FORESTS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.COYOTE_ENTITY.get(),
                        7,
                        1,
                        4
                ))));
        context.register(SPAWN_COYOTE_HOT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.COYOTE_ENTITY.get(),
                        7,
                        1,
                        4
                ))));


        context.register(SPAWN_SONGBIRD_FORESTS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.SONGBIRD_ENTITY.get(),
                        10,
                        1,
                        2
                ))));


        context.register(SPAWN_FISH_RIVERS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_RIVER),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.SMALL_FISH_ENTITY.get(),
                        8,
                        2,
                        5
                ))));
        context.register(SPAWN_FISH_SWAMPS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.SMALL_FISH_ENTITY.get(),
                        8,
                        2,
                        5
                ))));
        context.register(SPAWN_FISH_PLAINS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.SMALL_FISH_ENTITY.get(),
                        6,
                        2,
                        5
                ))));


        context.register(SPAWN_FROGS_SWAMPS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.SMALL_FROG_ENTITY.get(),
                        20,
                        1,
                        2
                ))));


        context.register(SPAWN_WOLVES_TAIGAS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_TAIGA),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.V_WOLF_ENTITY.get(),
                        8,
                        1,
                        4
                ))));
        context.register(SPAWN_WOLVES_SNOWY, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SNOWY),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.V_WOLF_ENTITY.get(),
                        8,
                        1,
                        4
                ))));


        context.register(SPAWN_FOXES_TAIGAS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_TAIGA),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.V_FOX_ENTITY.get(),
                        10,
                        1,
                        2
                ))));
        context.register(SPAWN_FOXES_FORESTS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.V_FOX_ENTITY.get(),
                        10,
                        1,
                        2
                ))));


        context.register(SPAWN_SNAKES_FORESTS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.SNAKE_ENTITY.get(),
                        10,
                        1,
                        1
                ))));
        context.register(SPAWN_VENOMOUS_SNAKES_HOT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.VENOMOUS_SNAKE_ENTITY.get(),
                        10,
                        1,
                        1
                ))));
        context.register(SPAWN_LETHAL_SNAKES_HOT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.LETHAL_SNAKE_ENTITY.get(),
                        10,
                        1,
                        1
                ))));
    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CrittersForCats.MODID, name));
    }
}