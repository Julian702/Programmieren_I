package de.dhbwka.java.exercise.classes.vehicles;

public class RacingCar extends Car{

    public RacingCar() {
        super(220);
    }
    public RacingCar(double speed){
        super(220, speed);
    }
    public RacingCar(double pos, double speed){
        super(220, pos, speed);
    }
}
