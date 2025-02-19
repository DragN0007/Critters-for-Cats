package com.dragn0007.preycritters.entities.wolf;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VWolfModel extends GeoModel<VWolf> {

    public enum Variant {
        BLACK(new ResourceLocation(CrittersForCats.MODID, "textures/entity/wolf/wolf_black.png")),
        BROWN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/wolf/wolf_brown.png")),
        GREY(new ResourceLocation(CrittersForCats.MODID, "textures/entity/wolf/wolf_grey.png")),
        BLUE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/wolf/wolf_blue.png")),
        WHITE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/wolf/wolf_white.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/wolf.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/wolf.animation.json");

    @Override
    public ResourceLocation getModelResource(VWolf object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(VWolf object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(VWolf animatable) {
        return ANIMATION;
    }
}

