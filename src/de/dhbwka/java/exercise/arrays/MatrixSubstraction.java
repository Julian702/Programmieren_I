package de.dhbwka.java.exercise.arrays;

import java.util.Random;
import java.util.Scanner;

public class MatrixSubstraction {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Anzahl der Zeilen n eingeben!");
        int n = scan.nextInt();
        System.out.println("Anzahl der Spalten m eingeben!");
        int m = scan.nextInt();
        int[][] x = new int[n][m];
        int[][] y = new int[n][m];
        Random r = new Random();
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                x[i][j] = r.nextInt(100);
                y[i][j] = r.nextInt(100);
            }
        }
        System.out.println("X:");
        printMatrix(x);
        System.out.println("Y:");
        printMatrix(y);
        System.out.println("X-Y");
        printMatrix(matrixSubstraction(x, y));
    }

    public static void printMatrix(int[][] d) {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                System.out.printf("%4d", d[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] matrixSubstraction(int[][] x, int[][] y){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                x[i][j] -= y[i][j];
            }
        }
        return x;
    }
}
