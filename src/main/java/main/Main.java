package main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Please provide input file");
            System.exit(1);
        }

        String fileName = args[0];
        InputData data = InputDataReader.readFile(fileName);

        IterationSolver solution = new IterationSolver(data.getMine());
        int result = solution.solve(data.getStartRow());
        System.out.println(result);
    }

}
