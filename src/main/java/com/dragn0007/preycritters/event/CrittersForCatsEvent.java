package com.dragn0007.preycritters.event;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.entities.EntityTypes;
import com.dragn0007.preycritters.entities.mouse.Mouse;
import com.dragn0007.preycritters.entities.mouse.MouseRender;
import com.dragn0007.preycritters.entities.squirrel.Squirrel;
import com.dragn0007.preycritters.entities.squirrel.SquirrelRender;
import com.dragn0007.preycritters.entities.vole.Vole;
import com.dragn0007.preycritters.entities.vole.VoleRender;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = CrittersForCats.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CrittersForCatsEvent {

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.MOUSE_ENTITY.get(), Mouse.createAttributes().build());
        event.put(EntityTypes.SQUIRREL_ENTITY.get(), Squirrel.createAttributes().build());
        event.put(EntityTypes.VOLE_ENTITY.get(), Vole.createAttributes().build());
    }

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityTypes.MOUSE_ENTITY.get(), MouseRender::new);
        EntityRenderers.register(EntityTypes.SQUIRREL_ENTITY.get(), SquirrelRender::new);
        EntityRenderers.register(EntityTypes.VOLE_ENTITY.get(), VoleRender::new);
    }

}