package com.dragn0007.preycritters.entities.squirrel;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SquirrelModel extends GeoModel<Squirrel> {

    public enum Variant {
        BLACK(new ResourceLocation(CrittersForCats.MODID, "textures/entity/squirrel/squirrel_black.png")),
        BROWN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/squirrel/squirrel_brown.png")),
        GREY(new ResourceLocation(CrittersForCats.MODID, "textures/entity/squirrel/squirrel_grey.png")),
        RED(new ResourceLocation(CrittersForCats.MODID, "textures/entity/squirrel/squirrel_red.png")),
        GOLD(new ResourceLocation(CrittersForCats.MODID, "textures/entity/squirrel/squirrel_gold.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/squirrel.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/squirrel.animation.json");

    @Override
    public ResourceLocation getModelResource(Squirrel object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Squirrel object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(Squirrel animatable) {
        return ANIMATION;
    }
}

