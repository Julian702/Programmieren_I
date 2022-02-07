package de.dhbwka.java.exercise.operators;

public class IncrementDecrement {
    
    public static void main(String[] args) {
        int i=0; // i=0
        int j=0; // j=0
        j = ++i; // j=1; i=1
        int k = j++ + ++i; // k=3; j=2; i=2
        System.out.println("k: " + k); // Ausgabe: k=3
        System.out.println("*: " + j++ + ++i); // Ausgabe: j=2, i=3 // j=3; i=3
        System.out.println(j++ + ++i); // Ausgabe: 7 // j=4; i=4
        int m = j++ * ++i; // m=20; j=5; i=5
        System.out.println("m: " + m); // Ausgabe: m=20
        int n = --j * --i; // n=16; j=4; i=4
        System.out.println("n: " + n); // Ausgabe: n=16
        System.out.println("i: " + i); // Ausgabe: i=4
        System.out.println("j: " + j); // Ausgabe: j=4
       }

}
