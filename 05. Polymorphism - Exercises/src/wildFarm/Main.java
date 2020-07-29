package wildFarm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] animalInfo = input.split("\\s+");
            String type = animalInfo[0];
            String name = animalInfo[1];
            double weight = Double.parseDouble(animalInfo[2]);
            String region = animalInfo[3];

            Animal animal = null;
            switch (type) {
                case "Tiger":
                    animal = new Tiger(type, name, weight, region);
                    break;
                case "Zebra":
                    animal = new Zebra(type, name, weight, region);
                    break;
                case "Mouse":
                    animal = new Mouse(type, name, weight, region);
                    break;
                case "Cat":
                    String breed = animalInfo[4];
                    animal = new Cat(type, name, weight, region, breed);
                    break;
            }

            animal.makeSound();

            input = scanner.nextLine();

            String[] foodInfo = input.split("\\s+");
            String foodName = foodInfo[0];
            int foodWeight = Integer.parseInt(foodInfo[1]);

            Food food = null;
            if (foodName.equals("Vegetable")) {
                 food = new Vegetable(foodWeight);
            } else {
                 food = new Meat(foodWeight);
            }
            animal.eat(food);

            animals.add(animal);

            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}


