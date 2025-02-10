package com.dragn0007.preycritters.entities.coyote;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CoyoteModel extends GeoModel<Coyote> {

    public enum Variant {
        DARK_BROWN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/coyote/coyote_dark_brown.png")),
        BROWN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/coyote/coyote_brown.png")),
        GREY(new ResourceLocation(CrittersForCats.MODID, "textures/entity/coyote/coyote_grey.png")),
        RED(new ResourceLocation(CrittersForCats.MODID, "textures/entity/coyote/coyote_red.png")),
        TAN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/coyote/coyote_tan.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/coyote.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/coyote.animation.json");

    @Override
    public ResourceLocation getModelResource(Coyote object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Coyote object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(Coyote animatable) {
        return ANIMATION;
    }
}

