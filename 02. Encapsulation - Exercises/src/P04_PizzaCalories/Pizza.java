package P04_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    //-	String name;
    //-	Dough dought;
    //-	List<Topping>toppings;

    //+ Piza (String, int numberOfToppings)
    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    //-	setName(String) : void
    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15)
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        this.name = name;
    }

    private Dough getDough() {
        return dough;
    }

    //+	setDough(Dough) : void
    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private List<Topping> getToppings() {
        return toppings;
    }

    //-	setToppings(int) : void
    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10)
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        this.toppings = new ArrayList<>();
    }

    //+	getName(): String
    public String getName() {
        return name;
    }

    //+	addTopping (Topping) : void
    public void addTopping (Topping topping) {
        if (this.getToppings().size() > 9)
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        this.getToppings().add(topping);
    }

    //+	getOverallCalories () : double
    public double getOverallCalories() {
        return this.getDough().calculateCalories() +
                this.getToppings()
                        .stream()
                        .mapToDouble(Topping::calculateCalories)
                        .sum();
    }
}
