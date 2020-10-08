package main;

import static main.Utils.*;

public class IterationSolution {

    private final int rows;
    private final int cols;

    private final int[][] mine;

    public IterationSolution(int[][] mine) {
        this.mine = mine;
        this.rows = getRows(mine);
        this.cols = getCols(mine);
    }

    public int findResult(int startRow) {
        int row = startRow;
        int sum = mine[row][0];
        for (int col = 1; col < cols; col++) {

            int up;
            int right;
            int down;

            if (row == 0) {
                right = mine[row][col];
                down = mine[row + 1][col];
                if (down > right) {
                    row = row + 1;
                }
                sum += Math.max(right,down);
                continue;
            }

            if (row == rows - 1) {
                up = mine[row - 1][col];
                right = mine[row][col];
                if (up > right) {
                    row = row - 1;
                }
                sum += Math.max(up,right);
                continue;
            }

            up = mine[row - 1][col];
            right = mine[row][col];
            down = mine[row + 1][col];

            if (up > right && up > down) {
                row = row - 1;
            } else if (down > up && down > right) {
                row = row + 1;
            }
            sum += max(up, right, down);
        }
        return sum;
    }
}
