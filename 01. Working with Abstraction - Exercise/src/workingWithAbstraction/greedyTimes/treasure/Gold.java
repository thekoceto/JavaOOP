/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package workingWithAbstraction.greedyTimes.treasure;

public class Gold extends Treasure{
    private String name;

    public Gold(String name, long price) {
        super(price);
        this.name = name;
    }

    @Override
    public String toString() {
        return "##" + this.name + " - " + this.price;
    }
}