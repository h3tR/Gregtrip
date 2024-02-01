package ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType.STERILE_CLEANROOM;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripMaterials.*;
import static ml.jozefpeeterslaan72wuustwezel.gregtrip.common.data.GTripItems.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
public class GTripRecipes {
    public static void init(Consumer<FinishedRecipe> provider)
    {
        //GT recipe overrides
        DISTILLATION_RECIPES.recipeBuilder("distill_biomass")
                .inputFluids(Biomass.getFluid(1000))
                .outputItems(dustSmall, Wood,2)
                .outputFluids(Water.getFluid(300))
                .outputFluids(Ethanol.getFluid(600))
                .outputFluids(Lees.getFluid(50))
                .duration(80).EUt(VA[HV])
                .save(provider);




        //GTrip recipes
        CHEMICAL_RECIPES.recipeBuilder("zinc_sulfate")
                .inputItems(dust,Zinc)
                .inputFluids(SulfuricAcid.getFluid(FluidHelper.getBucket()))
                .outputFluids(Hydrogen.getFluid(2*FluidHelper.getBucket()))
                .outputItems(dust,ZincSulfate)
                .duration(120).EUt(VA[MV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("zinc_sulfate_zincite")
                .inputItems(dust,Zincite)
                .inputFluids(SulfuricAcid.getFluid(FluidHelper.getBucket()))
                .outputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,ZincSulfate)
                .duration(360).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("manganese_ii_chloride")
                .inputItems(dust,Pyrolusite)
                .inputFluids(HydrochloricAcid.getFluid(4*FluidHelper.getBucket()))
                .outputFluids(Water.getFluid(2*FluidHelper.getBucket()))
                .outputFluids(Chlorine.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,Manganese2chloride)
                .duration(90).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("iron_ii_sulfate")
                .inputItems(dust,Iron)
                .inputFluids(SulfuricAcid.getFluid(FluidHelper.getBucket()))
                .outputFluids(Hydrogen.getFluid(2*FluidHelper.getBucket()))
                .outputItems(dust,Iron2Sulfate,2)
                .duration(600).EUt(VA[MV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("iron_ii_sulfate_pyrite")
                .inputItems(dust,Pyrite)
                .inputFluids(Oxygen.getFluid(7*FluidHelper.getBucket()))
                .inputFluids(Water.getFluid(2*FluidHelper.getBucket()))
                .outputFluids(SulfuricAcid.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,Iron2Sulfate,2)
                .duration(60).EUt(VA[HV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("magnesium_sulfate")
                .inputItems(dust,Magnesite)
                .inputFluids(SulfuricAcid.getFluid(FluidHelper.getBucket()))
                .outputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputFluids(CarbonDioxide.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,MagnesiumSulfate)
                .duration(120).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("calcium_nitrate_apatite")
                .inputItems(dust,Apatite)
                .inputFluids(NitricAcid.getFluid(10*FluidHelper.getBucket()))
                .outputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputFluids(PhosphoricAcid.getFluid(3*FluidHelper.getBucket()))
                .outputItems(dust,CalciumNitrate,5)
                .duration(120).EUt(VA[HV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("calcium_nitrate_calcite")
                .inputItems(dust,Calcite)
                .inputFluids(NitricAcid.getFluid(2*FluidHelper.getBucket()))
                .outputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputFluids(CarbonDioxide.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,CalciumNitrate)
                .duration(120).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("boric_acid")
                .inputItems(dust,Borax)
                .inputFluids(HydrochloricAcid.getFluid(2*FluidHelper.getBucket()))
                .outputFluids(Water.getFluid(5*FluidHelper.getBucket()))
                .outputFluids(BoricAcid.getFluid(4*FluidHelper.getBucket()))
                .outputItems(dust,Salt,2)
                .duration(120).EUt(VA[LV]).save(provider);

        MIXER_RECIPES.recipeBuilder("rock_salt_solution")
                .inputItems(dust, RockSalt,2)
                .inputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputFluids(RockSaltSolution.getFluid(FluidHelper.getBucket()))
                .duration(360).EUt(VA[LV]).save(provider);

        ELECTROLYZER_RECIPES.recipeBuilder("potassium_chloralkali")
                .inputFluids(RockSaltSolution.getFluid(FluidHelper.getBucket()))
                .outputFluids(Chlorine.getFluid(FluidHelper.getBucket()))
                .outputFluids(Hydrogen.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,PotassiumHydroxide,3)
                .duration(360).EUt(VA[MV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("potassium_carbonate")
                .inputItems(dust,PotassiumHydroxide,2)
                .inputFluids(CarbonDioxide.getFluid(FluidHelper.getBucket()))
                .outputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,PotassiumCarbonate)
                .duration(120).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("monopotassium_phosphate")
                .inputItems(dust,PotassiumCarbonate)
                .inputFluids(PhosphoricAcid.getFluid(6*FluidHelper.getBucket()))
                .outputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputFluids(CarbonDioxide.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,MonoPotassiumPhosphate, 3)
                .duration(120).EUt(VA[LV]).save(provider);

        MIXER_RECIPES.recipeBuilder("nutrient_mineral_mixture")
                .inputItems(dust, RockSalt,3)
                .inputItems(dust, ZincSulfate,2)
                .inputItems(dust, CalciumNitrate)
                .inputItems(dust, MonoPotassiumPhosphate,5)
                .inputItems(dust, MagnesiumSulfate,5)
                .inputItems(dust, Iron2Sulfate,2)
                .outputItems(dust,NutrientMineralMixture,18)
                .duration(360).EUt(VA[LV]).save(provider);

        MIXER_RECIPES.recipeBuilder("hoagland_az_trace_element_concentrate")
                .inputItems(dust, CalciumNitrate,2)
                .inputItems(dust, MagnesiumSulfate,2)
                .inputItems(dust, MonoPotassiumPhosphate,2)
                .inputItems(dust, ZincSulfate)
                .inputItems(dust, Saltpeter,2)
                .inputItems(dust, Manganese2chloride)
                .inputFluids(BoricAcid.getFluid(100))
                .inputFluids(DistilledWater.getFluid(FluidHelper.getBucket()))
                .outputFluids(HoaglandAZTraceElementConcentrate.getFluid(FluidHelper.getBucket()))
                .duration(60).EUt(VA[LV]).save(provider);

        MIXER_RECIPES.recipeBuilder("nutrient_medium")
                .inputItems(dust, Sugar,10)
                .inputItems(dust, Wheat,5)
                .inputItems(dust, NutrientMineralMixture,3)
                .inputFluids(HoaglandAZTraceElementConcentrate.getFluid(FluidHelper.getBucket()/1000))
                .inputFluids(DistilledWater.getFluid(FluidHelper.getBucket()))
                .outputFluids(NutrientMedium.getFluid(FluidHelper.getBucket()))
                .duration(60).EUt(VA[MV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("immature_ergot_culture")
                .cleanroom(STERILE_CLEANROOM)
                .inputItems(GTItems.PETRI_DISH.asStack())
                .inputItems(ERGOT_FUNGAL_SAMPLE.asStack())
                .inputFluids(NutrientMedium.getFluid(FluidHelper.getBucket()/10))
                .outputItems(IMMATURE_ERGOT_CULTURE.asStack())
                .duration(72000).EUt(VA[ULV]).save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("potassium_bitartrate")
                .inputFluids(Lees.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,PotassiumBitartrate)
                .duration(60).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("calcium_hydroxide")
                .inputItems(dust,Quicklime)
                .inputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,CalciumHydroxide)
                .duration(60).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("calcium_hydroxide_steam")
                .inputItems(dust,CalciumHydroxide)
                .outputFluids(Steam.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,Quicklime)
                .duration(60).EUt(VA[MV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("calcium_tartrate")
                .inputItems(dust,PotassiumBitartrate)
                .inputItems(dust,CalciumHydroxide)
                .outputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,PotassiumHydroxide)
                .outputItems(dust,CalciumTartrate)
                .duration(120).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("tartaric_acid")
                .inputItems(dust,CalciumTartrate)
                .inputFluids(SulfuricAcid.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,CalciumSulfate)
                .outputFluids(TartaricAcid.getFluid(FluidHelper.getBucket()))
                .circuitMeta(1)
                .duration(120).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("tartaric_acid_calcium_chloride")
                .inputItems(dust,CalciumTartrate)
                .inputItems(dustTiny,CalciumChloride)
                .inputFluids(SulfuricAcid.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,CalciumSulfate)
                .outputFluids(TartaricAcid.getFluid(2*FluidHelper.getBucket()))
                .circuitMeta(2)
                .duration(120).EUt(VA[HV]).save(provider);

        COMPRESSOR_RECIPES.recipeBuilder("blotter_sheet")
                .inputItems(Items.PAPER,3)
                .outputItems(BLOTTER_SHEET)
                .duration(120).EUt(VA[LV]).save(provider);

        CUTTER_RECIPES.recipeBuilder("blotter")
                .inputItems(BLOTTER_SHEET)
                .outputItems(BLOTTER,16)
                .duration(360).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("mature_ergot_culture")
                .cleanroom(STERILE_CLEANROOM)
                .inputItems(IMMATURE_ERGOT_CULTURE.asStack())
                .inputFluids(Ethanol.getFluid(FluidHelper.getBucket()/10))
                .inputFluids(Air.getFluid(10*FluidHelper.getBucket()))
                .outputItems(MATURE_ERGOT_CULTURE.asStack())
                .duration(48000).EUt(VA[ULV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("neutralized_ergot_culture")
                .inputItems(MATURE_ERGOT_CULTURE.asStack())
                .inputFluids(TartaricAcid.getFluid(FluidHelper.getBucket()))
                .outputItems(NEUTRALIZED_ERGOT_CULTURE.asStack())
                .duration(720).EUt(VA[LV]).save(provider);

        EXTRACTOR_RECIPES.recipeBuilder("ergot_alkaloids_tartrate_salt_solution")
                .inputItems(NEUTRALIZED_ERGOT_CULTURE.asStack())
                .outputFluids(ErgotAlkaloidTartrateSaltSolution.getFluid(10*FluidHelper.getBucket()))
                .outputItems(GTItems.PETRI_DISH.asStack())
                .duration(180).EUt(VA[LV]).save(provider);

        DISTILLERY_RECIPES.recipeBuilder("ergot_alkaloids_tartrate_salt_mixture")
                .inputFluids(ErgotAlkaloidTartrateSaltSolution.getFluid(FluidHelper.getBucket()))
                .outputItems(dust,ErgotAlkaloidTartrateSaltMixture)
                .outputFluids(Biomass.getFluid(FluidHelper.getBucket()/20))
                .duration(360).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("ergot_alkaloid_amide_solution")
                .inputItems(dust,ErgotAlkaloidTartrateSaltMixture)
                .inputItems(dust,PotassiumHydroxide)
                .inputFluids(Methanol.getFluid(FluidHelper.getBucket()))
                .inputFluids(Water.getFluid(FluidHelper.getBucket()))
                .chancedInput(Nitrogen.getFluid(FluidHelper.getBucket()/2),0,0)
                .inputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputFluids(ErgotAlkaloidAmideSolution.getFluid(FluidHelper.getBucket()))
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("d_lysergic_acid_solution_from_ergot")
                .inputFluids(ErgotAlkaloidAmideSolution.getFluid(FluidHelper.getBucket()))
                .inputFluids(TartaricAcid.getFluid(FluidHelper.getBucket()))
                .outputFluids(DLysergicAcidSolution.getFluid(FluidHelper.getBucket()))
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("d_lysergic_acid_solution_from_lysergamides")
                .inputItems(dust,LysergicAcidAmideMixture,3)
                .inputFluids(TartaricAcid.getFluid(FluidHelper.getBucket()))
                .outputFluids(DLysergicAcidSolution.getFluid(FluidHelper.getBucket()))
                .duration(180).EUt(VA[LV]).save(provider);

        DISTILLERY_RECIPES.recipeBuilder("d_lysergic_acid")
                .inputFluids(DLysergicAcidSolution.getFluid(FluidHelper.getBucket()))
                .outputFluids(TartaricAcid.getFluid(FluidHelper.getBucket()/2))
                .outputFluids(ErgotAlkaloidAmideSolution.getFluid(FluidHelper.getBucket()/20))
                .outputItems(dust,DLysergicAcid)
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("acetonitrile")
                .inputFluids(AceticAcid.getFluid(FluidHelper.getBucket()))
                .inputFluids(Ammonia.getFluid(FluidHelper.getBucket()))
                .outputFluids(Acetonitrile.getFluid(FluidHelper.getBucket()))
                .outputFluids(Water.getFluid(FluidHelper.getBucket()*2))
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("acetic_anhydride")
                .inputFluids(CarbonMonoxide.getFluid(FluidHelper.getBucket()))
                .inputFluids(MethylAcetate.getFluid(FluidHelper.getBucket()))
                .outputFluids(AceticAnhydride.getFluid(FluidHelper.getBucket()))
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("acetyl_fluoride")
                .inputFluids(AceticAnhydride.getFluid(FluidHelper.getBucket()))
                .inputFluids(HydrofluoricAcid.getFluid(FluidHelper.getBucket()*8))
                .outputFluids(TrifluoroacetylFluoride.getFluid(FluidHelper.getBucket()*2))
                .outputFluids(Hydrogen.getFluid(FluidHelper.getBucket()*4))
                .outputFluids(Water.getFluid(FluidHelper.getBucket()))
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("trifluoroaceetic_acid")
                .inputFluids(Water.getFluid(FluidHelper.getBucket()))
                .inputFluids(TrifluoroacetylFluoride.getFluid(FluidHelper.getBucket()))
                .outputFluids(TrifluoroaceticAcid.getFluid(FluidHelper.getBucket()))
                .outputFluids(HydrofluoricAcid.getFluid(FluidHelper.getBucket()))
                .duration(180).EUt(VA[LV]).save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("trifluoroaceetic_acid_lcr")
                .inputFluids(AceticAnhydride.getFluid(FluidHelper.getBucket()))
                .inputFluids(HydrofluoricAcid.getFluid(FluidHelper.getBucket()*6))
                .outputFluids(TrifluoroaceticAcid.getFluid(FluidHelper.getBucket()*2))
                .outputFluids(Hydrogen.getFluid(FluidHelper.getBucket()*4))
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("diethylamine")
                .inputFluids(Ethanol.getFluid(FluidHelper.getBucket()))
                .inputFluids(Ammonia.getFluid(FluidHelper.getBucket()))
                .notConsumable(dust,Sapphire)
                .outputFluids(Diethylamine.getFluid(FluidHelper.getBucket()))
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("diethylamine_green")
                .inputFluids(Ethanol.getFluid(FluidHelper.getBucket()))
                .inputFluids(Ammonia.getFluid(FluidHelper.getBucket()))
                .notConsumable(dust,GreenSapphire)
                .outputFluids(Diethylamine.getFluid(FluidHelper.getBucket()))
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("lysergic_acid_diethylamide_residue")
                .inputFluids(Diethylamine.getFluid(FluidHelper.getBucket()))
                .inputFluids(TrifluoroaceticAcid.getFluid(FluidHelper.getBucket()))
                .inputFluids(Acetonitrile.getFluid((long) (FluidHelper.getBucket()*1.8f)))
                .inputItems(dust,DLysergicAcid)

                .outputFluids(LysergicAcidDiethylamideResidue.getFluid(FluidHelper.getBucket()))
                .duration(180).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("lysergic_acid_diethylamide")
                .inputFluids(LysergicAcidDiethylamideResidue.getFluid(FluidHelper.getBucket()))
                .chancedInput(Chloroform.getFluid((long) (FluidHelper.getBucket()*1.2)),2000,500)
                .inputFluids(Ice.getFluid((long) (FluidHelper.getBucket()*0.16f)))
                .outputItems(dust,LysergicAcidDiethylamide)
                .duration(180).EUt(VA[LV]).save(provider);

        MIXER_RECIPES.recipeBuilder("lysergic_acid_diethylamide_solution")
                .inputFluids(Water.getFluid(FluidHelper.getBucket()/2))
                .inputFluids(Ethanol.getFluid(FluidHelper.getBucket()/2))
                .inputItems(dustTiny,LysergicAcidDiethylamide)
                .outputFluids(LysergicAcidDiethylamideSolution.getFluid(FluidHelper.getBucket()))
                .duration(60).EUt(VA[LV]).save(provider);


        CHEMICAL_BATH_RECIPES.recipeBuilder("acid_blotter")
                .inputFluids(LysergicAcidDiethylamideSolution.getFluid(FluidHelper.getBucket()/20))
                .inputItems(BLOTTER.asStack())
                .outputItems(ACID_BLOTTER.asStack())
                .duration(60).EUt(VA[LV]).save(provider);

        SIFTER_RECIPES.recipeBuilder("sift_flour")
                .inputItems(dust, Wheat)
                .chancedOutput(ERGOT_FUNGAL_SAMPLE.asStack(),300,300)
                .duration(98).EUt(VA[LV])
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("infused_sugar_cube")
                .inputFluids(LysergicAcidDiethylamideSolution.getFluid(FluidHelper.getBucket()/20))
                .inputItems(gem, Sugar)
                .outputItems(INFUSED_SUGAR_CUBE.asStack())
                .duration(60).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("ammonium_hydroxide")
                .inputFluids(Ammonia.getFluid(FluidHelper.getBucket()))
                .inputFluids(Water.getFluid(FluidHelper.getBucket()))
                .outputFluids(AmmoniumHydroxide.getFluid(FluidHelper.getBucket()))
                .duration(60).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("morning_glory_seed_slurry")
                .inputFluids(Naphtha.getFluid(FluidHelper.getBucket()))
                .inputItems(MORNING_GLORY_SEEDS.asStack(4))
                .outputFluids(MorningGlorySeedSlurry.getFluid(FluidHelper.getBucket()))
                .outputFluids(SeedOil.getFluid(FluidHelper.getBucket()*2))
                .duration(60).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("alkaloid_slurry")
                .inputFluids(MorningGlorySeedSlurry.getFluid(FluidHelper.getBucket()))
                .inputFluids(AmmoniumHydroxide.getFluid(FluidHelper.getBucket()/2))
                .chancedInput(Chloroform.getFluid((long) (FluidHelper.getBucket()*1.2)),4000,500)
                .outputItems(dust, AlkaloidResidue)
                .duration(60).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("lysergic_acid_amide_mixture")
                .inputItems(dust, AlkaloidResidue)
                .inputFluids(TartaricAcid.getFluid(FluidHelper.getBucket()/2))
                .chancedInput(Chloroform.getFluid((long) (FluidHelper.getBucket()*1.2)),2500,500)
                .outputItems(dust, LysergicAcidAmideMixture)
                .duration(60).EUt(VA[LV]).save(provider);
    }
}
