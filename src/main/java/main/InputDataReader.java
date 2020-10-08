package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * File format:
 * row - start row
 * a11 a12 a1N
 * a21 a22 a2N
 * a31 a32 aNN
 *
 */
public class InputDataReader {

    public static InputData readFile(String fileName) throws IOException {
        InputData data = new InputData();

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String startRow = reader.readLine();

            data.setStartRow(Integer.parseInt(startRow));

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        int[][] field = new int[lines.size()][];
        for (int row = 0; row < lines.size(); row++) {
            String line = lines.get(row);
            String[] elements = line.split(" ");
            int[] columns = new int[elements.length];
            for (int col = 0; col < elements.length; col++) {
                columns[col] = Integer.parseInt(elements[col]);
            }
            field[row] = columns;
        }
        data.setMine(field);
        return data;
    }
}
