package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Welches Jahr soll auf Schaltjahr geprüft werden?");
		int jahr = scan.nextInt();

		if(leapYear(jahr)){
			System.out.println(jahr + " ist ein Schaltjahr!");
		} else {
			System.out.println(jahr + " ist kein Schaltjahr!");
		}
	}

	public static boolean leapYear(int jahr){
		if (jahr % 400 == 0) {
			return true;
		}
		if (jahr % 100 == 0) {
			return false;
		}
		if (jahr % 4 == 0) {
			return true;
		}
		return false;
	}
}
