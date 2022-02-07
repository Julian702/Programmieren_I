package de.dhbwka.java.exercise.control;

public class Deers {
    
    public static void main(String[] args){

        double b = 1.1;
        int jahr = 0;
        int deers = 200;

        while (deers < 300){
            deers = (int) (deers*b-15);
            System.out.println("Am Ende des " + ++jahr + ". Jahres gibt es " + deers + " Hirsche.");
        }
    }
}
