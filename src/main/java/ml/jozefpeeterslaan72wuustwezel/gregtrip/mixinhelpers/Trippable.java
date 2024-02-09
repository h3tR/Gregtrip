package ml.jozefpeeterslaan72wuustwezel.gregtrip.mixinhelpers;

public interface Trippable {
    int gTrip$getTripTimer();
    boolean gTrip$getIsTripActive();

    void gTrip$setIsTripActive(boolean isTripActive);

}
