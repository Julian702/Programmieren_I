package de.dhbwka.java.exercise.control;

public class MultiplicationTable {

    public static void main(String[] args) {

        for(int zeile = 1; zeile <= 10; zeile++) {
            for(int spalte = 1; spalte <= 10; spalte++){
                System.out.printf("%4d", zeile * spalte);
            }
            System.out.printf("\n");
        }
    }
}
