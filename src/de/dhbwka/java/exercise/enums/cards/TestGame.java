package de.dhbwka.java.exercise.enums.cards;

public class TestGame {
    
    public static void main(String[] args) {
        CardGame deck = new CardGame();
        deck.shuffle();
        PlayingCard card = deck.get();
        PlayingCard heartSeven = new PlayingCard(Suit.HEART, CardValue.SEVEN);
        
        System.out.println("10 Karten ziehen und vergleichen:");
        for(int i = 0; i < 10; i++){
            System.out.println(card + " vergleichen mit " + heartSeven + ": " + card.compareTo(heartSeven));
            card = deck.get();
        }
        deck.sort();

        System.out.println("\u00DCbrige Karten sortiert:");
        for (PlayingCard cd : deck.all()) {
            System.out.println(cd);
        }
    }
}