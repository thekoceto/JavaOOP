package P01_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    protected void refuel (double fuel){
        this.fuelQuantity += fuel;
    }

    protected void drive (double km){
        if (this.fuelQuantity >= km * this.fuelConsumption) {
            this.fuelQuantity -= km * this.fuelConsumption;
            System.out.println(String.format("%s travelled %s km",this.getClass().getSimpleName(), new DecimalFormat("###.##").format(km)));
        } else {
            System.out.println(this.getClass().getSimpleName() + " needs refueling");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(), this.fuelQuantity) ;
    }
}
