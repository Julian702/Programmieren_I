package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class RomanNumber {
    
    public static void main(String[] args) {
        System.out.println("Bitte römische Zahl eingeben:");
        Scanner scan = new Scanner(System.in);
        String s = scan.next().toUpperCase();
        System.out.println("Der Wert der Zahl " + s + " ist " + RomantoDecimal(s));
    }

    public static int RomantoDecimal(String s){
        s += "O";
        String r = "OIVXLCDM";
        int[] v = {0, 1, 5, 10, 50, 100, 500, 1000};
        int v1, v2;
        int z = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if(r.indexOf(s.charAt(i)) >= 0 && r.indexOf(s.charAt(i+1)) >= 0){
                v1 = v[r.indexOf(s.charAt(i))];
                v2 = v[r.indexOf(s.charAt(i+1))];
                if(v1>=v2){
                    z += v1;
                }else{
                    z += v1*-1;
                }
            }else{
                System.out.println("Falsche Eingabe!");
                return -1;
            }
        }
        return z;
    }
}
