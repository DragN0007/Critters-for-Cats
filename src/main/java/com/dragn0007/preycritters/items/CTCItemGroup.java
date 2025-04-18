package com.dragn0007.preycritters.items;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.blocks.CTCBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CTCItemGroup {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrittersForCats.MODID);

    public static final RegistryObject<CreativeModeTab> PREY_CRITTERS_GROUP = CREATIVE_MODE_TABS.register("preycritters",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CTCItems.SMALL_ANIMAL_SKULL_ITEM.get())).title(Component.translatable("itemGroup.preycritters"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(CTCItems.MOUSE_SPAWN_EGG.get());
                        output.accept(CTCItems.SQUIRREL_SPAWN_EGG.get());
                        output.accept(CTCItems.VOLE_SPAWN_EGG.get());
                        output.accept(CTCItems.BEETLE_SPAWN_EGG.get());
                        output.accept(CTCItems.COYOTE_SPAWN_EGG.get());
                        output.accept(CTCItems.SONGBIRD_SPAWN_EGG.get());
                        output.accept(CTCItems.SMALL_FISH_SPAWN_EGG.get());
                        output.accept(CTCItems.SMALL_FROG_SPAWN_EGG.get());
                        output.accept(CTCItems.V_WOLF_SPAWN_EGG.get());
                        output.accept(CTCItems.V_FOX_SPAWN_EGG.get());
                        output.accept(CTCItems.SNAKE_SPAWN_EGG.get());
                        output.accept(CTCItems.VENOMOUS_SNAKE_SPAWN_EGG.get());
                        output.accept(CTCItems.LETHAL_SNAKE_SPAWN_EGG.get());

                        output.accept(CTCItems.MOUSE.get());
                        output.accept(CTCItems.SQUIRREL.get());
                        output.accept(CTCItems.VOLE.get());
                        output.accept(CTCItems.BEETLE.get());
                        output.accept(CTCItems.COYOTE.get());
                        output.accept(CTCItems.SONGBIRD.get());
                        output.accept(CTCItems.SMALL_FISH.get());
                        output.accept(CTCItems.SMALL_FROG.get());
                        output.accept(CTCItems.WOLF.get());
                        output.accept(CTCItems.FOX.get());
                        output.accept(CTCItems.SNAKE.get());

                        output.accept(CTCItems.MOUSE_BILE.get());
                        output.accept(CTCItems.MOUSE_EYE.get());
                        output.accept(CTCItems.WHITE_BIRD_EGG.get());
                        output.accept(CTCItems.BLUE_BIRD_EGG.get());
                        output.accept(CTCItems.COYOTE_HEART.get());
                        output.accept(CTCItems.SMALL_ANIMAL_BONE.get());
                        output.accept(CTCItems.SMALL_ANIMAL_SKULL_ITEM.get());
                        output.accept(CTCItems.COYOTE_TOOTH.get());
                        output.accept(CTCItems.COYOTE_SKULL_ITEM.get());
                        output.accept(CTCItems.SMALL_FISH_SKELETON.get());
                        output.accept(CTCItems.SMALL_FISH_SCALES.get());
                        output.accept(CTCItems.WOLF_HIDE.get());
                        output.accept(CTCItems.WOLF_SKULL_ITEM.get());
                        output.accept(CTCItems.FOX_TAIL.get());

                        output.accept(CTCItems.SMALL_FISH_BUCKET.get());

                        output.accept(CTCBlocks.WHITE_BIRD_NEST.get());
                        output.accept(CTCBlocks.BLUE_BIRD_NEST.get());
                        output.accept(CTCBlocks.DIRT_VOLE_BURROW.get());
                        output.accept(CTCBlocks.SNOW_VOLE_BURROW.get());
                        output.accept(CTCBlocks.BUG_LOG.get());
                        output.accept(CTCBlocks.MOUSE_BURROW.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
