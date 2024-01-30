package ml.jozefpeeterslaan72wuustwezel.gregtrip.common.item;

import ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinaccessors.Trippable;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AcidBlotterItem extends Item {
    public AcidBlotterItem(Properties properties) {
        super(properties);
    }


    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        if(entity.level().isClientSide&&entity.equals(Minecraft.getInstance().player)){
           Trippable trippable = (Trippable)Minecraft.getInstance().player;
           if(!trippable.getIsTripActive()) {
               trippable.setIsTripActive(true);
               stack.shrink(1);

           }
        }
    }
}
