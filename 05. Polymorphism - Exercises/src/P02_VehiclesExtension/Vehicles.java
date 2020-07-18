package P02_VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private static final double ADDITIONAL_BUS_CONSUMPTION = 1.4;

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicles(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0)
            System.out.println("Fuel must be a positive number");
        else
            this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void refuel(double fuel) {
        if (fuel <= 0)
            System.out.println("Fuel must be a positive number");
        else if (this.fuelQuantity + fuel > this.tankCapacity)
            System.out.println("Cannot fit fuel in tank");
        else
            this.fuelQuantity += fuel;
    }

    protected void drive(double km) {
        if (this.fuelQuantity >= km * this.fuelConsumption) {
            this.fuelQuantity -= km * this.fuelConsumption;
            System.out.println(String.format("%s travelled %s km", this.getClass().getSimpleName(), new DecimalFormat("###.##").format(km)));
        } else {
            System.out.println(this.getClass().getSimpleName() + " needs refueling");
        }
    }

    public void driveEmpty(double km) {

        if(this.fuelQuantity >=km * this.fuelConsumption - ADDITIONAL_BUS_CONSUMPTION) {
            this.fuelQuantity -= km * this.fuelConsumption - ADDITIONAL_BUS_CONSUMPTION;
            System.out.println(String.format("%s travelled %s km", this.getClass().getSimpleName(), new DecimalFormat("###.##").format(km)));
        } else {
            System.out.println(this.getClass().getSimpleName() + " needs refueling");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(), this.fuelQuantity) ;
    }

}
