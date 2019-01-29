package com.deckhand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sowjanya on 1/28/2019.
 */

public class TestCard {
    Card validCard = new Card(1, 1);
    
	@Before
	public void setUp() {
		validCard = new Card(1, 1);
	}
    
    @Test
    public void testGetSuit() {
        
        Assert.assertEquals("Suit doesn't match", 1, validCard.getSuit());
    }
    
    @Test
    public void testGetValue() {
        Assert.assertEquals("value doesn't match", 1, validCard.getValue());
    }
    
    @Test
    public void testGetSuitAsString() {
        Assert.assertEquals("Incorrect Suit", "Club", validCard.getSuitAsString());
    }
    
    @Test
    public void testGetValueAsString() {
        Assert.assertEquals("Incorrect Value", "Ace", validCard.getValueAsString());
    }
    
    @Test
    public void testForGetString() {
        System.out.println(validCard);
        Assert.assertEquals("cannot convert to string ", "Ace of Club", validCard.toString());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidSuit(){
        Card invalidCardSuit = new Card(5, 1);
        invalidCardSuit.getSuitAsString();
        Card invalidCardSuit1 = new Card(-1, 12);
        invalidCardSuit1.getSuitAsString();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidValue(){
        Card invalidCardValue = new Card(3, 14);
        invalidCardValue.getValueAsString();
        Card invalidCardValue1 = new Card(2, -1);
        invalidCardValue1.getValueAsString();
        
    }
    
    //@Test
    public void testForJoker() {
        Card validJokerCard = new Card(4, 1);
        System.out.println(validJokerCard);
        Assert.assertEquals("cannot convert to string ", "1 of Joker", validJokerCard.toString());
    }
}

