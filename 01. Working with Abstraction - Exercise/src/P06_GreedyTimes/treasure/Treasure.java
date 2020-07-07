package P06_GreedyTimes.treasure;

public class Treasure {
    private final String name;
    private long price;

    public Treasure(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public long getPrice() {
        return this.price;
    }

    public void increasePriceBy(Long price) {
        this.price += price;
    }

    @Override
    public String toString() {
        return "##" + this.name + " - " + this.price;
    }
}
