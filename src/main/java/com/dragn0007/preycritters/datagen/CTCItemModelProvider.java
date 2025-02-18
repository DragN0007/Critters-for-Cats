package com.dragn0007.preycritters.datagen;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.items.CTCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CTCItemModelProvider extends ItemModelProvider {
    public CTCItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrittersForCats.MODID, existingFileHelper);
    }

    @Override
    public void registerModels() {
        simpleItem(CTCItems.MOUSE);
        simpleItem(CTCItems.MOUSE_BILE);
        simpleItem(CTCItems.MOUSE_EYE);
        simpleItem(CTCItems.SQUIRREL);
        simpleItem(CTCItems.VOLE);
        simpleItem(CTCItems.BEETLE);
        simpleItem(CTCItems.COYOTE);
        simpleItem(CTCItems.COYOTE_HEART);
        simpleItem(CTCItems.SMALL_FISH);
        simpleItem(CTCItems.SONGBIRD);
        simpleItem(CTCItems.SMALL_FROG);

        simpleItem(CTCItems.WHITE_BIRD_EGG);
        simpleItem(CTCItems.BLUE_BIRD_EGG);

        simpleItem(CTCItems.SMALL_ANIMAL_BONE);
        simpleItem(CTCItems.SMALL_ANIMAL_SKULL);
        simpleItem(CTCItems.COYOTE_TOOTH);
        simpleItem(CTCItems.COYOTE_SKULL_ITEM);
        simpleItem(CTCItems.SMALL_FISH_SKELETON);
        simpleItem(CTCItems.SMALL_FISH_SCALES);

        simpleItem(CTCItems.SMALL_FISH_BUCKET);
    }

    public ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrittersForCats.MODID,"item/" + item.getId().getPath()));
    }

    public ItemModelBuilder advancedItem(RegistryObject<Item> item, String getTextureName) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrittersForCats.MODID,"item/" + getTextureName));
    }
}