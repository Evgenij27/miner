package main;

import static main.Utils.*;

public class RecursionSolution {

    private final int rows;
    private final int cols;
    private final int[][] mine;

    public RecursionSolution(int[][] mine) {
       this.mine = mine;
       this.rows = getRows(mine);
       this.cols = getCols(mine);
    }

    public int findResult(int row) {
        return doMine(row, 0);
    }

    private int doMine(int row, int col) {
        if (col == cols) {
            return 0;
        }

        int up;
        int right;
        int down;

        if (row == 0) {
            right = mineRight(row, col);
            down = mineDown(row, col);
            return Math.max(right, down);
        }

        if (row == rows - 1) {
            up = mineUp(row, col);
            right = mineRight(row, col);
            return Math.max(up, right);
        }

        up = mineUp(row, col);
        right = mineRight(row, col);
        down = mineDown(row, col);

        return max(up, right, down);
    }

    private int mineUp(int row, int col) {
        return doMine(row - 1, col + 1) + mine[row][col];
    }

    private int mineDown(int row, int col) {
        return doMine(row + 1, col + 1) + mine[row][col];
    }

    private int mineRight(int row, int col) {
        return doMine(row, col + 1) + mine[row][col];
    }
}
