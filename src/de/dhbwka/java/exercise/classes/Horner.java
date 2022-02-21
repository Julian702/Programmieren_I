package de.dhbwka.java.exercise.classes;

public class Horner {
    
    private double[] h; // mit [x0, x1, x2, x3, ..., xn]

    public static void main(String[] args) {
        double x = 1.5;
        double[] a = {1, -2, 3, 4.5, 8, -10, 3, 4, 2, -3, 0.5};
        Horner h1 = new Horner(a);
        System.out.println("h1 = "+h1);
        System.out.println("h1("+ x + ") = " + h1.getValue(x));
        Polynomial p = new Polynomial(1, 2, 3);
        Horner h2 = new Horner(p);
        System.out.println("h2 = "+h2);
    }

    public Horner(int[] h){
        for (int i = 0; i < h.length; i++) {
            this.h[i] = h[i];   
        }
    }
    public Horner(double[] h){
        this.h = h;
    }
    public Horner(Polynomial p){
        this(new double[] {p.getC(), p.getB(), p.getA()});
    }

    public double getValue(double x){
        double fx = 0;
        for (int i = h.length-1; i >= 0; i--) {
            fx = h[i]+x*fx;
        }
        return fx;
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < h.length; i++) {
            s = String.format(" + " + h[i] + "%s",  i==0 ? "" : i==1 ? "x"+s : "x^"+i+s);
        }
        return s.substring(3);
    }
}