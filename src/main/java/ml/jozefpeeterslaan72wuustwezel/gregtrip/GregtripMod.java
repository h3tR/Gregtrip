package ml.jozefpeeterslaan72wuustwezel.gregtrip;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.tterrag.registrate.providers.ProviderType;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripBlocks;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripItems;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripLootModifiers;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;

@Mod(GregtripMod.MODID)
public class GregtripMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gregtrip";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LoggerFactory.getLogger("Gregtrip");

    public GregtripMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        GTripItems.init();
        GTripBlocks.init();

        GTripLootModifiers.register(modEventBus);



        GregtripGTAddon.REGISTRATE.addDataGenerator(ProviderType.LANG, GTripLangHandler::init);
        GregtripGTAddon.REGISTRATE.registerRegistrate();



        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static ResourceLocation id(String path){
        return new ResourceLocation(MODID,path);
    }


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

    private static void registerShader(RegisterShadersEvent event, final String path, Consumer<ShaderInstance> shaderInstanceConsumer) throws IOException {
        event.registerShader(new ShaderInstance(event.getResourceProvider(), GregtripMod.id(path), DefaultVertexFormat.BLOCK),shaderInstanceConsumer);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

    private static final class ClientModEvents {
        @SubscribeEvent
        public static void register(RegisterShadersEvent event) throws IOException {

            registerShader(event, "rendertype_lsd_solid", (shaderInstance) -> renderTypeLSDSolid = shaderInstance);
            registerShader(event, "rendertype_lsd_cutout", (shaderInstance) -> renderTypeLSDCutout = shaderInstance);
            registerShader(event, "rendertype_lsd_cutout_mipped", (shaderInstance) -> renderTypeLSDCutoutMipped = shaderInstance);
            registerShader(event, "rendertype_lsd_translucent", (shaderInstance) -> renderTypeLSDTranslucent = shaderInstance);

        }
    }



}
