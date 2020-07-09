package P04_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        Pizza pizza = new Pizza(input[1], Integer.parseInt(input[2]));

        input = reader.readLine().split("\\s+");

        Dough dough = new Dough(input[1], input[2], Double.parseDouble(input[3]));

        pizza.setDough(dough);

        while (!"END".equals(input[0] = reader.readLine())){

            String[] tokens = input[0].split("\\s+");

            Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
            pizza.addTopping(topping);
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

    }
}
