package P06_Animals;

import P06_Animals.animals.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        List<Animal> animals = new ArrayList<>();

        while (!"Beast!".equals(input = reader.readLine())) {
            String[] token = reader.readLine().split("\\s+");

            switch (input) {
                case "Dog":
                    animals.add(new Dog(token[0], Integer.parseInt(token[1]), token[2]));
                    break;
                case "Cat":
                    animals.add(new Cat(token[0], Integer.parseInt(token[1]), token[2]));
                    break;
                case "Frog":
                    animals.add(new Frog(token[0], Integer.parseInt(token[1]), token[2]));
                    break;
                case "Kitten":
                    animals.add(new Kitten(token[0], Integer.parseInt(token[1])));
                    break;
                case "Tomcat":
                    animals.add(new Tomcat(token[0], Integer.parseInt(token[1])));
                    break;
            }
        }
        StringBuilder report = new StringBuilder();
        animals.forEach(animal -> report.append(animal.toString()).append(System.lineSeparator()));
        System.out.println(report.toString().trim());

    }
}