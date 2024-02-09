package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinhelpers;

import net.minecraft.client.Minecraft;

public class LSDModifierHelper {

    public static float getPlayerSpeedModifier(){
        float playerSpeed = Math.max(Math.min(Minecraft.getInstance().player.getDeltaMovement().toVector3f().length(),.17f),0.05f);
        if(playerSpeed==0)
            return 1;
        return 1-.181f/(playerSpeed+.001f);
    }
}
