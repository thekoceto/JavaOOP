package P03_WildFarm;

import P03_WildFarm.animal.*;
import P03_WildFarm.food.Meat;
import P03_WildFarm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new ArrayList<>();
        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] token = input.split("\\s+");
            String[] eat = reader.readLine().split("\\s+");
            Animal animal;
            switch (token[0]) {
                case "Cat":
                    animal = new Cat(token[0], token[1],
                            Double.parseDouble(token[2]),
                            token[3], token[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(token[0], token[1],
                            Double.parseDouble(token[2]), token[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(token[0], token[1],
                            Double.parseDouble(token[2]), token[3]);
                    break;
                case "Mouse":
                    animal = new Mouse(token[0], token[1],
                            Double.parseDouble(token[2]), token[3]);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + token[0]);
            }
            switch (eat[0]){
                case "Vegetable":
                    animal.eat(new Vegetable(Integer.parseInt(eat[1])));
                    break;
                case "Meat":
                    animal.eat(new Meat(Integer.parseInt(eat[1])));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + eat[0]);
            }
            animals.add(animal);
        }
        animals.forEach(animal -> System.out.println(animal.toString()));
    }
}
