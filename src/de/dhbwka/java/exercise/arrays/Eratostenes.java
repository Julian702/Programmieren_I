package de.dhbwka.java.exercise.arrays;

public class Eratostenes {

    public static void main(String[] args){
        
        int n = 100;
        boolean prim[] = eratostenes(n);
        System.out.println("Primzahlen von 0 bis " + n);
        for(int i = 0; i < prim.length; i++){
            if(prim[i]){
                System.out.print(i + " ");
            }
        }
    }

    public static boolean[] eratostenes(int n){

        boolean prim[] = new boolean[n];
        for(int i = 0; i < prim.length; i++){
            prim[i] = true;
        }
        prim[0] = false; prim[1] = false;
        for(int i = 0; i < prim.length; i++){
            if(prim[i] == true){
                for(int j = i*2; j < prim.length; j += i){
                    prim[j] = false;
                }
            }
        }
        return prim;
    }
}
