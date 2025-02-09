package com.dragn0007.preycritters.items;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.entities.EntityTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CTCItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CrittersForCats.MODID);

    //Spawn Eggs
    public static final RegistryObject<Item> MOUSE_SPAWN_EGG = ITEMS.register("mouse_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.MOUSE_ENTITY, 0x8c7465, 0xa08a79, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SQUIRREL_SPAWN_EGG = ITEMS.register("squirrel_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SQUIRREL_ENTITY, 0x5d574c, 0x8d8478, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> VOLE_SPAWN_EGG = ITEMS.register("vole_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.VOLE_ENTITY, 0x734e34, 0x603d27, new Item.Properties().stacksTo(64)));

    //Food
    public static final RegistryObject<Item> MOUSE = ITEMS.register("mouse",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).meat().build())));
    public static final RegistryObject<Item> MOUSE_BILE = ITEMS.register("mouse_bile",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).build())));
    public static final RegistryObject<Item> MOUSE_EYE = ITEMS.register("mouse_eye",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 0.3F).build())));
    public static final RegistryObject<Item> SQUIRREL = ITEMS.register("squirrel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).meat().build())));
    public static final RegistryObject<Item> VOLE = ITEMS.register("vole",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).meat().build())));

    public static final RegistryObject<Item> WHITE_BIRD_EGG = ITEMS.register("white_bird_egg",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).build())));
    public static final RegistryObject<Item> BLUE_BIRD_EGG = ITEMS.register("blue_bird_egg",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).build())));

    public static final RegistryObject<Item> SMALL_ANIMAL_BONE = ITEMS.register("small_animal_bone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_ANIMAL_SKULL = ITEMS.register("small_animal_skull",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}