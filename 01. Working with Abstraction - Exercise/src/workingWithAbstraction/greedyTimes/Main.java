package workingWithAbstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long vhod = Long.parseLong(scanner.nextLine());
        String[] seif = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < seif.length; i += 2) {
            String name = seif[i];
            long broika = Long.parseLong(seif[i + 1]);

            String kvoE = "";

            if (name.length() == 3) {
                kvoE = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                kvoE = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                kvoE = "Gold";
            }

            if (kvoE.equals("")) {
                continue;
            } else if (vhod < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + broika) {
                continue;
            }

            switch (kvoE) {
                case "Gem":
                    if (!bag.containsKey(kvoE)) {
                        if (bag.containsKey("Gold")) {
                            if (broika > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(kvoE).values().stream().mapToLong(e -> e).sum() + broika > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(kvoE)) {
                        if (bag.containsKey("Gem")) {
                            if (broika > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(kvoE).values().stream().mapToLong(e -> e).sum() + broika > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(kvoE)) {
                bag.put((kvoE), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(kvoE).containsKey(name)) {
                bag.get(kvoE).put(name, 0L);
            }


            bag.get(kvoE).put(name, bag.get(kvoE).get(name) + broika);
            if (kvoE.equals("Gold")) {
                gold += broika;
            } else if (kvoE.equals("Gem")) {
                gems += broika;
            } else if (kvoE.equals("Cash")) {
                cash += broika;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}