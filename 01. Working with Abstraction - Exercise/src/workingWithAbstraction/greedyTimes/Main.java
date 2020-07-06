package workingWithAbstraction.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < input.length; i += 2) {
            String name = input[i];
            long value = Long.parseLong(input[i + 1]);

            if (capacity < bag.getTotalTreasurePrice() + value)
                continue;

            if (name.length() == 3) {
                bag.addCash(name, value);
            } else if (name.toLowerCase().endsWith("gem")) {
                bag.addGems(name, value);
            } else if (name.toLowerCase().equals("gold")) {
                bag.addGold(value);
            }

        }

        System.out.println(bag.toString());

    }
}