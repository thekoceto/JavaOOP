/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package P06_GreedyTimes.treasure;

public class Cash extends Treasure{
    private String name;

    public Cash(String name, long price) {
        super(price);
        this.name = name;
    }

    @Override
    public String toString() {
        return "##" + this.name + " - " + this.price;
    }
}
