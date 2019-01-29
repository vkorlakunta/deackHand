package com.deckhand;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sowjanya on 1/28/2019.
 */

public class TestHand {
    Deck deck;
    Hand hand;
    
    @Before
	public void setUp() {
    	deck = new Deck();
    	hand = new Hand();
	}
    @Test
    public void testAddCardAndVerifyHand() {
        ArrayList<Card> actualCards = new ArrayList<Card>();
        for (int i = 0; i < (deck.getDeck().size()); i++) {
            deck.shuffle();
            Card card = deck.dealACard();
            actualCards.add(card);
            hand.addCard(card);
        }
        List<Card> expectedCards = hand.getHand();
        Assert.assertArrayEquals(expectedCards.toArray(), actualCards.toArray());
    }
    
    @Test
    public void testRemoveCard() {
        Card dealCard = new Card(3,10);
        ArrayList<Card> actualCards = new ArrayList<Card>();
        for(int i=0;i<(deck.getDeck().size());i++) {
            deck.shuffle();
            deck.dealACard();
            actualCards.add(dealCard);
            hand.addCard(dealCard);
        }
        hand.removeCard(dealCard);
        Assert.assertTrue(hand.getHand().size() == 51);
    }
    
    @Test
    public void testSortBySuit() {
        hand.addHand(deck.dealASet(13));
        List<Card> beforeSortCards = new ArrayList<Card>();
        beforeSortCards.addAll(hand.getHand());
        System.out.println("Before Sort :: " + beforeSortCards);
        hand.sortBySuit();
        System.out.println("After Sort :: " + hand.getHand());
        assertNotEquals(beforeSortCards, hand.getHand());
    }
    
    @Test
    public void testSortByValue() {
    	hand.addHand(deck.dealASet(13));
    	List<Card> beforeSortCards = new ArrayList<Card>();
        beforeSortCards.addAll(hand.getHand());
        System.out.println("Before Sort :: " + beforeSortCards);
        hand.sortByValue();
        System.out.println("After Sort :: " + hand.getHand());
        assertNotEquals(beforeSortCards, hand.getHand());
    }
    
    
}
