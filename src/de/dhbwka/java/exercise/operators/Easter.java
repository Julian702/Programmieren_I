package de.dhbwka.java.exercise.operators;

import java.util.Scanner;

public class Easter {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int jahr = scan.nextInt();

        int ostern = getEaster(jahr);
        if(ostern <= 31){
            System.out.println("Ostern ist " + jahr + " am " + (ostern) + ". März");
        }else{
            System.out.println("Ostern ist " + jahr + " am " + (ostern-31) + ". April");
        }
    }

    public static int getEaster(int jahr){

        int a = jahr % 19;
        int b = jahr % 4;
        int c = jahr % 7;
        int k = jahr / 100;
        int p = (8*k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19*a + m) % 30;
        int e = (2*b + 4*c + 6*d + n) % 7;
        int ostern = (22 + d + e); // bezogen auf 1. März 
        
        return ostern;
    }
}
