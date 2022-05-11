package de.dhbwka.java.exercise.io;

import java.io.*;
import java.util.Scanner;

public class PalindromeFile {

    private static File myDir = new File("src/de/dhbwka/java/exercise/io");
    private static File myFile = new File(myDir, "palindrome.txt");
    
    public static void writeLine(String s) {
        myDir.mkdir();
        try (Writer fWriter = new FileWriter(myFile, true)) {
            fWriter.write("\n" + s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void printFile(){
        try (Scanner scan = new Scanner(new FileInputStream(myFile))) {
            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
