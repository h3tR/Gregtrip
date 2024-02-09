package ml.jozefpeeterslaan72wuustwezel.gregtrip.common.item;

import ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinhelpers.Trippable;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AcidConsumableItem extends Item {
    public AcidConsumableItem(Properties properties) {
        super(properties);
    }


    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        if(entity.level().isClientSide&&entity.equals(Minecraft.getInstance().player)){
           Trippable trippable = (Trippable)Minecraft.getInstance().player;
           if(!trippable.gTrip$getIsTripActive()) {
               trippable.gTrip$setIsTripActive(true);
           }
        }
    }
}
