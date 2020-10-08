package main;

import java.io.IOException;

public class Recursion {

    static int rows;
    static int cols;
    static int[][] mine;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Please provide input file");
            System.exit(1);
        }

        String fileName = args[0];
        InputData data = InputDataReader.readFile(fileName);

        init(data);

        int startRow = data.getStartRow();
        int m = doMine(startRow, 0);
        System.out.println(m);
    }

    private static void init(InputData data) {
        mine = data.getMine();
        rows = getRows(mine);
        cols = getCols(mine);
    }

    static int doMine(int row, int col) {
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

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }

    private static int mineUp(int row, int col) {
        return doMine(row - 1, col + 1) + mine[row][col];
    }

    private static int mineDown(int row, int col) {
        return doMine(row + 1, col + 1) + mine[row][col];
    }

    private static int mineRight(int row, int col) {
        return doMine(row, col + 1) + mine[row][col];
    }

    static int getRows(int[][] mine) {
        return mine.length;
    }

    private static int getCols(int[][] mine) {
        if (mine.length == 0) {
            return 0;
        }
        return mine[0].length;

    }
}
