package com.dragn0007.preycritters.entities.songbird;

import com.dragn0007.preycritters.CrittersForCats;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SongbirdModel extends GeoModel<Songbird> {

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

