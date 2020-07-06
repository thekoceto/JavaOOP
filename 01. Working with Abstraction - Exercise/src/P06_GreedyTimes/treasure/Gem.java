/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package P06_GreedyTimes.treasure;

public class Gem extends Treasure{
    private String name;

    public Gem(String name, long price) {
        super(price);
        this.name = name;
    }

    @Override
    public String toString() {
        return "##" + this.name + " - " + this.price;
    }
}
