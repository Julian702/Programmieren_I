package de.dhbwka.java.exercise.control;

public class ShoeSize {
    
    public static void main(String[] args){

        System.out.println(" Zentimer      | Größe");
        System.out.println("---------------+-------");
        double d = 58d/3d;
        for (int i = 30; i < 50; i++){
            System.out.printf(" %.2f - ", d);
            d += 2d/3d;
            System.out.printf("%4.2f | %5d \n", d, i);
        }
    }
}
