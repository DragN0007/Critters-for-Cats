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
    protected void registerModels() {
        simpleItem(CTCItems.MOUSE);
        simpleItem(CTCItems.MOUSE_BILE);
        simpleItem(CTCItems.MOUSE_EYE);

        simpleItem(CTCItems.WHITE_BIRD_EGG);
        simpleItem(CTCItems.BLUE_BIRD_EGG);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrittersForCats.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder advancedItem(RegistryObject<Item> item, String getTextureName) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrittersForCats.MODID,"item/" + getTextureName));
    }
}