package com.dragn0007.preycritters.world;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.entities.EntityTypes;
import com.dragn0007.preycritters.util.CrittersForCatsCommonConfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

import java.util.List;

public record CreatureSpawnGeneration(HolderSet<Biome> biomes) implements BiomeModifier {

    public static List<MobSpawnSettings.SpawnerData> MOUSE_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(
                    EntityTypes.MOUSE_ENTITY.get(),
                    CrittersForCatsCommonConfig.MICE_WEIGHT.get(),
                    CrittersForCatsCommonConfig.MICE_MIN.get(),
                    CrittersForCatsCommonConfig.MICE_MAX.get())
    );

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if(phase == Phase.ADD && biomes.contains(biome)) {
            List<MobSpawnSettings.SpawnerData> spawner = builder.getMobSpawnSettings().getSpawner(MobCategory.CREATURE);

            if(biome.is(BiomeTags.IS_FOREST) || biome.is(BiomeTags.IS_TAIGA) || biome.is(BiomeTags.IS_SAVANNA) || biome.is(BiomeTags.IS_HILL) || biome.is(Biomes.PLAINS)) {
                spawner.addAll(MOUSE_SPAWNS);
            }
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return CrittersForCats.SPAWN_CODEC.get();
    }
}