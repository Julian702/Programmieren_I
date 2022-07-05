package de.dhbwka.java.exercise.collections;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {
    
    private Set<Integer> numbers = new TreeSet<>();
    private int sNumber;
    private Random rnd = new Random();
    
    public static void main(String[] args) {
        Lottery lot = new Lottery();
        System.out.println(lot);
    }

    public Lottery(){
        while(numbers.size() < 7){
            numbers.add(sNumber = rnd.nextInt(49)+1);
        }
        numbers.remove(sNumber);
    }

    @Override
    public String toString() {
        String s = "";
        for (Integer n : numbers){
            s += n + " ";
        }
        s += "Superzahl: " + sNumber;
        return s;
    }
}
