package de.dhbwka.java.exercise.classes.vehicles;

public class Car extends Vehicle{
    public Car() {
        this(140);
    }
    public Car(int vmax){
        super(4, vmax);
    }
    public Car(double speed){
        this(140, speed);
    }
    public Car(int vmax, double speed){
        super(4, vmax, speed);
    }
    public Car(double pos, double speed){
        this(140, pos, speed);
    }
    public Car(int vmax, double pos, double speed){
        super(4, vmax, pos, speed);
    }
}
