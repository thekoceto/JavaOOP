package P03_WildFarm.animal;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        return this.getAnimalName() +
                "[" + super.getAnimalType() +
                ", "  + new DecimalFormat("#.##").format(this.getAnimalWeight()) +
                ", "  + this.getLivingRegion() +
                ", "  + this.getFoodEaten() + "]";
    }

}
//{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]