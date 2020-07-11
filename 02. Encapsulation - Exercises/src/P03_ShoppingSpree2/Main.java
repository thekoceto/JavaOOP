package P03_ShoppingSpree2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");

        Map<String, Person> peopleByName = new HashMap<>();
        Map<String, Product> productByName = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            String[] people = input[i].split("=");
            String name = people[0];
            double money = Double.parseDouble(people[1]);

            Person person = new Person(name, money);
            peopleByName.putIfAbsent(name, person);
        }
        input = scanner.nextLine().split(";");

        for (int i = 0; i < input.length; i++) {
            String[] products = input[i].split("=");
            String name = products[0];
            double cost = Double.parseDouble(products[1]);
            Product product = new Product(name, cost);
            productByName.putIfAbsent(name, product);
        }
        String line;

        while (!"END".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            try {
                peopleByName.get(personName).buyProduct(productByName.get(productName));
                System.out.printf("%s bought %s%n", personName, productName);

            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        for (Person value : peopleByName.values()) {
            System.out.println(value.toString());
        }
    }
}