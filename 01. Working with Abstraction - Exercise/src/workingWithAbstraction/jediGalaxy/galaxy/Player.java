/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package workingWithAbstraction.jediGalaxy.galaxy;

public class Player {
    private long score;

    public Player() {
        this.score = 0;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    public long getScore() {
        return score;
    }
}
