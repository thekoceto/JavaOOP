/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package workingWithAbstraction.greedyTimes.treasure;

public class Gem extends Treasure{
    private String name;

    public Gem(String name, long price) {
        super(price);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "##" + this.name + " - " + this.price;
    }
}
