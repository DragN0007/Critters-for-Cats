package com.dragn0007.preycritters.entities.wolf;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VWolfRender extends GeoEntityRenderer<VWolf> {

    public VWolfRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new VWolfModel());
        this.addRenderLayer(new VWolfLeaderLayer(this));
    }

    @Override
    public void preRender(PoseStack poseStack, VWolf animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if (animatable.hasFollowers()) {
            poseStack.scale(1.2F, 1.2F, 1.2F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

}