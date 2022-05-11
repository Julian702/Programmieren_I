package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

import de.dhbwka.java.exercise.io.CrossTotalFile;

public class CrossTotal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(getCrossTotalString(s));
        CrossTotalFile.writeLine(getCrossTotalString(s));
    }

    public static int getCrossTotal(String s){
        int z = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                z += Character.getNumericValue(c);
            }
        }
        return z;
    }

    public static String getCrossTotalString(String s){
        return String.format("Die Quersumme von %s ist %d!\n", s, getCrossTotal(s));
    }
}
