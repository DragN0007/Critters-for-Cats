package com.dragn0007.preycritters.entities.songbird;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SongbirdRender extends GeoEntityRenderer<Songbird> {

    public SongbirdRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SongbirdModel());
    }

    @Override
    public void render(Songbird entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }

        if(!entity.isBaby()) {

            if (entity.getSpecies() == 0) {
                poseStack.scale(0.8F, 0.8F, 0.8F);
            }

            if (entity.getSpecies() == 1) {
                poseStack.scale(1.1F, 1.1F, 1.1F);
            }

            if (entity.getSpecies() == 2) {
                poseStack.scale(0.7F, 0.7F, 0.7F);
            }

            if (entity.getSpecies() == 3) {
                poseStack.scale(1.1F, 1.1F, 1.1F);
            }

            if (entity.getSpecies() == 4) {
                poseStack.scale(0.8F, 0.8F, 0.8F);
            }

            if (entity.getSpecies() == 5) {
                poseStack.scale(0.9F, 0.9F, 0.9F);
            }

            if (entity.getSpecies() == 6) {
                poseStack.scale(0.8F, 0.8F, 0.8F);
            }

        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}