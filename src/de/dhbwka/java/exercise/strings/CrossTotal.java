package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class CrossTotal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int z = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                z += Character.getNumericValue(c);
            }else{
                System.err.printf("%s ist keine Zahl!\n", c);
            }
        }
        System.out.printf("Die Quersumme von %s ist %d!", s, z);
    }
}
