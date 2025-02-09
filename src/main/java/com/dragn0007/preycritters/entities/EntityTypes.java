package com.dragn0007.preycritters.entities;

import com.dragn0007.preycritters.entities.mouse.Mouse;
import com.dragn0007.preycritters.entities.squirrel.Squirrel;
import com.dragn0007.preycritters.entities.vole.Vole;
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
                    .sized(0.5f,0.5f)
                    .build(new ResourceLocation(MODID,"mouse").toString()));

    public static final RegistryObject<EntityType<Squirrel>> SQUIRREL_ENTITY = ENTITY_TYPES.register("squirrel",
            () -> EntityType.Builder.of(Squirrel::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,0.6f)
                    .build(new ResourceLocation(MODID,"squirrel").toString()));

    public static final RegistryObject<EntityType<Vole>> VOLE_ENTITY = ENTITY_TYPES.register("vole",
            () -> EntityType.Builder.of(Vole::new,
                            MobCategory.CREATURE)
                    .sized(0.5f,0.5f)
                    .build(new ResourceLocation(MODID,"vole").toString()));

}

