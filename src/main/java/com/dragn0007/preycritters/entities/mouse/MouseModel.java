package com.dragn0007.preycritters.entities.mouse;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MouseModel extends GeoModel<Mouse> {

    public enum Variant {
        BLACK(new ResourceLocation(CrittersForCats.MODID, "textures/entity/mouse/mouse_black.png")),
        BROWN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/mouse/mouse_brown.png")),
        GREY(new ResourceLocation(CrittersForCats.MODID, "textures/entity/mouse/mouse_grey.png")),
        RED(new ResourceLocation(CrittersForCats.MODID, "textures/entity/mouse/mouse_red.png")),
        WHITE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/mouse/mouse_white.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/mouse.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/mouse.animation.json");

    @Override
    public ResourceLocation getModelResource(Mouse object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Mouse object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(Mouse animatable) {
        return ANIMATION;
    }
}

