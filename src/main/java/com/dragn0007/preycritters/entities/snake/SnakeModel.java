package com.dragn0007.preycritters.entities.snake;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SnakeModel extends GeoModel<Snake> {

    public enum Variant {
        RAT_SNAKE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/snake/snake_ratsnake.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/snake.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/snake.animation.json");

    @Override
    public ResourceLocation getModelResource(Snake object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Snake object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(Snake animatable) {
        return ANIMATION;
    }
}

