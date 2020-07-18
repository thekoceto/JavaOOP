package P01_Vehicles;

public class Car extends Vehicles {
    private static final double ADDITIONAL_CONSUMPTION = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION);
    }

}