package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixin;

import com.lowdragmc.lowdraglib.core.mixins.MixinPluginShared;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class GTripMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        System.out.println(mixinClassName);
        switch (mixinClassName){
          /*  case "ml.jozefpeeterslaan72wuustwezel.gregtrip.mixin.sodium.MixinTerrainRenderPass" -> {
               return MixinPluginShared.isClassFound("me.jellysquid.mods.sodium.client.render.chunk.terrain.TerrainRenderPass");
            }*/
            case "ml.jozefpeeterslaan72wuustwezel.gregtrip.mixin.MixinLevelRenderer" -> {
                return !MixinPluginShared.isClassFound("me.jellysquid.mods.sodium.client.render.chunk.terrain.TerrainRenderPass");
            }
            default -> {
                return true;
            }
        }
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }
}
