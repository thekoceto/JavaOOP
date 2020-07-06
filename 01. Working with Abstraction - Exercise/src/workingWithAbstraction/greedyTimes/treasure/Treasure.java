/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package workingWithAbstraction.greedyTimes.treasure;

public class Treasure {
    long price;

    public Treasure(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void incrementPriceBy(Long price) {
        this.price += price;
    }
}
