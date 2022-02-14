package de.dhbwka.java.exercise.classes;

public class Point {
    
    private double x;
    private double y;

    public static void main(String[] args) {
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A" + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B" + pointB);
        System.out.println("Abstand A-B: " + pointA.getDistance(pointB));
        pointA = pointA.mirrorO();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: " + pointA.getDistance(pointB));
    }

    public Point(){
        this(0, 0);       
    }
    public Point(double x, double y){
        setX(x);
        setY(y);
    }

    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }

    public String toString(){
        return "("+getX()+"|"+getY()+").";
    }
    public double getDistanceO(){
        return pythagoras(getX(), getY());
    }
    public Point mirrorX(){
        return new Point(getX()*-1, getY());
    }
    public Point mirrorY(){
        return new Point(getX(), getY()*-1);
    }
    public Point mirrorO(){
        return new Point(getX()*-1, getY()*-1);
    }
    public double getDistance(Point p){
        return pythagoras(x-p.getX(), y-p.getY());
    }

    public static double pythagoras(double a, double b){
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
