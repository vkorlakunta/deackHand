package com.deckhand;

import static org.junit.Assert.*; 


import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sowjanya on 1/28/2019.
 */

public class TestDeck {
	
	Deck deck;
	
	@Before
	public void setUp() {
		deck = new Deck();
	}

	@Test
	public void testNotEmptyDeck() {
		assertNotNull(deck.getDeck());
	}
	
	@Test
	public void testForNumberofCardsinReturnDeck() {
		assertEquals(52, deck.getDeck().size());
	}
	
	@Test
	public void testHasJokers() {
		deck = new Deck(4, 13, true);
		assertEquals(54, deck.getDeck().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testForEmptyDeckWithInvalidFaceValue() {
		deck = new Deck(1, 24, false);
		assertEquals(0, deck.getDeck().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testForEmptyDeckWithInvalidSuiteValue() {
		deck = new Deck(-1, 0, false);
		assertEquals(0, deck.getDeck().size());
	}

	@Test
	public void testShuffle() {
		assertFalse(deck.isShuffled());
		deck.shuffle();
		assertTrue(deck.isShuffled());
	}

	@Test
	public void testDealACard() {
		assertNotNull(deck.dealACard());
	}
	
	@Test
	public void testDealSets() {
		deck.dealSets(3, 4);
		assertEquals(40, deck.cardsRemaining());
	}
	
	@Test
	public void testDealSet() {
		deck.dealASet(13);
		assertEquals(39, deck.cardsRemaining());
	}

	@Test
	public void testCardsRemaining() {
		assertEquals(52, deck.cardsRemaining());
		deck.dealACard();
		assertEquals(51, deck.cardsRemaining());
		
	}
}
