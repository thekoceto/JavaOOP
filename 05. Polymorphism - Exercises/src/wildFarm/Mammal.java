package wildFarm;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType,
                     Double animalWeight,
                     String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }


    @Override
    public void eat(Food food) {
        boolean foodIsMeat =
                food.getClass().getSimpleName().equals("Meat");

        if (foodIsMeat && !(this instanceof Felime)) {
            String message =
                    (this.getAnimalType() +
                    "s are not eating that type of food!")
                            .replace("Mouses", "Mice");
            System.out.println(message);
//            throw new IllegalArgumentException(message);

        } else if (!foodIsMeat && this.getAnimalType().equals("Tiger")) {
            System.out.println("Tigers are not eating that type of food!");
//            throw new IllegalArgumentException
//                    ("Tigers are not eating that type of food!");
        }

        super.eat(food);
    }

    @Override
    public String toString() {
        return super.toString().replace("region", this.livingRegion);
    }

}
