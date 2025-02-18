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

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}