package com.dragn0007.preycritters;

import com.dragn0007.preycritters.blocks.CTCBlocks;
import com.dragn0007.preycritters.entities.EntityTypes;
import com.dragn0007.preycritters.items.CTCItemGroup;
import com.dragn0007.preycritters.items.CTCItems;
import com.dragn0007.preycritters.util.CrittersForCatsCommonConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.GeckoLib;

@Mod(CrittersForCats.MODID)
public class CrittersForCats
{
    public static final String MODID = "preycritters";

    public CrittersForCats()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CTCItems.register(eventBus);
        CTCItemGroup.register(eventBus);
        CTCBlocks.register(eventBus);
        EntityTypes.ENTITY_TYPES.register(eventBus);

        GeckoLib.initialize();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CrittersForCatsCommonConfig.SPEC, "critters-for-cats-common.toml");

        MinecraftForge.EVENT_BUS.register(this);

        System.out.println("[Critters for Cats] Registered Critters for Cats.");
    }

}
