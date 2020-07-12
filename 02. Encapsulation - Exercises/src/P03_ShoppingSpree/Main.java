package P03_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Person> persons = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();

        String input = reader.readLine();
        String[] line = input.split(";");
        for (String token : line) {
            String[] splitted = token.split("=");
            persons.putIfAbsent(splitted[0], new Person(splitted[0], Double.parseDouble(splitted[1])));
        }

        line = reader.readLine().split(";");
        for (String token : line) {
            String[] splitted = token.split("=");
            products.putIfAbsent(splitted[0], new Product(splitted[0], Double.parseDouble(splitted[1])));
        }

        while (!"END".equals(input = reader.readLine())){
            String[] splitted = input.split(" ");
            String personName = splitted[0];
            String productName = splitted[1];
            try {
                persons.get(personName).buyProduct(products.get(productName));
                System.out.println(personName + " bought " + productName);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        StringBuilder report = new StringBuilder();
        persons.forEach((key, value) -> report.append(value.toString()).append(System.lineSeparator()));
        System.out.println(report.toString());
    }
}