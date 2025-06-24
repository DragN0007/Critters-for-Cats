package com.dragn0007.preycritters.entities.snake;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class VenomousSnakeModel extends DefaultedEntityGeoModel<VenomousSnake> {

    public VenomousSnakeModel() {
        super(new ResourceLocation(CrittersForCats.MODID, "ven_snake"), true);
    }

    @Override
    public void setCustomAnimations(VenomousSnake animatable, long instanceId, AnimationState<VenomousSnake> animationState) {

        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(head.getRotX() + (entityData.headPitch() * Mth.DEG_TO_RAD));
            float maxYaw = Mth.clamp(entityData.netHeadYaw(), -25.0f, 25.0f);
            head.setRotY(head.getRotY() + (maxYaw * Mth.DEG_TO_RAD));
        }
    }
    public enum Variant {
        RAT_SNAKE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/snake/snake_adder.png"));

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
    public ResourceLocation getModelResource(VenomousSnake object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(VenomousSnake object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(VenomousSnake animatable) {
        return ANIMATION;
    }
}

