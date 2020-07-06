package workingWithAbstraction.greedyTimes;

import workingWithAbstraction.greedyTimes.treasure.Cash;
import workingWithAbstraction.greedyTimes.treasure.Gem;
import workingWithAbstraction.greedyTimes.treasure.Gold;

import java.util.HashMap;

public class Bag {
    private Gold gold;
    private HashMap<String, Gem> gems;
    private HashMap<String, Cash> cash;
    private long capacity;

    public Bag(long capacity) {
        this.gold = new Gold(0);
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
        this.capacity = capacity;
    }

    public long getTotalTreasurePrice(){
        return  this.getTotalCash() +
                this.getTotalGems() +
                this.getTotalGold();
    }
    public long getTotalCash (){
        return cash.values()
                .stream()
                .mapToLong(Cash::getPrice)
                .sum();
    }

    public long getTotalGems (){
        return gems.values()
                .stream()
                .mapToLong(Gem::getPrice)
                .sum();
    }

    public long getTotalGold(){
        return gold.getPrice();
    }

    public void addGold(long value) {
        this.gold.incrementPriceBy(value);
    }

    //•	The gold amount in your bag should always be more than or equal to the gem amount at any time
    public void addGems (String name, long value){
        if (getTotalGems() < getTotalCash() || this.getTotalGold() >= this.getTotalGems() + value) {
            gems.putIfAbsent(name, new Gem(name, 0));
            gems.get(name).incrementPriceBy(value);
        }
    }

    //•	The gem amount should always be more than or equal to the cash amount at any time
    public void addCash (String name, long value){
        if(this.getTotalGems() >= this.getTotalCash() + value) {
            cash.putIfAbsent(name, new Cash(name, 0));
            cash.get(name).incrementPriceBy(value);
        }
    }

    private HashMap<String, Long> getMapWithTotalValue(){
        return new HashMap<>(){{
            put("gold", getTotalGold());
            put("gems", getTotalGems());
            put("cash", getTotalCash());
        }};
    }


    @Override
    public String toString() {

        StringBuilder out = new StringBuilder();
        getMapWithTotalValue()
                .entrySet()
                .stream()
                .sorted((treasure1, treasure2) -> treasure2.getValue().compareTo(treasure1.getValue()))
                .forEach(treasure -> {
                    switch (treasure.getKey()) {
                        case "gold":
                            out.append("<Gold> $").append(getTotalGold());
                            out.append(System.lineSeparator());
                            out.append(gold.toString());
                            out.append(System.lineSeparator());
                            break;
                        case "gems":
                            if (!gems.isEmpty()) {
                                out.append("<Gem> $").append(getTotalGems());
                                out.append(System.lineSeparator());
                                gems.entrySet()
                                        .stream()
                                        .sorted((s1, s2) -> s2.getKey().compareTo(s1.getKey()))
                                        .forEach(s -> out.append(s.getValue().toString()).append(System.lineSeparator()));
                            }
                            break;
                        case "cash":
                            if (!cash.isEmpty()) {
                                out.append("<Cash> $").append(getTotalCash());
                                out.append(System.lineSeparator());
                                cash.entrySet()
                                        .stream()
                                        .sorted((s1, s2) -> s2.getKey().compareTo(s1.getKey()))
                                        .forEach(s -> out.append(s.getValue().toString()).append(System.lineSeparator()));
                            }
                            break;
                    }
                });

        return out.toString().trim();
    }
}
