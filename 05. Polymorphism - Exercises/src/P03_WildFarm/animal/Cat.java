package P03_WildFarm.animal;

import P03_WildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.getQuantity() + getFoodEaten());
    }

    @Override
    public String toString() {
        return this.getAnimalName() +
                "[" + super.getAnimalType() +
                ", "  + this.breed +
                ", "  + new DecimalFormat("#.##").format(this.getAnimalWeight()) +
                ", "  + this.getLivingRegion() +
                ", "  + this.getFoodEaten() + "]";
    }
}
