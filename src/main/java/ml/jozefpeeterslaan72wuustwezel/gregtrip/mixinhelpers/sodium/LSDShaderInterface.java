package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinhelpers.sodium;

import me.jellysquid.mods.sodium.client.gl.shader.uniform.GlUniformFloat;
import me.jellysquid.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import me.jellysquid.mods.sodium.client.render.chunk.shader.ChunkShaderOptions;
import me.jellysquid.mods.sodium.client.render.chunk.shader.ShaderBindingContext;

public class LSDShaderInterface extends ChunkShaderInterface {
    private final GlUniformFloat uniformTime;
    private final GlUniformFloat uniformPlayerSpeedModifier;
    private final GlUniformFloat uniformWaveStrength;



    public LSDShaderInterface(ShaderBindingContext context, ChunkShaderOptions options) {
        super(context,options);
        this.uniformPlayerSpeedModifier = context.bindUniform("u_PlayerSpeedModifier", GlUniformFloat::new);
        this.uniformTime = context.bindUniform("u_Time", GlUniformFloat::new);
        this.uniformWaveStrength = context.bindUniform("u_WaveStrength", GlUniformFloat::new);
    }

    public void setTime(float time){this.uniformTime.set(time);}
    public void setPlayerSpeedModifier(float playerSpeedModifier){this.uniformPlayerSpeedModifier.set(playerSpeedModifier);}
    public void setWaveStrength(float waveStrength){this.uniformWaveStrength.set(waveStrength);}
}
