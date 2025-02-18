package com.dragn0007.preycritters.entities.fish;

import com.dragn0007.preycritters.entities.mouse.Mouse;
import com.dragn0007.preycritters.entities.mouse.MouseModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SmallFishRender extends GeoEntityRenderer<SmallFish> {

    public SmallFishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SmallFishModel());
    }

    @Override
    public void render(SmallFish entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }

        if(!entity.isBaby()) {

            if (entity.getSize() == 0) {
                poseStack.scale(0.25F, 0.25F, 0.25F);
            }

            if (entity.getSize() == 1) {
                poseStack.scale(0.5F, 0.5F, 0.5F);
            }

            if (entity.getSize() == 2) {
                poseStack.scale(1.0F, 1.0F, 1.0F);
            }

            if (entity.getSize() == 3) {
                poseStack.scale(1.25F, 1.25F, 1.25F);
            }
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}