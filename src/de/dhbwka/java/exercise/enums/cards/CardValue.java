package de.dhbwka.java.exercise.enums.cards;

enum CardValue{
    SEVEN("7", "7"),
    EIGHT("8", "8"),
    NINE("9", "9"),
    JACK("B", "Bube"),
    QUEEN("D", "Dame"),
    KING("K", "K\u00F6nig"),
    TEN("10", "10"),
    ACE("A", "Ass");

    private final String name;
    private final String longName;

    private CardValue(String name, String longName) {
        this.name = name;
        this.longName = longName;
    }

    @Override
    public String toString() {
        return this.longName;
    }

    public String getName() {
        return name;
    }

    public String getLongName() {
        return longName;
    }    
}
