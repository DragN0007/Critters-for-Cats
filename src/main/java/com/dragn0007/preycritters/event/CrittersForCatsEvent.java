package com.dragn0007.preycritters.event;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.entities.EntityTypes;
import com.dragn0007.preycritters.entities.beetle.Beetle;
import com.dragn0007.preycritters.entities.beetle.BeetleRender;
import com.dragn0007.preycritters.entities.coyote.Coyote;
import com.dragn0007.preycritters.entities.coyote.CoyoteRender;
import com.dragn0007.preycritters.entities.fish.SmallFish;
import com.dragn0007.preycritters.entities.fish.SmallFishRender;
import com.dragn0007.preycritters.entities.mouse.Mouse;
import com.dragn0007.preycritters.entities.mouse.MouseRender;
import com.dragn0007.preycritters.entities.songbird.Songbird;
import com.dragn0007.preycritters.entities.songbird.SongbirdRender;
import com.dragn0007.preycritters.entities.squirrel.Squirrel;
import com.dragn0007.preycritters.entities.squirrel.SquirrelRender;
import com.dragn0007.preycritters.entities.vole.Vole;
import com.dragn0007.preycritters.entities.vole.VoleRender;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
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
        event.put(EntityTypes.BEETLE_ENTITY.get(), Beetle.createAttributes().build());
        event.put(EntityTypes.COYOTE_ENTITY.get(), Coyote.createAttributes().build());
        event.put(EntityTypes.SONGBIRD_ENTITY.get(), Songbird.createAttributes().build());
        event.put(EntityTypes.SMALL_FISH_ENTITY.get(), SmallFish.createAttributes().build());
    }

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityTypes.MOUSE_ENTITY.get(), MouseRender::new);
        EntityRenderers.register(EntityTypes.SQUIRREL_ENTITY.get(), SquirrelRender::new);
        EntityRenderers.register(EntityTypes.VOLE_ENTITY.get(), VoleRender::new);
        EntityRenderers.register(EntityTypes.BEETLE_ENTITY.get(), BeetleRender::new);
        EntityRenderers.register(EntityTypes.COYOTE_ENTITY.get(), CoyoteRender::new);
        EntityRenderers.register(EntityTypes.SONGBIRD_ENTITY.get(), SongbirdRender::new);
        EntityRenderers.register(EntityTypes.SMALL_FISH_ENTITY.get(), SmallFishRender::new);
    }

    @SubscribeEvent
    public static void spawnPlacementRegisterEvent(SpawnPlacementRegisterEvent event) {
        event.register(EntityTypes.MOUSE_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.SQUIRREL_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.VOLE_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.BEETLE_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.COYOTE_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.SONGBIRD_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.SMALL_FISH_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractSchoolingFish::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    }


}