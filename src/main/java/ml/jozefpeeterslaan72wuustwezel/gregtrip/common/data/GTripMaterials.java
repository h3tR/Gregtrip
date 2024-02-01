package ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.GregtripMod;


import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

@SuppressWarnings("unused")
public class GTripMaterials {
    public static void init()
    {

    }

    public static final Material MonoPotassiumPhosphate = new Material.Builder(GregtripMod.id("monopotassium_phospate"))
            .dust()
            .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
            .color(0xDFEF55)
            .iconSet(MaterialIconSet.DULL)
            .components(Hydrogen,2,Potassium,1,Phosphate,1)
            .buildAndRegister();
    public static final Material MagnesiumSulfate = new Material.Builder(GregtripMod.id("magnesium_sulfate"))
            .dust()
            .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
            .color(0xDDFFDD)
            .iconSet(MaterialIconSet.DULL)

            .components(Magnesium,1,Sulfur,1,Oxygen,4)
            .buildAndRegister();
    public static final Material Iron2Sulfate = new Material.Builder(GregtripMod.id("iron_ii_sulfate"))
            .dust()
            .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
            .color(0x1384AF)
            .iconSet(MaterialIconSet.DULL)
            .components(Iron,1,Sulfur,1,Oxygen,4)
            .buildAndRegister();
    public static final Material ZincSulfate = new Material.Builder(GregtripMod.id("zinc_sulfate"))
            .dust()
            .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
            .color(0xEEDDFF)
            .iconSet(MaterialIconSet.DULL)
            .components(Zinc,1,Sulfur,1,Oxygen,4)
            .buildAndRegister();

    public static final Material CalciumNitrate = new Material.Builder(GregtripMod.id("calcium_nitrate"))
            .dust()
            .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
            .color(0xEEEEEE)
            .iconSet(MaterialIconSet.GLASS)
            .components(Calcium,1,Nitrogen,1,Oxygen,3)
            .buildAndRegister();

    public static final Material Lees = new Material.Builder(GregtripMod.id("lees"))
            .fluid()
            .color(0xFF99CC)
            .buildAndRegister();

    public static final Material Manganese2chloride = new Material.Builder(GregtripMod.id("manganese_ii_chloride"))
            .dust()
            .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
            .color(0xFFFFCC)
            .iconSet(MaterialIconSet.SHINY)
            .components(Manganese,1,Chlorine,2)
            .buildAndRegister();

    public static final Material PotassiumCarbonate = new Material.Builder(GregtripMod.id("potassium_carbonate"))
            .dust()
            .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
            .color(0xAA8888)
            .iconSet(MaterialIconSet.ROUGH)
            .components(Potassium,1,Carbon,1,Oxygen,3)
            .buildAndRegister();

    public static final Material PotassiumHydroxide = new Material.Builder(GregtripMod.id("potassium_hydroxide"))
            .dust()
            .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
            .color(0x89A8FF)
            .iconSet(MaterialIconSet.OPAL)
            .components(Potassium,1,Oxygen,1,Hydrogen,1)
            .buildAndRegister();

    public static final Material RockSaltSolution = new Material.Builder(GregtripMod.id("rock_salt_solution"))
            .fluid()
            .color(0xEECCFF)
            .buildAndRegister();

    public static final Material BoricAcid = new Material.Builder(GregtripMod.id("boric_acid"))
            .fluid()
            .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
            .color(0xFFC3A0)
            .components(Hydrogen,3,Boron,1,Oxygen,3)
            .buildAndRegister();

    public static final Material TartaricAcid = new Material.Builder(GregtripMod.id("tartaric_acid"))
            .fluid()
            .color(0xE2228D)
            .components(Carbon,4,Hydrogen,6,Oxygen,6)
            .buildAndRegister();

    public static final Material PotassiumBitartrate = new Material.Builder(GregtripMod.id("potassium_bitartrate"))
            .dust()
            .color(0xE2FF8D)
            .iconSet(MaterialIconSet.DULL)
            .components(Potassium,1,Carbon,4,Hydrogen,5,Oxygen,6)
            .buildAndRegister();
    public static final Material CalciumTartrate = new Material.Builder(GregtripMod.id("calcium_tartrate"))
            .dust()
            .color(0xFF3D8D)
            .iconSet(MaterialIconSet.DULL)
            .components(Calcium,1,Carbon,4,Hydrogen,4,Oxygen,6)
            .buildAndRegister();


    public static final Material CalciumHydroxide = new Material.Builder(GregtripMod.id("calcium_hydroxide"))
            .dust()
            .color(0xCDDDDD)
            .flags(MaterialFlags.DISABLE_DECOMPOSITION)
            .iconSet(MaterialIconSet.DULL)
            .components(Calcium,1,Hydrogen,2,Oxygen,2)
            .buildAndRegister().setFormula("Ca(OH)2");
    public static final Material CalciumSulfate = new Material.Builder(GregtripMod.id("calcium_sulfate"))
            .dust()
            .color(0xD8F2AB)
            .iconSet(MaterialIconSet.BRIGHT)
            .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
            .components(Calcium,1,Sulfur,1,Oxygen,4)
            .buildAndRegister();

    public static final Material LysergicAcidDiethylamide = new Material.Builder(GregtripMod.id("lysergic_acid_diethylamide"))
            .dust()
            .color(0xEEEEEE)
            .components(Carbon,20,Hydrogen,25,Nitrogen,3,Oxygen,1)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister();

