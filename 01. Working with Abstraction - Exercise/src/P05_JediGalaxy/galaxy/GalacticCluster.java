/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package P05_JediGalaxy.galaxy;

public class GalacticCluster {
    private Galactic galactic;

    public GalacticCluster(Galactic galactic) {
        this.galactic = galactic;
    }

    public void moveEvil(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (row < galactic.getRow() && col < galactic.getCol()){
                galactic.setStarsToZero(row, col);
            }
            row--;
            col--;

        }
    }

    public int movePlayer(int row, int col) {
        int sum = 0;
        while (row >= 0 && col < galactic.getCol()) {
            if (row < galactic.getRow() && col >= 0) {
                sum += galactic.getStar(row, col);
            }
            row--;
            col++;
        }
        return sum;
    }
}
