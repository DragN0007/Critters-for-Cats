package com.dragn0007.preycritters.items;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.entities.EntityTypes;
import com.dragn0007.preycritters.items.custom.MouseBileItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MilkBucketItem;
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

    //Food
    public static final RegistryObject<Item> MOUSE = ITEMS.register("mouse",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).meat().build())));
    public static final RegistryObject<Item> MOUSE_BILE = ITEMS.register("mouse_bile",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).build())));
    public static final RegistryObject<Item> MOUSE_EYE = ITEMS.register("mouse_eye",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 0.3F).build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}