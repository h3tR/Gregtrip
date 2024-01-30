package ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.common.item.AcidBlotterItem;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.food.FoodProperties;
import static com.gregtechceu.gtceu.common.data.GTModels.createTextureModel;
import static ml.jozefpeeterslaan72wuustwezel.gregtrip.GregtripGTAddon.REGISTRATE;

public class GTripItems {


    public static final ItemEntry<ComponentItem> IMMATURE_ERGOT_CULTURE = REGISTRATE.item("immature_ergot_culture", ComponentItem::create)
            .lang("Immature Ergot Culture")
            .properties(p -> p.stacksTo(16))
            .defaultModel()
            .register();

    public static final ItemEntry<ComponentItem> MATURE_ERGOT_CULTURE = REGISTRATE.item("mature_ergot_culture", ComponentItem::create)
            .lang("Mature Ergot Culture")
            .properties(p -> p.stacksTo(16))
            .defaultModel()
            .register();

    public static final ItemEntry<ComponentItem> NEUTRALIZED_ERGOT_CULTURE = REGISTRATE.item("neutralized_ergot_culture", ComponentItem::create)
            .lang("Neutralized Ergot Culture")
            .properties(p -> p.stacksTo(16))
            .defaultModel()
            .register();

    public static final ItemEntry<ComponentItem> BLOTTER_SHEET = REGISTRATE.item("blotter_sheet", ComponentItem::create)
            .lang("Blotter Sheet")
            .properties(p -> p.stacksTo(16))
            .defaultModel()
            .register();

    public static final ItemEntry<ComponentItem> BLOTTER = REGISTRATE.item("blotter", ComponentItem::create)
            .lang("Blotter")
            .defaultModel()
            .register();

    public static final ItemEntry<ComponentItem> ERGOT_FUNGAL_SAMPLE = REGISTRATE.item("ergot_fungal_sample", ComponentItem::create)
            .lang("Ergot Fungal Sample")
            .defaultModel()
            .register();

    public static final ItemEntry<AcidBlotterItem> ACID_BLOTTER = REGISTRATE.item("acid_blotter", AcidBlotterItem::new)
            .lang("§aLSD Blotter§r")
            .properties(p -> p.food(new FoodProperties.Builder().fast().build()))
            .defaultModel()
            .register();

    public static final ItemEntry<AcidBlotterItem> INFUSED_SUGAR_CUBE = REGISTRATE.item("infused_sugar_cube", AcidBlotterItem::new)
            .lang("§aLSD Infused Sugar Cube§r")
            .properties(p -> p.food(new FoodProperties.Builder().fast().nutrition(1).build()))
            .color(() -> () ->((ItemColor) (arg, i) -> GTMaterials.Sugar.getMaterialARGB()))
            .model(NonNullBiConsumer.noop())
            .register();


    //renderChunkLayer mess with this to make funny colors and movement visuals

    public static void init(){
    }
}
