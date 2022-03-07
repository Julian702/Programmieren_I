package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Fibonacci {
    
    public static void main(String[] args) {

        System.out.println("Wie viele Fibonacci-Zahlen berechnen?");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n<1){
            System.out.println("Falsche Eingabe! Bitte gebe eine Zahl größer 0 ein!");
            n = scan.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            System.out.printf("F(%d) = %d\n", i, fibonacci(i));
        }
    }

    public static long fibonacci(int n){
        return n<3 ? 1 : fibonacci(n-2) + fibonacci(n-1);
    }
}
