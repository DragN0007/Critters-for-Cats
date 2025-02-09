package com.dragn0007.preycritters.entities.vole;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VoleRender extends GeoEntityRenderer<Vole> {

    public VoleRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new VoleModel());
    }

    @Override
    public void render(Vole entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}