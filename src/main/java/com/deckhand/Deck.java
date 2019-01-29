package com.deckhand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sowjanya on 1/28/2019.
 */

public class Deck {
    List<Card> deck = new ArrayList<Card>();
    private int cardsUsed = 0;
    private boolean isShuffled;

    public Deck(){
        this(4,13,false);
    }

    public Deck(int suitLength , int valueLength, boolean jokerIncluded){

        if((suitLength <= 0 || suitLength > 4) || (valueLength <= 0 || valueLength > 13))
            throw new IllegalArgumentException(" Invalid length, deck can not be created");

        for (int i = 1; i<= suitLength; i++) {
            for(int j=1; j<= valueLength; j++){
                this.deck.add(new Card(i,j));
            }
        }
        if(jokerIncluded){
            this.deck.add(new Card(Card.JOKER,1));
            this.deck.add(new Card(Card.JOKER,2));
        }
        isShuffled = false;
    }
    public List<Card> getDeck(){

        return this.deck;
    }
    public void shuffle()
    {
        Collections.shuffle(this.deck);
        isShuffled = true;
    }

    public Card dealACard(){
        if(cardsUsed == deck.size()) {
            throw new IllegalArgumentException("Deck is empty");
        }
        cardsUsed++;
        return deck.get(cardsUsed-1);
    }
    
    public List<Card> dealSets(int numerOfCardstoDeal, int noOfSetsTodeals){
    	shuffle();
    	List<Card> dealtCards = new ArrayList<Card>();
    	for(int i = 0; i < noOfSetsTodeals; i++) {
    		for(int j = 0; j < numerOfCardstoDeal; j++) {
    			dealtCards.add(dealACard());
    		}
    	}
        return dealtCards;
    }
    
    public List<Card> dealASet(int numerOfCardstoDeal){
    	shuffle();
    	List<Card> dealtCards = new ArrayList<Card>();
    	for(int j = 0; j < numerOfCardstoDeal; j++) {
    		dealtCards.add(dealACard());
    	}
        return dealtCards;
    }

    public boolean hasJokers(){
        return (deck.size() == 54);
    }

    public int cardsRemaining(){
        return deck.size() - cardsUsed;
    }
    
    public boolean isShuffled(){
       return isShuffled;
    }
}
