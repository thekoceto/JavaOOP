package P02_VehiclesExtension;

public class Truck extends Vehicles {
    private static final double ADDITIONAL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double fuel){
        super.refuel(fuel*0.95);
    }
}