package de.dhbwka.java.exercise.classes;

import java.util.Random;

public class Complex {

    private double a;
    private double b;

    public static void main(String[] args) {
        Random r = new Random();
        Complex z[] = new Complex[10];
        System.out.println("Unsortiert:");
        for (int i = 0; i < z.length; i++) {
            z[i] = new Complex(r.nextDouble()*10, r.nextDouble()*10);
            System.out.printf("%s Betrag: %6.3f \n", z[i], z[i].getMagnitude());
        }
        bubbleSort(z);
        System.out.println("Sortiert:");
        for (int i = 0; i < z.length; i++) {
            System.out.printf("%s Betrag: %6.3f \n", z[i], z[i].getMagnitude());
        }
    }

    public Complex(double b){
        this(0, b);
    }
    public Complex(double a, double b){
        setReal(a);
        setImag(b);
    }

    public double getReal() {
        return a;
    }
    public void setReal(double a) {
        this.a = a;
    }
    public double getImag() {
        return b;
    }
    public void setImag(double b) {
        this.b = b;
    }
    public Complex add(Complex z){
        return new Complex(getReal()+z.getReal(), getImag()+z.getImag());
    }
    public Complex sub(Complex z){
        return new Complex(getReal()+z.getReal(), getImag()+z.getImag());
    }
    public Complex mult(Complex z){
        return new Complex(getReal()*z.getReal()-getImag()*z.getImag(), getReal()*z.getImag()+getImag()*z.getReal());
    }
    public Complex div(Complex z){
        return new Complex((getReal()*z.getReal()+getImag()*z.getImag())/(Math.pow(z.getReal(), 2)+Math.pow(z.getImag(), 2)), (getImag()*z.getReal()-getReal()*z.getImag())/(Math.pow(z.getReal(), 2)+Math.pow(z.getImag(), 2)));
    }
    public String toString() {
        return String.format("%4.3f + %4.3fi", getReal(), getImag());
    }
    public double getMagnitude(){
        return Point.pythagoras(getReal(), getImag());
    }
    public boolean isLess(Complex z){
        return getMagnitude() < z.getMagnitude() ? true : false;
    }
    public static void bubbleSort(Complex[] z){
        for(int i = 0; i < z.length - 1; i++) {
            for(int j = 0; j < z.length - i - 1; j++) {
                if(z[j].getMagnitude() > z[j+1].getMagnitude()){
                    Complex temp = z[j];
                    z[j] = z[j+1];
                    z[j+1] = temp;
                }
            }
        }
    }
}
