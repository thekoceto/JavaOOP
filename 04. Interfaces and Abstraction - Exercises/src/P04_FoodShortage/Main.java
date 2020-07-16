package P04_FoodShortage;

import P04_FoodShortage.interfaces.Buyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Buyer> buyers = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] token = reader.readLine().split(" ");
            if (token.length == 4)
                buyers.putIfAbsent(token[0], new Citizen(token[0], Integer.parseInt(token[1]), token[2], token[3]));
            else if (token.length == 3)
                buyers.putIfAbsent(token[0], new Rebel(token[0], Integer.parseInt(token[1]), token[2]));
        }

        String input;
        while (!"End".equals(input = reader.readLine())) {
            if (buyers.containsKey(input))
                buyers.get(input).buyFood();
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}