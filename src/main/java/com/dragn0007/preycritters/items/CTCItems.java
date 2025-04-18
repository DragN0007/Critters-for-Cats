package com.dragn0007.preycritters.items;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.blocks.CTCBlocks;
import com.dragn0007.preycritters.entities.EntityTypes;
import com.dragn0007.preycritters.items.custom.MouseBileItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluids;
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
    public static final RegistryObject<Item> BEETLE_SPAWN_EGG = ITEMS.register("beetle_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.BEETLE_ENTITY, 0x383751, 0x12111c, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> COYOTE_SPAWN_EGG = ITEMS.register("coyote_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.COYOTE_ENTITY, 0xd5ab73, 0xd1baa6, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SONGBIRD_SPAWN_EGG = ITEMS.register("songbird_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SONGBIRD_ENTITY, 0x965326, 0xebc291, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SMALL_FISH_SPAWN_EGG = ITEMS.register("small_fish_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SMALL_FISH_ENTITY, 0xbdc2c1, 0x606c69, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SMALL_FROG_SPAWN_EGG = ITEMS.register("small_frog_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SMALL_FROG_ENTITY, 0x2c482d, 0xd8d8c8, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> V_WOLF_SPAWN_EGG = ITEMS.register("v_wolf_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.V_WOLF_ENTITY, 0x7e766e, 0x5c544e, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> V_FOX_SPAWN_EGG = ITEMS.register("v_fox_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.V_FOX_ENTITY, 0x883820, 0x563f34, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SNAKE_SPAWN_EGG = ITEMS.register("snake_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SNAKE_ENTITY, 0x363636, 0x563f34, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> VENOMOUS_SNAKE_SPAWN_EGG = ITEMS.register("venomous_snake_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.VENOMOUS_SNAKE_ENTITY, 0x393630, 0xad9681, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> LETHAL_SNAKE_SPAWN_EGG = ITEMS.register("lethal_snake_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.LETHAL_SNAKE_ENTITY, 0x2b1d19, 0x6a3e2f, new Item.Properties().stacksTo(64)));

    //Food
    public static final RegistryObject<Item> MOUSE = ITEMS.register("mouse",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1.1f).meat().build())));
    public static final RegistryObject<Item> MOUSE_BILE = ITEMS.register("mouse_bile",
            () -> new MouseBileItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> MOUSE_EYE = ITEMS.register("mouse_eye",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1F).build())));
    public static final RegistryObject<Item> SQUIRREL = ITEMS.register("squirrel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1.1f).meat().build())));
    public static final RegistryObject<Item> VOLE = ITEMS.register("vole",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(1.1f).meat().build())));
    public static final RegistryObject<Item> BEETLE = ITEMS.register("beetle",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(1.1f).build())));
    public static final RegistryObject<Item> COYOTE = ITEMS.register("coyote",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).effect(new MobEffectInstance(MobEffects.SATURATION, 4800, 0), 1F).build())));
    public static final RegistryObject<Item> COYOTE_HEART = ITEMS.register("coyote_heart",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(12).effect(new MobEffectInstance(MobEffects.SATURATION, 4800, 0), 1F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500, 0), 1F).build())));
    public static final RegistryObject<Item> SONGBIRD = ITEMS.register("songbird",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(1.1f).build())));
    public static final RegistryObject<Item> SMALL_FISH = ITEMS.register("small_fish",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1.1f).build())));
    public static final RegistryObject<Item> SMALL_FROG = ITEMS.register("small_frog",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(1.1f).build())));
    public static final RegistryObject<Item> WOLF = ITEMS.register("wolf",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(12).effect(new MobEffectInstance(MobEffects.SATURATION, 4800, 0), 1F).build())));
    public static final RegistryObject<Item> FOX = ITEMS.register("fox",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).effect(new MobEffectInstance(MobEffects.SATURATION, 4800, 0), 1F).build())));
    public static final RegistryObject<Item> SNAKE = ITEMS.register("snake",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).effect(new MobEffectInstance(MobEffects.SATURATION, 4800, 0), 1F).build())));

    public static final RegistryObject<Item> WHITE_BIRD_EGG = ITEMS.register("white_bird_egg",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).build())));
    public static final RegistryObject<Item> BLUE_BIRD_EGG = ITEMS.register("blue_bird_egg",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).build())));

    public static final RegistryObject<Item> SMALL_ANIMAL_BONE = ITEMS.register("small_animal_bone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_ANIMAL_SKULL_ITEM = ITEMS.register("small_animal_skull_item",
            () -> new BlockItem(CTCBlocks.SMALL_ANIMAL_SKULL.get(), (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> COYOTE_TOOTH = ITEMS.register("coyote_tooth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COYOTE_SKULL_ITEM = ITEMS.register("coyote_skull_item",
            () -> new BlockItem(CTCBlocks.COYOTE_SKULL.get(), (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> SMALL_FISH_BUCKET = ITEMS.register("small_fish_bucket",
            () -> new MobBucketItem(EntityTypes.SMALL_FISH_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_FILL_FISH, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SMALL_FISH_SKELETON = ITEMS.register("small_fish_skeleton",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_FISH_SCALES = ITEMS.register("small_fish_scales",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SONGBIRD_FEATHER = ITEMS.register("songbird_feather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WOLF_HIDE = ITEMS.register("wolf_hide",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WOLF_SKULL_ITEM = ITEMS.register("wolf_skull_item",
            () -> new BlockItem(CTCBlocks.WOLF_SKULL.get(), (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> FOX_TAIL = ITEMS.register("fox_tail",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}