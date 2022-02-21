package de.dhbwka.java.exercise.classes;

public class Polynomial {
    
    private double a;
    private double b;
    private double c;

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(2);
        System.out.println("P1: " + p1);
        Polynomial p2 = new Polynomial(0, -4, 1);
        System.out.println("P2: " + p2);
        Polynomial p3 = p1.add(p2);
        System.out.println("P3 = P1 + P2: " + p3);
        Polynomial p4 = p1.sub(p2);
        System.out.println("P4 = P1 - P2: " + p4);
        Polynomial p5 = p3.multPolynomial(2);
        System.out.println("P5 = 2 * P3: " + p5);
        double[] x = p5.getZero();
        if(x.length != 0) {
            System.out.println("Nullstellen von P5: " + x[0] + ", " + x[1]);
        }else{
            System.out.println("P5 hat keine Nullstelen!");
        }
    }

    public Polynomial(){
        this(1, 0, 0);
    }
    public Polynomial(double a){
        this(a, 0, 0);
    }
    public Polynomial(double a, double b){
        this(a, b, 0);
    }
    public Polynomial(double a, double b, double c){
        setA(a);
        setB(b);
        setC(c);
    }

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }

    public String toString(){
        return String.format("%4.1fx^2 + %4.1fx + %4.1f", getA(), getB(), getC());
    }
    public double f(double x){
        return getA()*Math.pow(x, 2) + getB()*x + getC();
    }
    public Polynomial add(Polynomial p){
        return new Polynomial(getA()+p.getA(), getB()+p.getB(), getC()+p.getC());
    }
    public Polynomial sub(Polynomial p){
        return new Polynomial(getA()-p.getA(), getB()-p.getB(), getC()-p.getC());
    }
    public Polynomial multPolynomial(double s){
        return new Polynomial(getA()*s, getB()*s, getC()*s);
    }
    public double[] getZero(){
        double p = getB()/getA();
        double q = getC()/getA();
        if(Math.pow(p/2, 2) - q < 0){
            return new double[0];
        }else{
            double x[] = new double[2];
            x[0] = -1*p/2+Math.sqrt(Math.pow(p/2, 2) - q);
            x[1] = -1*p/2-Math.sqrt(Math.pow(p/2, 2) - q);
            return x;
        }
    }
}
