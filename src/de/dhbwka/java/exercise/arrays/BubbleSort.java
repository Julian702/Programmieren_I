package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class BubbleSort {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie viele Elemente soll die Liste haben?");
        int n = scan.nextInt();
        double[] zahlen = new double[n];
        for(int i = 0; i < zahlen.length; i++) {
           zahlen[i] = scan.nextDouble(); 
        }
        System.out.println("Unsortierte Liste:");
        for(int i = 0; i < zahlen.length; i++) {
            System.out.print(zahlen[i] + " "); 
         }
        bubbleSort(zahlen);
        System.out.println();
        System.out.println("Sortierte Liste:");
        for(int i = 0; i < zahlen.length; i++) {
           System.out.print(zahlen[i] + " "); 
        }
    }

    public static void bubbleSort(double[] zahlen){
        for(int i = 0; i < zahlen.length - 1; i++) {
            for(int j = 0; j < zahlen.length - i - 1; j++) {
                if(zahlen[j] > zahlen[j+1]){
                    double temp = zahlen[j];
                    zahlen[j] = zahlen[j+1];
                    zahlen[j+1] = temp;
                }
            }
        }
    }
}
