package de.dhbwka.java.exercise.control;

public class TemperatureTable {

    public static void main(String[] args) {

        System.out.println("Fahrenheit | Celsius");
        System.out.println("-----------+--------");
        for(double f = 0; f <= 300; f += 20){
            System.out.printf("%10.0f | %7.3f \n", f, convert(f));
        }
    }

    public static double convert(double f){
        double c = (5f/9f) * (f -32);
        return c;
    }
}
