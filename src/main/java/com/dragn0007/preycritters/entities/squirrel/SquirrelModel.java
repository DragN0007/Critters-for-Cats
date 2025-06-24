package com.dragn0007.preycritters.entities.squirrel;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.entities.snake.VenomousSnake;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SquirrelModel extends DefaultedEntityGeoModel<Squirrel> {

    public SquirrelModel() {
        super(new ResourceLocation(CrittersForCats.MODID, "squirrel"), true);
    }

    @Override
    public void setCustomAnimations(Squirrel animatable, long instanceId, AnimationState<Squirrel> animationState) {

        CoreGeoBone neck = getAnimationProcessor().getBone("neck");
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (neck != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            neck.setRotX(neck.getRotX() + (entityData.headPitch() * Mth.DEG_TO_RAD));
            float maxYaw = Mth.clamp(entityData.netHeadYaw(), -25.0f, 25.0f);
            neck.setRotY(neck.getRotY() + (maxYaw * Mth.DEG_TO_RAD));
        }

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(head.getRotX() + (entityData.headPitch() * Mth.DEG_TO_RAD));
            float maxYaw = Mth.clamp(entityData.netHeadYaw(), -25.0f, 25.0f);
            head.setRotY(head.getRotY() + (maxYaw * Mth.DEG_TO_RAD));
        }
    }

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

