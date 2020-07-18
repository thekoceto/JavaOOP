package P02_VehiclesExtension;

public class Car extends Vehicles {
    private static final double ADDITIONAL_CONSUMPTION = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION, tankCapacity);
    }

}