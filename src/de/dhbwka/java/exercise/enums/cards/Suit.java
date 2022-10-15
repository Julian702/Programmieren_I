package de.dhbwka.java.exercise.enums.cards;

public enum Suit{
    DIAMONDS("Karo", 9),
    HEART("Herz", 10),
    SPADE("Pik",11),
    CLUBS("Kreuz", 12);

    private final String name;
    private final int value;

    private Suit(String name, int value){
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
