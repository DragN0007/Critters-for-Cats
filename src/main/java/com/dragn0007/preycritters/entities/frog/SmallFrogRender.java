package com.dragn0007.preycritters.entities.frog;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SmallFrogRender extends GeoEntityRenderer<SmallFrog> {

    public SmallFrogRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SmallFrogModel());
    }

    @Override
    public void render(SmallFrog entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }

        if(!entity.isBaby()) {

            if (entity.getSize() == 0) {
                poseStack.scale(0.5F, 0.5F, 0.5F);
            }

            if (entity.getSize() == 1) {
                poseStack.scale(1.0F, 1.0F, 1.0F);
            }

            if (entity.getSize() == 2) {
                poseStack.scale(1.25F, 1.25F, 1.25F);
            }
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}