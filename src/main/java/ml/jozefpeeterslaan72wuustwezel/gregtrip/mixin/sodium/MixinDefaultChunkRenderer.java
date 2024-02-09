package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixin.sodium;

import me.jellysquid.mods.sodium.client.gl.device.CommandList;
import me.jellysquid.mods.sodium.client.gl.device.RenderDevice;
import me.jellysquid.mods.sodium.client.render.chunk.ChunkRenderMatrices;
import me.jellysquid.mods.sodium.client.render.chunk.DefaultChunkRenderer;
import me.jellysquid.mods.sodium.client.render.chunk.ShaderChunkRenderer;
import me.jellysquid.mods.sodium.client.render.chunk.lists.ChunkRenderListIterable;
import me.jellysquid.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import me.jellysquid.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import me.jellysquid.mods.sodium.client.render.chunk.vertex.format.ChunkVertexType;
import me.jellysquid.mods.sodium.client.render.viewport.CameraTransform;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinhelpers.LSDModifierHelper;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinhelpers.sodium.LSDShaderInterface;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Desc;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultChunkRenderer.class)
public abstract class MixinDefaultChunkRenderer extends ShaderChunkRenderer {

    public MixinDefaultChunkRenderer(RenderDevice device, ChunkVertexType vertexType) {
        super(device, vertexType);
    }

    @Inject(method = "render", at = @At(value = "INVOKE", desc = @Desc(owner = ChunkShaderInterface.class, value = "setModelViewMatrix",  args=org.joml.Matrix4fc.class)), remap = false)
    public void render(ChunkRenderMatrices matrices, CommandList commandList, ChunkRenderListIterable renderLists, TerrainRenderPass renderPass, CameraTransform camera, CallbackInfo ci){
        if(this.activeProgram != null && this.activeProgram.getInterface() instanceof LSDShaderInterface shader){
            shader.setTime((float) Minecraft.getInstance().levelRenderer.getTicks());
            shader.setPlayerSpeedModifier(LSDModifierHelper.getPlayerSpeedModifier());
            shader.setWaveStrength(2f);
        }

    }
}
