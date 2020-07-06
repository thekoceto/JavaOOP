/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package workingWithAbstraction.greedyTimes.treasure;

public class Gold extends Treasure{

    public Gold(long price) {
        super(price);
    }

    @Override
    public String toString() {
        return "##Gold - " + this.price;
    }
}