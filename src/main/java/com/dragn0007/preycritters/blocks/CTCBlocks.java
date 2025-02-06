package com.dragn0007.preycritters.blocks;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.items.CTCItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CTCBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, CrittersForCats.MODID);

    public static final RegistryObject<Block> WHITE_BIRD_NEST = registerBlock("white_bird_nest",
            () -> new BirdNest());
    public static final RegistryObject<Block> BLUE_BIRD_NEST = registerBlock("blue_bird_nest",
            () -> new BirdNest());

    protected static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    protected static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        CTCItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
