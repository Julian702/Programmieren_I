package de.dhbwka.java.exercise.classes.vehicles;

public class Ambulance extends Car{
    
    private boolean signal;

    public Ambulance(){
        this(false);
    }
    public Ambulance(boolean signal){
        super();
        setSignal(signal);
    }
    public Ambulance(int vmax){
        super(vmax);
        setSignal(false);
    }
    public Ambulance(int vmax, boolean signal){
        super(vmax);
        setSignal(signal);
    }
    public Ambulance(double speed){
        this(speed, false);
    }
    public Ambulance(double speed, boolean signal){
        super(speed);
        setSignal(signal);
    }
    public Ambulance(int vmax, double speed){
        this(vmax, speed, false);
    }
    public Ambulance(int vmax, double speed, boolean signal){
        super(vmax, speed);
        setSignal(signal);
    }
    public Ambulance(int vmax, double pos, double speed){
        this(vmax, pos, speed, false);
    }
    public Ambulance(int vmax, double pos, double speed, boolean signal){
        super(vmax, pos, speed);
        setSignal(signal);
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }
    public boolean getSignal(){
        return signal;
    }
}
