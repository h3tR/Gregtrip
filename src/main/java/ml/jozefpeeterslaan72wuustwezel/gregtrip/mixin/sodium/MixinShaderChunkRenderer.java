package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixin.sodium;


import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import me.jellysquid.mods.sodium.client.gl.shader.*;
import me.jellysquid.mods.sodium.client.render.chunk.ChunkRenderer;
import me.jellysquid.mods.sodium.client.render.chunk.ShaderChunkRenderer;
import me.jellysquid.mods.sodium.client.render.chunk.shader.ChunkShaderBindingPoints;
import me.jellysquid.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import me.jellysquid.mods.sodium.client.render.chunk.shader.ChunkShaderOptions;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.GregtripMod;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinhelpers.Trippable;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinhelpers.sodium.LSDShaderInterface;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(ShaderChunkRenderer.class)
public abstract class MixinShaderChunkRenderer implements ChunkRenderer {

    @Unique
    private final Map<ChunkShaderOptions, GlProgram<ChunkShaderInterface>> gTrip$LSDPrograms = new Object2ObjectOpenHashMap<>();

    @Inject(method = "compileProgram",at = @At("HEAD"),remap = false, cancellable = true)
    protected void compileProgram(ChunkShaderOptions options, CallbackInfoReturnable<GlProgram<ChunkShaderInterface>> cir){
        assert Minecraft.getInstance().player != null;
        if(((Trippable) Minecraft.getInstance().player).gTrip$getIsTripActive()){
            GlProgram<ChunkShaderInterface> program = this.gTrip$LSDPrograms.get(options);

            if (program == null) {
                this.gTrip$LSDPrograms.put(options, program = this.gTrip$createLSDShader( options));
            }
            cir.setReturnValue(program);
        }

    }

    @Shadow
    protected abstract GlProgram.Builder bindAttributesForType(GlProgram.Builder builder);

    @Unique
    private GlProgram<ChunkShaderInterface> gTrip$createLSDShader(ChunkShaderOptions options) {
        ShaderConstants constants = options.constants();

        GlShader vertShader = ShaderLoader.loadShader(ShaderType.VERTEX,
                new ResourceLocation(GregtripMod.MODID, "blocks/lsd_block_layer_opaque" + ".vsh"), constants);

        GlShader fragShader = ShaderLoader.loadShader(ShaderType.FRAGMENT,
                new ResourceLocation("sodium", "blocks/block_layer_opaque" + ".fsh"), constants);

        try {
            return bindAttributesForType(GlProgram.builder(new ResourceLocation("gregtrip", "lsd_chunk_shader"))
                    .attachShader(vertShader)
                    .attachShader(fragShader))
                    .bindFragmentData("out_FragColor", ChunkShaderBindingPoints.FRAG_COLOR)
                    .link((shader) -> new LSDShaderInterface(shader, options));
        } finally {
            vertShader.delete();
            fragShader.delete();
        }
    }
}
