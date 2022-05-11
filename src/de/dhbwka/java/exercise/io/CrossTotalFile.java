package de.dhbwka.java.exercise.io;

import java.io.*;

public class CrossTotalFile {

    private static File myDir = new File("src/de/dhbwka/java/exercise/io");
    private static File myFile = new File(myDir, "crosstotals.txt");

    public static void writeLine(String s) {
        try (Writer fWriter = new FileWriter(myFile, true)) {
            fWriter.write(s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