    public static final Material NutrientMineralMixture = new Material.Builder(GregtripMod.id("nutrient_mineral_mixture"))
            .dust()
            .color(0xAAAAAA)
            .iconSet(MaterialIconSet.SAND)
            .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
            .components(RockSalt,3,ZincSulfate,2,CalciumNitrate,1,MonoPotassiumPhosphate,5,MagnesiumSulfate,5,Iron2Sulfate,2)
            .buildAndRegister();

    public static final Material NutrientMedium = new Material.Builder(GregtripMod.id("nutrient_medium"))
            .fluid()
            .color(0xEECCAA)
            .iconSet(MaterialIconSet.SAND)
            .buildAndRegister();

    public static final Material HoaglandAZTraceElementConcentrate = new Material.Builder(GregtripMod.id("hoagland_az_trace_element_concentrate"))
            .fluid()
            .color(0xAAAAFF)
            .iconSet(MaterialIconSet.SAND)
            .buildAndRegister();

    public static final Material ErgotAlkaloidTartrateSaltSolution = new Material.Builder(GregtripMod.id("ergot_alkaloids_tartrate_salt_solution"))
            .fluid()
            .color(0xDDBB88)
            .iconSet(MaterialIconSet.SAND)
            .buildAndRegister();
    public static final Material ErgotAlkaloidTartrateSaltMixture = new Material.Builder(GregtripMod.id("ergot_alkaloid_tartrate_salt_mixture"))
            .dust()
            .color(0xDDBB88)
            .iconSet(MaterialIconSet.SAND)
            .buildAndRegister();

    public static final Material ErgotAlkaloidAmideSolution = new Material.Builder(GregtripMod.id("ergot_alkaloid_amide_solution"))
            .fluid()
            .color(0x65FAB4)
            .iconSet(MaterialIconSet.SAND)
            .buildAndRegister();

    public static final Material DLysergicAcidSolution = new Material.Builder(GregtripMod.id("d_lysergic_acid_solution"))
            .fluid()
            .color(0xF58BA5)
            .iconSet(MaterialIconSet.SAND)
            .buildAndRegister();

    public static final Material DLysergicAcid = new Material.Builder(GregtripMod.id("d_lysergic_acid"))
            .dust()
            .color(0x56F3FE)
            .iconSet(MaterialIconSet.BRIGHT)
            .components(Carbon,16,Hydrogen,16,Nitrogen,2,Oxygen,2)
            .buildAndRegister();


    public static final Material Acetonitrile = new Material.Builder(GregtripMod.id("acetonitrile"))
            .fluid()
            .color(0xE22AA9)
            .iconSet(MaterialIconSet.BRIGHT)
            .components(Carbon,2,Hydrogen,3,Nitrogen,1)
            .buildAndRegister().setFormula("CH3CN");

    public static final Material AceticAnhydride = new Material.Builder(GregtripMod.id("acetic_anhydride"))
            .fluid()
            .color(0x884F24)
            .iconSet(MaterialIconSet.BRIGHT)
            .components(Carbon,4,Hydrogen,6,Oxygen,3)
            .buildAndRegister().setFormula("(CH3CO)2O");
    public static final Material TrifluoroacetylFluoride = new Material.Builder(GregtripMod.id("trifluoroacetyl_fluoride"))
            .fluid()
            .color(0xBBCF3F)
            .iconSet(MaterialIconSet.BRIGHT)
            .components(Carbon,2,Fluorine,4,Oxygen,1)
            .buildAndRegister().setFormula("CF3OF");

    public static final Material TrifluoroaceticAcid = new Material.Builder(GregtripMod.id("trifluoroaceetic_acid"))
            .fluid()
            .color(0xDAF263)
            .iconSet(MaterialIconSet.BRIGHT)
            .components(Carbon,2,Fluorine,3,Oxygen,2,Hydrogen,1)
            .buildAndRegister().setFormula("CF3COOH");

    public static final Material Diethylamine = new Material.Builder(GregtripMod.id("diethylamine"))
            .fluid()
            .color(0x683DDD)
            .iconSet(MaterialIconSet.BRIGHT)
            .components(Carbon,4,Nitrogen,1,Hydrogen,11)
            .buildAndRegister().setFormula("(CH3CH2)2NH");

    public static final Material LysergicAcidDiethylamideResidue = new Material.Builder(GregtripMod.id("lysergic_acid_diethylamide_residue"))
            .fluid()
            .color(0xD5F8F8)
            .iconSet(MaterialIconSet.BRIGHT)
            .buildAndRegister();

    public static final Material LysergicAcidDiethylamideSolution = new Material.Builder(GregtripMod.id("lysergic_acid_diethylamide_solution"))
            .fluid()
            .color(0xCCAA22)
            .iconSet(MaterialIconSet.BRIGHT)
            .buildAndRegister();

    public static final Material MorningGlorySeedSlurry = new Material.Builder(GregtripMod.id("morning_glory_seed_slurry"))
            .fluid()
            .color(0x2A5DD6)
            .iconSet(MaterialIconSet.BRIGHT)
            .buildAndRegister();


    public static final Material AmmoniumHydroxide = new Material.Builder(GregtripMod.id("ammonium_hydroxide"))
            .fluid()
            .color(0x88F996)
            .iconSet(MaterialIconSet.BRIGHT)
            .buildAndRegister();

    public static final Material AlkaloidResidue = new Material.Builder(GregtripMod.id("alkaloid_residue"))
            .dust()
            .color(0x45A3CF)
            .iconSet(MaterialIconSet.BRIGHT)
            .buildAndRegister();

    public static final Material LysergicAcidAmideMixture = new Material.Builder(GregtripMod.id("lysergic_acid_amide_mixture"))
            .dust()
            .color(0x25CFF8)
            .iconSet(MaterialIconSet.BRIGHT)
            .buildAndRegister();

}
