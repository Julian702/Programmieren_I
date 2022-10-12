package de.dhbwka.java.exercise.collections.gas;

public class GasPrices {
    
    private double diesel;
    private double superE5;
    private double superE10;

    public double getDiesel() {
        return diesel;
    }
    public void setDiesel(double diesel) {
        this.diesel = diesel;
    }
    public double getSuperE5() {
        return superE5;
    }
    public void setSuperE5(double superE5) {
        this.superE5 = superE5;
    }
    public double getSuperE10() {
        return superE10;
    } 
    public void setSuperE10(double superE10) {
        this.superE10 = superE10;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Diesel: %.3f SuperE5: %.3f SuperE10: %.3f", this.getDiesel(), this.getSuperE5(), this.getSuperE10());
    }
}
