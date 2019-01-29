package com.deckhand;

/**
 * Created by Sowjanya on 1/28/2019.
 */
public class Card {
    private int suit;
    private int value;

    public static final int JOKER = 5;

    public Card(int suit, int value){
        if(suit < 0 || suit > 5)
            throw new IllegalArgumentException(" Wrong card suit");

        if (suit != JOKER && (value < 0 || value > 13))
            throw new IllegalArgumentException(" Wrong card value");
        this.suit = suit;
        this.value = value;
    }

    public int getSuit(){
        return suit;
    }
    public void setSuit(int suit){
        this.suit = suit;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }

    public String toString(){
        return getValueAsString() + " of "+ getSuitAsString();
    }

    public String getSuitAsString()
    {
        switch (suit) {
            case 1: return "Club";
            case 2: return "Diamond";
            case 3: return "Heart";
            case 4: return "Spade";
            default: return "Joker";

        }
    }

    public String getValueAsString()
    {
        if(suit == JOKER)
            return ""+value;
        else {
            switch (value) {
                case 1:
                    return "Ace";
                case 2:
                    return "2";
                case 3:
                    return "3";
                case 4:
                    return "4";
                case 5:
                    return "5";
                case 6:
                    return "6";
                case 7:
                    return "7";
                case 8:
                    return "8";
                case 9:
                    return "9";
                case 10:
                    return "10";
                case 11:
                    return "Jack";
                case 12:
                    return "Queen";
                default:
                    return "King";
            }
        }
    }
}
