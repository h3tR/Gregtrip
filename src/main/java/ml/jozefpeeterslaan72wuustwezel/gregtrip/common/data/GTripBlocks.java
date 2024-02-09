package ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.Tags;

import static ml.jozefpeeterslaan72wuustwezel.gregtrip.GregtripGTAddon.REGISTRATE;
//import static ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripCreativeModeTab.GTRIP;

public class GTripBlocks {
   /* static {
        REGISTRATE.creativeModeTab(()->GTRIP);
    }*/

    public static final BlockEntry<CropBlock> MORNING_GLORY_CROP = REGISTRATE.block("morning_glory", properties -> (CropBlock)new CropBlock(properties.randomTicks().noCollission().mapColor(MapColor.PLANT).sound(SoundType.CROP).instabreak().pushReaction(PushReaction.DESTROY)){
                @Override
                public int getMaxAge() {
                    return 4;
                }

                @Override
                protected ItemLike getBaseSeedId() {
                    return MORNING_GLORY_CROP.asItem();
                }
            })
            .addLayer(()->RenderType::cutout)
            .lang("Morning Glory")
            .setData(ProviderType.BLOCKSTATE,NonNullBiConsumer.noop())
            .item(ItemNameBlockItem::new)
                .tag(Tags.Items.SEEDS)
                .lang("Morning Glory Seeds")
                .defaultModel()
                .build()
            .register();

    public static void init(){
    }
}
