package de.dhbwka.java.exercise.enums;

import java.util.Calendar;

public enum Months {

    JANUAR(31, "Hartung", "Eismond"),
    FEBRUAR(28, "Hornung", "Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester"),
    MAERZ(31,"Lenzing", "Lenzmond"),
    APRIL(30,"Launing", "Ostermond"),
    MAI(31,"Winnemond", "Blumenmond"),
    JUNI(30,"Brachet", "Brachmond"),
    JULI(31,"Heuert", "Heumond"),
    AUGUST(31,"Ernting", "Erntemond", "Bisemond"),
    SEPTEMBER(30,"Scheiding", "Herbstmond"),
    OKTOBER(31,"Gilbhart", "Gilbhard", "Weinmond"),
    NOVEMBER(30,"Nebelung", "Windmond", "Wintermond"),
    DEZEMBER(31,"Julmond", "Heilmond", "Christmond", "Dustermond");

    private int days;
    private String[] alt;

    private Months(int days, String... alt){
        this.days = days;
        this.alt = alt;
    }

    public int getDays() {
        return days;
    }
    public String[] getAlt() {
        return alt;
    }

    public static void main(String[] args) {
        Months mon = Months.values()[Calendar.getInstance().get(Calendar.MONTH)];
        System.out.printf("Der %s hat %d Tage und hieß früher %s", mon.name(), mon.getDays(), String.join(", ", mon.getAlt()));
    }    
}