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
        for (int col = 1; col < getCols(mine); col++) {

                int u;
                int r;
                int d;

                if (row == 0) {
                    r = mine[row][col];
                    d = mine[row + 1][col];
                    if (d > r) {
                        row = row + 1;
                    }
                    sum += Math.max(r,d);
                    continue;
                }

                if (row == rows - 1) {
                    u = mine[row - 1][col];
                    r = mine[row][col];
                    if (u > r) {
                        row = row - 1;
                    }
                    sum += Math.max(u,r);
                    continue;
                }

                u = mine[row - 1][col];
                r = mine[row][col];
                d = mine[row + 1][col];

                if (u > r && u > d) {
                    row = row - 1;
                } else if (d > u && d > r) {
                    row = row + 1;
                }
                sum += max(u, r, d);
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
