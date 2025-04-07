package net.salamanderyyyy.testArien.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.salamanderyyyy.testArien.TestMod;
import net.salamanderyyyy.testArien.entity.custom.ArienEntity;
import org.jetbrains.annotations.NotNull;

public class ArienRenderer extends MobRenderer<ArienEntity, PlayerModel<ArienEntity>> {

    public ArienRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), true), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ArienEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "textures/entity/arien.png");
    }

    @Override
    public void render(@NotNull ArienEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        poseStack.scale(1.0f, 1.0f, 1.0f);
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}



