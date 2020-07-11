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
            String name = token[0];
            int age = Integer.parseInt(token[1]);
            String gender = token[2];

            switch (input) {
                case "Dog":
                    animals.add(new Dog(name, age, gender));
                    break;
                case "Cat":
                    animals.add(new Cat(name, age, gender));
                    break;
                case "Frog":
                    animals.add(new Frog(name, age, gender));
                    break;
                case "Kitten":
                    animals.add(new Kitten(name, age));
                    break;
                case "Tomcat":
                    animals.add(new Tomcat(name, age));
                    break;
            }
        }
        StringBuilder report = new StringBuilder();
        animals.forEach(animal -> report.append(animal.toString()).append(System.lineSeparator()));
        System.out.println(report.toString().trim());

    }
}