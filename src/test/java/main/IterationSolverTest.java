package main;

import org.junit.Assert;
import org.junit.Test;

public class IterationSolverTest {

    @Test
    public void testSolution() {
        int[][] mine = {
                {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}};

        int startRow = 1;

        IterationSolver solver = new IterationSolver(mine);
        Assert.assertEquals(12, solver.solve(startRow));

        mine = new int[][] {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};

        solver = new IterationSolver(mine);
        startRow = 2;

        Assert.assertEquals(16, solver.solve(startRow));

        mine = new int[][] {
                {10, 33, 13, 15},
                {22, 11, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};

        solver = new IterationSolver(mine);
        startRow = 1;

        Assert.assertEquals(83, solver.solve(startRow));

    }
}
