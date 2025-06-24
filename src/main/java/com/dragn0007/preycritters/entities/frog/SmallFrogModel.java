package com.dragn0007.preycritters.entities.frog;

import com.dragn0007.preycritters.CrittersForCats;
import com.dragn0007.preycritters.entities.squirrel.Squirrel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SmallFrogModel extends DefaultedEntityGeoModel<SmallFrog> {

    public SmallFrogModel() {
        super(new ResourceLocation(CrittersForCats.MODID, "frog"), true);
    }

    @Override
    public void setCustomAnimations(SmallFrog animatable, long instanceId, AnimationState<SmallFrog> animationState) {

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

