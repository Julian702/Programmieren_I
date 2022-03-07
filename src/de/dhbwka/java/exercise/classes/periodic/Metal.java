package de.dhbwka.java.exercise.classes.periodic;

public class Metal extends Element {

    private boolean metalloid;
    private double conductivity;
    
    public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean main, boolean metalloid, double conductivity){
        super(name, symbol, ordinal, shell, phase, main);
        setMetalloid(metalloid);
        setConductivity(conductivity);
    }
    public void setMetalloid(boolean metalloid) {
        this.metalloid = metalloid;
    }
    public boolean getMettaloid() {
        return metalloid;
    }
    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }
    public double getConductivity() {
        return conductivity;
    }
    @Override
    public String toString() {
        return String.format("%s,%s Conductivity: %.3f", super.toString(), getMettaloid() ? "Halbmetall ," : "", getConductivity());
    }
}
