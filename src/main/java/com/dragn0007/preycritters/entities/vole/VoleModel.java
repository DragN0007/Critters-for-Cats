package com.dragn0007.preycritters.entities.vole;

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

public class VoleModel extends DefaultedEntityGeoModel<Vole> {

    public VoleModel() {
        super(new ResourceLocation(CrittersForCats.MODID, "vole"), true);
    }

    @Override
    public void setCustomAnimations(Vole animatable, long instanceId, AnimationState<Vole> animationState) {

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

