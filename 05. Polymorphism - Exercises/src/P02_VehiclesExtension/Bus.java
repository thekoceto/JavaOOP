package P02_VehiclesExtension;

public class Bus extends Vehicles{
    private static final double ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION, tankCapacity);
    }

    public double reducedConsumption() {
        return this.getFuelConsumption() - ADDITIONAL_CONSUMPTION;
    }

    @Override
    protected void drive(double km) {
        super.drive(km);
    }

}
