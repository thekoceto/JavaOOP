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
            if (persons.containsKey(personName) && products.containsKey(productName) ) {
                persons.get(personName).buyProduct(products.get(productName));
            }
        }
        StringBuilder report = new StringBuilder();
        persons.forEach((key, value) -> report.append(value.toString()).append(System.lineSeparator()));
        System.out.println(report.toString());
    }
}
//Pesho bought Bread
//Gosho bought Milk
//Gosho bought Milk
//Pesho can't afford Milk
//Pesho - Bread
//Gosho - Milk, Milk
//Mimi can't afford Kafence
//Mimi – Nothing bought