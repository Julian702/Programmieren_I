package de.dhbwka.java.exercise.io;

import java.io.*;

public class TextfileLines {
    
    private static File myDir = new File("src/de/dhbwka/java/exercise/io");
    private static File myFile = new File(myDir, "beispiel.txt");

    public static void main(String[] args) {
        int n = 0;
        try (   FileReader fr = new FileReader(myFile);
                BufferedReader br = new BufferedReader(fr)) {
            while(br.readLine() != null){
                n++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] s = new String[n];
        try (   FileReader fr = new FileReader(myFile);
                BufferedReader br = new BufferedReader(fr)) {
            for (int i = 0; i < s.length; i++) {
                s[i] = br.readLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sc = "";
        for (int i = 1; i < 5; i++) {
            System.out.println(s[i]);
            sc += s[i];
        }
        System.out.printf("Zeile 2-5: %s", sc);
    }
}
