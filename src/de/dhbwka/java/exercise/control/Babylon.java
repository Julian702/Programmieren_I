package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Babylon {
    
    public static void main(String[] args){

        System.out.println("Wurzel aus welcher Zahl ziehen?");

        Scanner scan = new Scanner(System.in);
        double d = scan.nextDouble();

        System.out.println("Die Wurzel aus " + d + " ist " + Wurzelziehen(d));
    }

    public static double Wurzelziehen(double d){

        double xn;
        double xn1 = 1;

        do {
            xn = xn1;
            System.out.println(xn);
            xn1 = (xn + (d / xn)) / 2;
        } while (Math.abs(xn1 - xn) >= Math.pow(10, -6));

        return xn1;
    }
}
