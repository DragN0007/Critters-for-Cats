package com.dragn0007.preycritters.items;

import com.dragn0007.preycritters.CrittersForCats;
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

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
