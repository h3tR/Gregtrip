package ml.jozefpeeterslaan72wuustwezel.gregtrip;

//import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.tterrag.registrate.providers.ProviderType;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripItems;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.data.datagen.GTripLangHandler;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterShadersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GregtripMod.MODID)
public class GregtripMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gregtrip";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LoggerFactory.getLogger("Gregtrip");


    public GregtripMod()
    {


        GTripItems.init();
        GregtripGTAddon.REGISTRATE.addDataGenerator(ProviderType.LANG, GTripLangHandler::init);
        GregtripGTAddon.REGISTRATE.registerRegistrate();



        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static ResourceLocation id(String path){
        return new ResourceLocation(MODID,path);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @Nullable
        private static ShaderInstance renderTypeLSDSolid;
        private static ShaderInstance renderTypeLSDCutout;
        private static ShaderInstance renderTypeLSDCutoutMipped;

        private static ShaderInstance renderTypeLSDTranslucent;


        public static ShaderInstance getRenderTypeLSDSolid()
        {
            return Objects.requireNonNull(renderTypeLSDSolid, "Attempted to call getRenderTypeLSDSolid before shaders have finished loading.");
        }
        public static ShaderInstance getRenderTypeLSDCutout()
        {
            return Objects.requireNonNull(renderTypeLSDCutout, "Attempted to call getRenderTypeLSDCutout before shaders have finished loading.");
        }
        public static ShaderInstance getRenderTypeLSDCutoutMipped()
        {
            return Objects.requireNonNull(renderTypeLSDCutoutMipped, "Attempted to call getRenderTypeLSDCutout before shaders have finished loading.");
        }
        public static ShaderInstance getRenderTypeLSDTranslucent()
        {
            return Objects.requireNonNull(renderTypeLSDTranslucent, "Attempted to call getRenderTypeLSDTranslucent before shaders have finished loading.");
        }


        @SubscribeEvent
        public static void registerShaders(RegisterShadersEvent event) throws IOException
        {
            event.registerShader(new ShaderInstance(event.getResourceProvider(), new ResourceLocation("gregtrip","rendertype_lsd_solid"), DefaultVertexFormat.BLOCK), (shaderInstance) -> {
                renderTypeLSDSolid = shaderInstance;
            });
            event.registerShader(new ShaderInstance(event.getResourceProvider(), new ResourceLocation("gregtrip","rendertype_lsd_cutout"), DefaultVertexFormat.BLOCK), (shaderInstance) -> {
                renderTypeLSDCutout = shaderInstance;
            });
            event.registerShader(new ShaderInstance(event.getResourceProvider(), new ResourceLocation("gregtrip","rendertype_lsd_cutout_mipped"), DefaultVertexFormat.BLOCK), (shaderInstance) -> {
                renderTypeLSDCutoutMipped = shaderInstance;
            });
            event.registerShader(new ShaderInstance(event.getResourceProvider(), new ResourceLocation("gregtrip","rendertype_lsd_translucent"), DefaultVertexFormat.BLOCK), (shaderInstance) -> {
                renderTypeLSDTranslucent = shaderInstance;
            });
        }
    }

}
