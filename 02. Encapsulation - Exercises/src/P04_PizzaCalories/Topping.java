package P04_PizzaCalories;

import java.util.HashMap;

public class Topping {
    private String toppingType;
    private double weight;
    //-	toppingType: String
    //-	weight: double

    private final HashMap<String, Double> toppingTypes = new HashMap<>(){{
        put("Meat", 1.2);   put("Veggies", 0.8);
        put("Cheese", 1.1); put("Sauce", 0.9);
    }};

    //+ Topping (String, double)
    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    //-	setToppingType (String): void
    private void setToppingType(String toppingType) {
        if (!toppingTypes.containsKey(toppingType))
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");

        this.toppingType = toppingType;
    }

    //-	setWeight (double): void
    private void setWeight(double weight) {
        if (weight < 1 || weight > 50)
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");

        this.weight = weight;
    }

    //+	calculateCalories (): double
    public double calculateCalories(){
        return 2 * this.weight * toppingTypes.get(this.toppingType);
    }

}