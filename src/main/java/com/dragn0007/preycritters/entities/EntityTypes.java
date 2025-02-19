package com.dragn0007.preycritters.entities;

import com.dragn0007.preycritters.entities.beetle.Beetle;
import com.dragn0007.preycritters.entities.coyote.Coyote;
import com.dragn0007.preycritters.entities.fish.SmallFish;
import com.dragn0007.preycritters.entities.frog.SmallFrog;
import com.dragn0007.preycritters.entities.mouse.Mouse;
import com.dragn0007.preycritters.entities.songbird.Songbird;
import com.dragn0007.preycritters.entities.squirrel.Squirrel;
import com.dragn0007.preycritters.entities.vole.Vole;
import com.dragn0007.preycritters.entities.wolf.VWolf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.dragn0007.preycritters.CrittersForCats.MODID;

public class EntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<EntityType<Mouse>> MOUSE_ENTITY = ENTITY_TYPES.register("mouse",
            () -> EntityType.Builder.of(Mouse::new,
                    MobCategory.CREATURE)
                    .sized(0.25f,0.2f)
                    .build(new ResourceLocation(MODID,"mouse").toString()));

    public static final RegistryObject<EntityType<Squirrel>> SQUIRREL_ENTITY = ENTITY_TYPES.register("squirrel",
            () -> EntityType.Builder.of(Squirrel::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,0.6f)
                    .build(new ResourceLocation(MODID,"squirrel").toString()));

    public static final RegistryObject<EntityType<Vole>> VOLE_ENTITY = ENTITY_TYPES.register("vole",
            () -> EntityType.Builder.of(Vole::new,
                            MobCategory.CREATURE)
                    .sized(0.4f,0.3f)
                    .build(new ResourceLocation(MODID,"vole").toString()));

    public static final RegistryObject<EntityType<Beetle>> BEETLE_ENTITY = ENTITY_TYPES.register("beetle",
            () -> EntityType.Builder.of(Beetle::new,
                            MobCategory.CREATURE)
                    .sized(0.3f,0.1f)
                    .build(new ResourceLocation(MODID,"beetle").toString()));

    public static final RegistryObject<EntityType<Coyote>> COYOTE_ENTITY = ENTITY_TYPES.register("coyote",
            () -> EntityType.Builder.of(Coyote::new,
                            MobCategory.CREATURE)
                    .sized(0.8f,0.8f)
                    .build(new ResourceLocation(MODID,"coyote").toString()));

    public static final RegistryObject<EntityType<Songbird>> SONGBIRD_ENTITY = ENTITY_TYPES.register("songbird",
            () -> EntityType.Builder.of(Songbird::new,
                            MobCategory.CREATURE)
                    .sized(0.3f,0.3f)
                    .build(new ResourceLocation(MODID,"songbird").toString()));

    public static final RegistryObject<EntityType<SmallFish>> SMALL_FISH_ENTITY = ENTITY_TYPES.register("small_fish",
            () -> EntityType.Builder.of(SmallFish::new,
                            MobCategory.WATER_AMBIENT)
                    .sized(0.3f,0.3f)
                    .build(new ResourceLocation(MODID,"small_fish").toString()));

    public static final RegistryObject<EntityType<SmallFrog>> SMALL_FROG_ENTITY = ENTITY_TYPES.register("small_frog",
            () -> EntityType.Builder.of(SmallFrog::new,
                            MobCategory.CREATURE)
                    .sized(0.3f,0.3f)
                    .build(new ResourceLocation(MODID,"small_frog").toString()));

    public static final RegistryObject<EntityType<VWolf>> V_WOLF_ENTITY = ENTITY_TYPES.register("v_wolf",
            () -> EntityType.Builder.of(VWolf::new,
                            MobCategory.CREATURE)
                    .sized(1.2f,1.2f)
                    .build(new ResourceLocation(MODID,"v_wolf").toString()));

}

