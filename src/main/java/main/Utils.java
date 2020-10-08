package main;

public class Utils {

    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }

    public static int getRows(int[][] mine) {
        return mine.length;
    }

    public static int getCols(int[][] mine) {
        if (mine.length == 0) {
            return 0;
        }
        return mine[0].length;

    }
}
