package com.dragn0007.preycritters.datagen;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.world.BiomeHitter;
import com.dragn0007.preycritters.world.CTCConfigFeatures;
import com.dragn0007.preycritters.world.CTCPlacedFeatures;
import com.dragn0007.preycritters.world.CreatureSpawnGeneration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CTCWorldGenerator extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, CTCConfigFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, CTCPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeHitter::bootstrap);

    public CTCWorldGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CrittersForCats.MODID));
    }
}
