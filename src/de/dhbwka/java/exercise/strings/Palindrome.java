package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

import de.dhbwka.java.exercise.io.PalindromeFile;

public class Palindrome {
    
    public static void main(String[] args) {
        System.out.println("Bitte Wort eingeben:");
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        StringBuilder strb = new StringBuilder(s);
        String sr = strb.reverse().toString();
        System.out.println("Umgekehrt: " + sr);
        if(s.equalsIgnoreCase(sr)){
            System.out.println(s + " ist ein Palindrom!");
            PalindromeFile.writeLine(s);
        }else{
            System.out.println(s + " ist kein Palindrom!");
        }
        System.out.println("Bisher gefundene Palindrome:");
        PalindromeFile.printFile();
    }
}
