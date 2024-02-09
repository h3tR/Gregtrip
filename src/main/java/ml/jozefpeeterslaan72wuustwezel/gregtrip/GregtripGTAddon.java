package ml.jozefpeeterslaan72wuustwezel.gregtrip;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripMaterials;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripRecipes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@GTAddon
public class GregtripGTAddon implements IGTAddon {

    public static final GTRegistrate REGISTRATE = GTRegistrate.create(GregtripMod.MODID);


    @Override
    public void registerMaterials() {
        GTripMaterials.init();
    }

    @Override
    public void initializeAddon() {
        //GameRenderer
    }

    @Override
    public String addonModId() {
        return GregtripMod.MODID;
    }




    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        GTripRecipes.init(provider);
    }

}
