package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Norm {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie viele Komponenten soll der Vektor haben?");
        int n = scan.nextInt();
        double[] v = new double[n];
        for(int i = 0; i < v.length; i++) {
            v[i] = scan.nextDouble();
        }
        System.out.println("Der Betrag des Vektors ist " + mag(v));
    }

    public static double mag(double[] v){
        double sum = 0;
        for(int i = 0; i < v.length; i++) {
            sum += v[i]*v[i];
        }
        return Math.sqrt(sum);
    }
}
