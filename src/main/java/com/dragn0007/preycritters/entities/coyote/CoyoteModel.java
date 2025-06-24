package com.dragn0007.preycritters.entities.coyote;

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

public class CoyoteModel extends DefaultedEntityGeoModel<Coyote> {

    public CoyoteModel() {
        super(new ResourceLocation(CrittersForCats.MODID, "coyote"), true);
    }

    @Override
    public void setCustomAnimations(Coyote animatable, long instanceId, AnimationState<Coyote> animationState) {

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

