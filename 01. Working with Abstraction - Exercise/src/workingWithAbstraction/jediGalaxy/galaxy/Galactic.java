/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package workingWithAbstraction.jediGalaxy.galaxy;

public class Galactic {
    private int row;
    private int col;
    private int[][] matrix;

    public Galactic(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrix = new int[row][col];
        this.fillMatrix();
    }

    private void fillMatrix() {
        int value = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setStarsToZero(int row, int col) {
        matrix[row][col]=0;
    }

    public int getStar(int row, int col) {
        return matrix[row][col];
    }
}
