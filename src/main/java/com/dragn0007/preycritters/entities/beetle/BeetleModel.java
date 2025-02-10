package com.dragn0007.preycritters.entities.beetle;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BeetleModel extends GeoModel<Beetle> {

    public enum Variant {
        BLACK(new ResourceLocation(CrittersForCats.MODID, "textures/entity/beetle/beetle_black.png")),
        BROWN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/beetle/beetle_brown.png")),
        GREEN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/beetle/beetle_green.png")),
        YELLOW(new ResourceLocation(CrittersForCats.MODID, "textures/entity/beetle/beetle_yellow.png")),
        LIME(new ResourceLocation(CrittersForCats.MODID, "textures/entity/beetle/beetle_lime.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/beetle.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/beetle.animation.json");

    @Override
    public ResourceLocation getModelResource(Beetle object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Beetle object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(Beetle animatable) {
        return ANIMATION;
    }
}

