package wildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalType, String animalName,   Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat f = new DecimalFormat("#.##");
        return
                String.format("%s[%s, %s, region, %d]",
                        this.getAnimalType(),
                        this.animalName,
                        f.format(this.animalWeight),
                        this.foodEaten);
    }
}
