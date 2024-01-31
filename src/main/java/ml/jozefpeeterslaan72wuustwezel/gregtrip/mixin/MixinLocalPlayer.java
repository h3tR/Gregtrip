package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixin;

import com.mojang.authlib.GameProfile;
import ml.jozefpeeterslaan72wuustwezel.gregtrip.mixininterfaces.Trippable;
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

    @Unique
    private static final int TRIP_LIMIT = 12000; //setTripLimit??
    @Unique
    public int gTrip$tripTimer = 0;
    @Unique
    public boolean gTrip$activeTrip = false;

    public MixinLocalPlayer(ClientLevel clientLevel, GameProfile gameProfile) {
        super(clientLevel, gameProfile);
    }


    @Inject(method = "tick", at = @At("RETURN"))
    public void tripTick(CallbackInfo ci){
        if(gTrip$activeTrip && ++gTrip$tripTimer >= TRIP_LIMIT){
            gTrip$activeTrip = false;
            gTrip$tripTimer = 0;
        }
    }

    @Override
    public boolean gTrip$getIsTripActive() {
        return gTrip$activeTrip;
    }

    @Override
    public void gTrip$setIsTripActive(boolean isTripActive) {
        gTrip$activeTrip = isTripActive;
    }


    @Override
    public int gTrip$getTripTimer() {
        return gTrip$tripTimer;
    }
}
