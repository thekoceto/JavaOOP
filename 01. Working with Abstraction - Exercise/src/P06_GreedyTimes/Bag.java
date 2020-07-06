package P06_GreedyTimes;

import P06_GreedyTimes.treasure.Cash;
import P06_GreedyTimes.treasure.Gem;
import P06_GreedyTimes.treasure.Gold;

import java.util.HashMap;

public class Bag {
    private final HashMap<String, Gold> gold;
    private final HashMap<String, Gem> gems;
    private final HashMap<String, Cash> cash;
    private final long capacity;

    public Bag(long capacity) {
        this.gold = new HashMap<>();
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
        this.capacity = capacity;
    }

    public long getTotalGoldPrice(){
        return gold.values()
                .stream()
                .mapToLong(Gold::getPrice)
                .sum();
    }

    public long getTotalGemsPrice (){
        return gems.values()
                .stream()
                .mapToLong(Gem::getPrice)
                .sum();
    }

    public long getTotalCashPrice(){
        return cash.values()
                .stream()
                .mapToLong(Cash::getPrice)
                .sum();
    }

    public long getTotalTreasurePrice(){
        return  this.getTotalCashPrice() +
                this.getTotalGemsPrice() +
                this.getTotalGoldPrice();
    }

    public void addGold(String name, long value) {
//        if (this.capacity < this.getTotalTreasurePrice() + value)
//            return;
        gold.putIfAbsent(name, new Gold(name, 0L));
        gold.get(name).increasePriceBy(value);
    }

    // The gold amount in your bag should always be more than or equal to the gem amount at any time
    public void addGems (String name, long value){
//        if (this.capacity < this.getTotalTreasurePrice() + value)
//            return;
        if (this.getTotalGoldPrice() >= this.getTotalGemsPrice() + value) {
            gems.putIfAbsent(name, new Gem(name, 0L));
            gems.get(name).increasePriceBy(value);
        }
    }

    // The gem amount should always be more than or equal to the cash amount at any time
    public void addCash (String name, long value){
//        if (this.capacity < this.getTotalTreasurePrice() + value)
//            return;
        if(this.getTotalGemsPrice() >= this.getTotalCashPrice() + value) {
            cash.putIfAbsent(name, new Cash(name, 0L));
            cash.get(name).increasePriceBy(value);
        }
    }

    private HashMap<String, Long> getMapWithTotalValue(){
        return new HashMap<>(){{
            put("Gold", getTotalGoldPrice());
            put("Gems", getTotalGemsPrice());
            put("Cash", getTotalCashPrice());
        }};
    }

    public String report() {

        StringBuilder out = new StringBuilder();

        getMapWithTotalValue()
                .entrySet()
                .stream()
                .sorted((treasure1, treasure2) -> treasure2.getValue().compareTo(treasure1.getValue()))
                .forEach(treasure -> {
                    switch (treasure.getKey()) {
                        case "Gold":
                            if (!gold.isEmpty()) {
                                out.append("<Gold> $").append(getTotalGoldPrice());
                                out.append(System.lineSeparator());
                                gold.entrySet()
                                        .stream()
                                        .sorted((s1, s2) -> s2.getKey().compareTo(s1.getKey()))
                                        .forEach(s -> out.append(s.getValue().toString()).append(System.lineSeparator()));
                            }
                            break;
                        case "Gems":
                            if (!gems.isEmpty()) {
                                out.append("<Gem> $").append(getTotalGemsPrice());
                                out.append(System.lineSeparator());
                                gems.entrySet()
                                        .stream()
                                        .sorted((s1, s2) -> s2.getKey().compareTo(s1.getKey()))
                                        .forEach(s -> out.append(s.getValue().toString()).append(System.lineSeparator()));
                            }
                            break;
                        case "Cash":
                            if (!cash.isEmpty()) {
                                out.append("<Cash> $").append(getTotalCashPrice());
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
