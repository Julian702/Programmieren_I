package de.dhbwka.java.exercise.enums.cards;

public class PlayingCard implements Comparable<PlayingCard>{
    
    private Suit suit;
    private CardValue cardValue;

    public PlayingCard(){

    }

    public PlayingCard(Suit suit, CardValue cardValue){
        this.suit = suit;
        this.cardValue = cardValue;
    }

    public Suit getSuit() {
        return suit;
    }
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    public CardValue getCardValue() {
        return cardValue;
    }
    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return this.suit + " " + this.cardValue;
    }

    @Override
    public int compareTo(PlayingCard o) {
        return (Integer.valueOf(this.getOrderValue()).compareTo(o.getOrderValue()));
    }

    private int getOrderValue() {
        return this.getSuit().ordinal()*10 + this.getCardValue().ordinal();
    }
}