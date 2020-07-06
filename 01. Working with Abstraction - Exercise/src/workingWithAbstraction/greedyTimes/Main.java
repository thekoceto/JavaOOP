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
            long amount = Long.parseLong(input[i + 1]);

            if (capacity < bag.getTotalTreasurePrice() + amount)
                continue;

            if (name.length() == 3) {
                bag.addCash(name, amount);
            } else if (name.toLowerCase().endsWith("gem")) {
                bag.addGems(name, amount);
            } else if (name.toLowerCase().equals("gold")) {
                bag.addGold(name, amount);
            }

        }
        System.out.println(bag.report());
    }
}