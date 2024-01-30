package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixin;

import com.mojang.authlib.GameProfile;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinaccessors.Trippable;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public abstract class MixinLocalPlayer extends AbstractClientPlayer implements Trippable {

    private static final int TRIP_LIMIT = 12000;
    @Unique
    public int tripTimer = 0;
    @Unique
    public boolean activeTrip = false;

    public MixinLocalPlayer(ClientLevel clientLevel, GameProfile gameProfile) {
        super(clientLevel, gameProfile);
    }


    @Inject(method = "tick", at = @At("RETURN"))
    public void tripTick(CallbackInfo ci){
        if(activeTrip && ++tripTimer >= TRIP_LIMIT){
            activeTrip = false;
            tripTimer = 0;
        }
    }

    @Override
    public boolean getIsTripActive() {
        return activeTrip;
    }

    @Override
    public void setIsTripActive(boolean isTripActive) {
        activeTrip = isTripActive;
    }


    @Override
    public int getTripTimer() {
        return tripTimer;
    }
}
