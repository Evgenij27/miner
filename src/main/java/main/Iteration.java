package main;

import java.io.IOException;

public class Iteration {

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

        int row = data.getStartRow();

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

        System.out.println(sum);

    }

    private static void init(InputData data) {
        mine = data.getMine();
        rows = getRows(mine);
        cols = getCols(mine);
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }

    private static int getCols(int[][] mine) {
        if (mine.length == 0) {
            return 0;
        }
        return mine[0].length;
    }

    static int getRows(int[][] mine) {
        return mine.length;
    }
}
