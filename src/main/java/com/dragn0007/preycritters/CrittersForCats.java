package com.dragn0007.preycritters;

import com.dragn0007.preycritters.blocks.CTCBlocks;
import com.dragn0007.preycritters.entities.EntityTypes;
import com.dragn0007.preycritters.items.CTCItemGroup;
import com.dragn0007.preycritters.items.CTCItems;
import com.dragn0007.preycritters.util.CrittersForCatsCommonConfig;
//import com.dragn0007.preycritters.world.CreatureSpawnGeneration;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib.GeckoLib;

@Mod(CrittersForCats.MODID)
public class CrittersForCats
{
    public static final String MODID = "preycritters";

//    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MODID);
//    public static final RegistryObject<Codec<CreatureSpawnGeneration>> SPAWN_CODEC = BIOME_MODIFIER_SERIALIZERS.register("spawn_biome_modifier",
//            () -> RecordCodecBuilder.create(builder ->
//                    builder.group(Biome.LIST_CODEC.fieldOf("biomes").forGetter(CreatureSpawnGeneration::biomes)).apply(builder, CreatureSpawnGeneration::new)));

    public CrittersForCats()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CTCItems.register(eventBus);
        CTCItemGroup.register(eventBus);
        CTCBlocks.register(eventBus);
        EntityTypes.ENTITY_TYPES.register(eventBus);

        GeckoLib.initialize();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CrittersForCatsCommonConfig.SPEC, "critters-for-cats-common.toml");

//        BIOME_MODIFIER_SERIALIZERS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        System.out.println("[Critters for Cats] Registered Critters for Cats.");
    }



}
