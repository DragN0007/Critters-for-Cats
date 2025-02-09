package com.dragn0007.preycritters.entities.vole;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VoleModel extends GeoModel<Vole> {

    public enum Variant {
        BLACK(new ResourceLocation(CrittersForCats.MODID, "textures/entity/vole/vole_black.png")),
        BROWN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/vole/vole_brown.png")),
        GREY(new ResourceLocation(CrittersForCats.MODID, "textures/entity/vole/vole_grey.png")),
        RED(new ResourceLocation(CrittersForCats.MODID, "textures/entity/vole/vole_red.png")),
        WHITE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/vole/vole_white.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/vole.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/mouse.animation.json");

    @Override
    public ResourceLocation getModelResource(Vole object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Vole object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(Vole animatable) {
        return ANIMATION;
    }
}

