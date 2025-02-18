package com.dragn0007.preycritters.entities.fish;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SmallFishModel extends GeoModel<SmallFish> {

    public enum Variant {
        BLUE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fish/fish_blue.png")),
        BROWN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fish/fish_brown.png")),
        GREEN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fish/fish_green.png")),
        GREY(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fish/fish_grey.png")),
        LIME(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fish/fish_lime.png")),
        ORANGE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fish/fish_orange.png")),
        PURPLE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fish/fish_purple.png")),
        RED(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fish/fish_red.png")),
        SILVER(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fish/fish_silver.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/fish.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/fish.animation.json");

    @Override
    public ResourceLocation getModelResource(SmallFish object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(SmallFish object) {
        return object.getTextureResource();
    }

    @Override
    public ResourceLocation getAnimationResource(SmallFish animatable) {
        return ANIMATION;
    }
}

