package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class DotProduct {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie viele Komponenten sollen die Vektoren haben?");
        int n = scan.nextInt();
        double[] u = new double[n];
        double[] v = new double[n];
        for (int i = 0; i < u.length; i++) {
            System.out.println(i+1 + ". Element des ersten Vektors?");
            u[i] = scan.nextInt();
        } 
        for (int i = 0; i < v.length; i++) {
            System.out.println(i+1 + ". Element des zweiten Vektors?");
            v[i] = scan.nextInt();
        } 
        System.out.println("Das Skalarprodukt der beiden Vektoren ist " + dotProduct(u, v));
    }

    public static double dotProduct(double[] u, double[] v){
        double dotProduct = 0;
        for (int i = 0; i < u.length; i++) {
            dotProduct += u[i] * v[i];
        }
        return dotProduct;
    }
}
