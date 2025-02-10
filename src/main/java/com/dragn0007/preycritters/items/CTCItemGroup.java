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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CTCItems.MOUSE_SPAWN_EGG.get())).title(Component.translatable("itemGroup.preycritters"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(CTCItems.MOUSE_SPAWN_EGG.get());
                        output.accept(CTCItems.SQUIRREL_SPAWN_EGG.get());
                        output.accept(CTCItems.VOLE_SPAWN_EGG.get());
                        output.accept(CTCItems.BEETLE_SPAWN_EGG.get());

                        output.accept(CTCItems.MOUSE.get());
                        output.accept(CTCItems.SQUIRREL.get());
                        output.accept(CTCItems.VOLE.get());

                        output.accept(CTCItems.MOUSE_BILE.get());
                        output.accept(CTCItems.MOUSE_EYE.get());
                        output.accept(CTCItems.WHITE_BIRD_EGG.get());
                        output.accept(CTCItems.BLUE_BIRD_EGG.get());
                        output.accept(CTCItems.BEETLE.get());

                        output.accept(CTCItems.SMALL_ANIMAL_BONE.get());
                        output.accept(CTCItems.SMALL_ANIMAL_SKULL.get());

                        output.accept(CTCBlocks.WHITE_BIRD_NEST.get());
                        output.accept(CTCBlocks.BLUE_BIRD_NEST.get());
                        output.accept(CTCBlocks.DIRT_VOLE_BURROW.get());
                        output.accept(CTCBlocks.SNOW_VOLE_BURROW.get());
                        output.accept(CTCBlocks.BUG_LOG.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
