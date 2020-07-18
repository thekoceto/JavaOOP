package P03_WildFarm.animal;

import P03_WildFarm.food.Food;
import P03_WildFarm.food.Vegetable;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable)
            super.setFoodEaten(food.getQuantity());
        else
            System.out.println("Mice are not eating that type of food!");
    }
}
