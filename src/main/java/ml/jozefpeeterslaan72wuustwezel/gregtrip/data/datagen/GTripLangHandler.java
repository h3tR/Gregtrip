package ml.jozefpeeterslaan72wuustwezel.gregtrip.data.datagen;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.tterrag.registrate.providers.RegistrateLangProvider;


import java.util.Set;

import static com.tterrag.registrate.providers.RegistrateLangProvider.toEnglishName;
import static ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripMaterials.*;

public class GTripLangHandler extends LangHandler {
    private static final Set<Material> MATERIALS = Set.of(
            CalciumNitrate,
            MonoPotassiumPhosphate,
            MagnesiumSulfate,
            Iron2Sulfate,
            ZincSulfate,
            Manganese2chloride,
            PotassiumCarbonate,
            PotassiumHydroxide,
            BoricAcid,
            RockSaltSolution,
            LysergicAcidDiethylamide,
            NutrientMineralMixture,
            NutrientMedium,
            HoaglandAZTraceElementConcentrate,
            TartaricAcid,
            PotassiumBitartrate,
            CalciumTartrate,
            CalciumHydroxide,
            CalciumSulfate,
            Lees,
            ErgotAlkaloidTartrateSaltMixture,
            ErgotAlkaloidTartrateSaltSolution,
            ErgotAlkaloidAmideSolution,
            DLysergicAcidSolution,
            DLysergicAcid,
            Acetonitrile,
            AceticAnhydride,
            TrifluoroaceticAcid,
            TrifluoroacetylFluoride,
            Diethylamine,
            LysergicAcidDiethylamideResidue,
            LysergicAcidDiethylamideSolution,
            AlkaloidResidue,
            MorningGlorySeedSlurry,
            LysergicAcidAmideMixture,
            AmmoniumHydroxide

    );

    public static void init(RegistrateLangProvider provider)
    {

        for (Material material : MATERIALS) {
            provider.add(material.getUnlocalizedName(), toEnglishName(material.getName()));
        }

        replace(provider, Manganese2chloride.getUnlocalizedName(), "Manganese (II) Chloride");
        replace(provider, Iron2Sulfate.getUnlocalizedName(), "Iron (II) Sulfate");

        replace(provider, HoaglandAZTraceElementConcentrate.getUnlocalizedName(), "Hoagland A-Z trace element concentrate");
        replace(provider, LysergicAcidDiethylamide.getUnlocalizedName(), "Lysergic Acid Diethylamide (LSD-25)");
        replace(provider, DLysergicAcidSolution.getUnlocalizedName(), "D-Lysergic Acid Solution");
        replace(provider, DLysergicAcid.getUnlocalizedName(), "D-Lysergic Acid");
        replace(provider, LysergicAcidDiethylamideResidue.getUnlocalizedName(), "LSD-25 Residue");
    }


}
