package com.deckhand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sowjanya on 1/28/2019.
 */
public class Hand {
    private List<Card> hand = new ArrayList<Card>();

    public List<Card> getHand()
    {
        return hand;
    }
    
    public void addHand(List<Card> hand)
    {
    	this.hand.addAll(hand);
    }

    public void clear()
    {
        hand.clear();
    }

    public void addCard(Card c)
    {
        if(c == null)
            throw new NullPointerException("Can not add  a null card to a hand.");
        hand.add(c);
    }

    public void removeCard(Card c)
    {
        hand.remove(c);
    }

    public void removeCard(int position)
    {
        if(position < 0 || position >= hand.size())
            throw new IllegalArgumentException("Position does not exist in hand: "+position);
        hand.remove(position);
    }

    public int getCardCount()
    {
        return hand.size();
    }

    public Card getCard(int position){
        if(position <0 || position >= hand.size())
            throw new IllegalArgumentException("Position does not exist in hand: "+position);
        return hand.get(position);

    }

    public void sortBySuit(){
        List<Card> newHand = new ArrayList<Card>();
        while(!hand.isEmpty()){
            int position = 0;
            Card minCard = hand.get(0);
            for(int i = 1; i < hand.size(); i++){
                Card cardOne = hand.get(i);
                if(cardOne.getSuit() < minCard.getSuit() ||
                        ( cardOne.getSuit() == minCard.getSuit() && cardOne.getValue() < minCard.getValue() )){
                    position = i;
                    minCard = cardOne;
                }
            }
            hand.remove(position);
            newHand.add(minCard);
        }
        hand = newHand;
    }

    public void sortByValue(){
        List<Card> newHand = new ArrayList<Card>();
        while(!hand.isEmpty()){
            int position = 0;
            Card minCard = hand.get(0);
            for(int i = 1 ;i < hand.size();i++){
                Card cardOne = hand.get(i);
                if(cardOne.getValue() < minCard.getValue() ||
                        ( cardOne.getValue() == minCard.getValue() && cardOne.getSuit() < minCard.getSuit())){
                    position = i;
                    minCard = cardOne;
                }
            }
            hand.remove(position);
            newHand.add(minCard);
        }
        hand = newHand;
    }
}
