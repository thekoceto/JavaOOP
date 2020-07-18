package P03_WildFarm.animal;

import P03_WildFarm.food.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private final String animalName;
    private final String animalType;
    private final Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
        this.makeSound();
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);

}