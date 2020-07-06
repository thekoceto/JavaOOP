/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package P05_JediGalaxy.galaxy;

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
