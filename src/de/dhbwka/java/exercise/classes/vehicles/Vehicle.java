package de.dhbwka.java.exercise.classes.vehicles;

public class Vehicle {
    private int wheels;
    private int vmax;
    private double pos;
    private double speed;

    public Vehicle(int wheels){
        this(wheels, 0, 0 ,0);
    }
    public Vehicle(double pos){
        this(0, 0, pos, 0);
    }
    public Vehicle(int wheels, int vmax){
        this(wheels, vmax, 0, 0);
    }
    public Vehicle(int wheels, double pos){
        this(wheels, 0, pos, 0);
    }
    public Vehicle(int wheels, int vmax, double speed){
        this(wheels, vmax, 0, speed);
    }
    public Vehicle(int wheels, int vmax, double pos, double speed){
        setWheels(wheels);
        setVmax(vmax);
        setPos(pos);
        setSpeed(speed);
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
    public int getWheels() {
        return wheels;
    }
    public void setVmax(int vmax) {
        this.vmax = vmax;
    }
    public int getVmax() {
        return vmax;
    }
    public void setPos(double pos) {
        this.pos = pos;
    }
    public double getPos() {
        return pos;
    }
    public void setSpeed(double speed) {
        this.speed = speed < vmax ? speed : vmax;
    }
    public double getSpeed() {
        return speed;
    }

    public void drive(double minutes){
        if(minutes > 0){
            setPos(getPos() + getSpeed()*(minutes/60)); ;
        }
    }
    @Override
    public String toString() {
        return String.format("%s at position %.1f km with %d wheels at speed %.1f of max. %d km/h.", super.getClass().getSimpleName(), getPos(), getWheels(), getSpeed(), getVmax());
    }
}
