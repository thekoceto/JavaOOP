package P03_WildFarm.animal;

import P03_WildFarm.food.Food;
import P03_WildFarm.food.Meat;

import java.text.DecimalFormat;

public class Tiger extends Felime{

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat)
            super.setFoodEaten(food.getQuantity());
        else
            System.out.println(this.getClass().getSimpleName() + "s are not eating that type of food!");
    }

}
