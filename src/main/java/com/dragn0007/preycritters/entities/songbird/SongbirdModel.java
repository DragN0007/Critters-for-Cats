package com.dragn0007.preycritters.entities.songbird;

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

public class SongbirdModel extends DefaultedEntityGeoModel<Songbird> {

    public SongbirdModel() {
        super(new ResourceLocation(CrittersForCats.MODID, "songbird"), true);
    }

    @Override
    public void setCustomAnimations(Songbird animatable, long instanceId, AnimationState<Songbird> animationState) {

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

    public enum Species {
        BLUEBIRD(new ResourceLocation(CrittersForCats.MODID, "textures/entity/songbird/bluebird.png")),
        CEDAR_WAXWING(new ResourceLocation(CrittersForCats.MODID, "textures/entity/songbird/cedar_waxwing.png")),
        CHICKADEE(new ResourceLocation(CrittersForCats.MODID, "textures/entity/songbird/chickadee.png")),
        ROBIN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/songbird/robin.png")),
        SPARROW(new ResourceLocation(CrittersForCats.MODID, "textures/entity/songbird/sparrow.png")),
        WREN(new ResourceLocation(CrittersForCats.MODID, "textures/entity/songbird/wren.png")),
        YELLOW_FINCH(new ResourceLocation(CrittersForCats.MODID, "textures/entity/songbird/yellow_finch.png"));

        public final ResourceLocation resourceLocation;

        Species(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Species speciesFromOrdinal(int ordinal) {
            return Species.values()[ordinal % Species.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(CrittersForCats.MODID, "geo/songbird.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(CrittersForCats.MODID, "animations/songbird.animation.json");

    @Override
    public ResourceLocation getModelResource(Songbird object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Songbird object) {
        return Species.speciesFromOrdinal(object.getSpecies()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(Songbird animatable) {
        return ANIMATION;
    }
}

