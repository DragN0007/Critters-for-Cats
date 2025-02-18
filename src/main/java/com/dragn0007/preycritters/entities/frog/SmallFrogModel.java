package com.dragn0007.preycritters.entities.frog;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SmallFrogModel extends GeoModel<SmallFrog> {

    public enum Variant {
        BLUE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/frog/frog_blue.png")),
        BROWN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/frog/frog_brown.png")),
        GREEN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/frog/frog_green.png")),
        PURPLE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/frog/frog_purple.png")),
        RED(new ResourceLocation(CrittersForCats.MODID, "textures/entity/frog/frog_red.png")),
        YELLOW(new ResourceLocation(CrittersForCats.MODID, "textures/entity/frog/frog_yellow.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/frog.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/frog.animation.json");

    @Override
    public ResourceLocation getModelResource(SmallFrog object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(SmallFrog object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(SmallFrog animatable) {
        return ANIMATION;
    }
}

