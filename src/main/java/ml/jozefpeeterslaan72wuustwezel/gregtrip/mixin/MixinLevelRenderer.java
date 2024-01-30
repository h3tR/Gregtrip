package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.GregtripMod;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinaccessors.Trippable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Desc;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


@Mixin(LevelRenderer.class)
public abstract class MixinLevelRenderer implements AutoCloseable, ResourceManagerReloadListener {
    @Shadow
    private int ticks;
    @Unique
    private final PerlinNoise noise = PerlinNoise.create(RandomSource.create(),0, DoubleList.of(1));

    private static final Map<RenderType, Supplier<ShaderInstance>> LSDShaderMap = new HashMap<>();
    static {
        LSDShaderMap.put(RenderType.solid(), GregtripMod.ClientModEvents::getRenderTypeLSDSolid);
        LSDShaderMap.put(RenderType.cutout(),GregtripMod.ClientModEvents::getRenderTypeLSDCutout);
        LSDShaderMap.put(RenderType.cutoutMipped(),GregtripMod.ClientModEvents::getRenderTypeLSDCutoutMipped);
        LSDShaderMap.put(RenderType.translucent(),GregtripMod.ClientModEvents::getRenderTypeLSDTranslucent);
    }

    //I don't really know why this is giving an error in IntelliJ but it works just fine in game
    @Inject(method = "renderChunkLayer", at = @At(value = "INVOKE", desc = @Desc(owner = RenderSystem.class, value = "getShader", ret = ShaderInstance.class)))
    private void renderChunkLayer(RenderType pRenderType, PoseStack pPoseStack, double pCamX, double pCamY, double pCamZ, Matrix4f pProjectionMatrix, CallbackInfo ci) {
        if(((Trippable)Minecraft.getInstance().player).getIsTripActive() && LSDShaderMap.containsKey(pRenderType)) {
            RenderSystem.setShader(LSDShaderMap.get(pRenderType));
            RenderSystem.getShader().safeGetUniform("Time").set(ticks);
            RenderSystem.getShader().safeGetUniform("WaveStrength").set(50f);
            RenderSystem.getShader().safeGetUniform("PlayerSpeed").set(Minecraft.getInstance().player.getDeltaMovement().toVector3f().length());
        }
    }
}

