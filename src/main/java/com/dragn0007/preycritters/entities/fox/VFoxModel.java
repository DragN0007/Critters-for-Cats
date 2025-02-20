package com.dragn0007.preycritters.entities.fox;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VFoxModel extends GeoModel<VFox> {

    public enum Variant {
        BLACK(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fox/fox_black.png")),
        RED(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fox/fox_red.png")),
        SILVER(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fox/fox_silver.png")),
        WHITE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/fox/fox_white.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/fox.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/fox.animation.json");

    @Override
    public ResourceLocation getModelResource(VFox object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(VFox object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(VFox animatable) {
        return ANIMATION;
    }
}

