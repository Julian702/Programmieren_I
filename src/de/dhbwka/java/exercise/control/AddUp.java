package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class AddUp {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(wh(scanner));
        System.out.println(dw(scanner));
    }

    public static double wh(Scanner scanner){

        double sum = 0;
        double scan = 0;
        while(scan > 0){
            sum += scan;
            scan = scanner.nextDouble();
        }
        return sum;
    }

    public static double dw(Scanner scanner){
        
        double sum = 0;
        double scan = 0;
        do {
            sum += scan;
            scan = scanner.nextDouble();
        } while (scan > 0);
        return sum;
    }
}
