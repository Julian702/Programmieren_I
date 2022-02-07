package de.dhbwka.java.exercise.arrays;

import java.util.Random;

public class StandardDeviation {
    
    public static void main(String[] args){

        Random r = new Random();
        int[] zahlen = new int[1000000];
        for(int i = 0; i < zahlen.length; i++){
            zahlen[i] = r.nextInt(11);
        }
        System.out.println(mean(zahlen));
        System.out.println(standardDeviation(zahlen));
    }

    public static double mean(int[] zahlen){
        int sum = 0;
        for(int i = 0; i < zahlen.length; i++){
            sum += zahlen[i];
        }
        return (double) sum/zahlen.length;
    }

    public static double standardDeviation(int zahlen[]){
        double sum = 0;
        double am = mean(zahlen);
        for(int i = 0; i < zahlen.length; i++){
            sum += Math.pow(zahlen[i] - am, 2);
        }
        return Math.sqrt((double) sum / (zahlen.length - 1));
    }
}
