package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.GregtripMod;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Desc;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LevelRenderer.class)
public abstract class MixinLevelRenderer implements AutoCloseable, ResourceManagerReloadListener {
   /* @Unique
    private final PerlinNoise noise = PerlinNoise.create(RandomSource.create(),0, DoubleList.of(1));*/


    //I don't really know why this is giving an error in IntelliJ, but it works just fine in game.
    @Inject(method = "renderChunkLayer", at = @At(value = "INVOKE", desc = @Desc(owner = RenderSystem.class, value = "getShader", ret = ShaderInstance.class)))
    private void renderChunkLayer(RenderType pRenderType, PoseStack pPoseStack, double pCamX, double pCamY, double pCamZ, Matrix4f pProjectionMatrix, CallbackInfo ci) {
        GregtripMod.setupLSDShader(pRenderType);
    }

}

