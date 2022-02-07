package de.dhbwka.java.exercise.datatypes;

public class Round {
    
    public static void main(String[] args) {

        double pi = 3.1415926; // Naeherung der Kreiszahl Pi
        double e = 2.7182818; // Naeherung der Eulerschen Zahl e
        double n = -3.6; // negative Zahl n

        System.out.println("Pi ganzzahlig: " + round(pi));
        System.out.println("e ganzzahlig: " + round(e));
        System.out.println("n ganzzahlig: " + round(n));
    }

    public static int round(double d){
        
        d = (d<0) ? d-0.5 : d+0.5;

        return (int) d;
    }
    
    public static double round(double d, int n){

        double m = Math.pow(10, n);

        d = round(d * m) / m;

        return d;
    }
}
