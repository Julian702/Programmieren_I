package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Exponentiation {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben sie bitte die Basis ein: ");
        double x = scan.nextDouble();
        System.out.println("Geben sie bitte den positiven ganzzahligen Exponenten ein: ");
        int n = scan.nextInt();
        System.out.printf("%.1f^ %d = %.1f", x, n, xPowerN(x, n));
    }

    public static double xPowerN(double x, int n){
        return n==0 ? 1 : x*xPowerN(x, n-1);
    }
}
