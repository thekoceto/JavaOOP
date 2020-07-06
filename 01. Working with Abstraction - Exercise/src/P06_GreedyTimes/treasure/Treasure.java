/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package P06_GreedyTimes.treasure;

public class Treasure {
    long price;

    public Treasure(long price) {
        this.price = price;
    }

    public long getPrice() {
        return this.price;
    }

    public void increasePriceBy(Long price) {
        this.price += price;
    }
}