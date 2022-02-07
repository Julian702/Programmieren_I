package de.dhbwka.java.exercise.arrays;

public class Fibonacci {
    
    public static void main(String[] args){
        long[] fibonacci = new long[50];
        fibonacci[0] = 1; fibonacci[1] = 1;
        for(int i = 2; i < fibonacci.length; i++){
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
        }
        for(int i = 0; i < fibonacci.length; i++){
            System.out.print(fibonacci[i] + " ");
        }
    }
}
