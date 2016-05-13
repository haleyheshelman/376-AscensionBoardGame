package devops.hw1.core;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * Bottom up testing of the Player class.
 *
 * @author heshelhj.
 *         Created May 12, 2016.
 */

public class integrationTesting {
	
	@Test
	public void testPlayerCardInHand(){
		Player p = Player.makePlayer();
		ACard card = ACard.makeCard();
		p.addCardToHand(card);
		
		assertTrue(p.getHand().contains(card));		
	}
	
	@Test
	public void testPlayerCardInDeck(){
		Player p = Player.makePlayer();
		ACard card = ACard.makeCard();
		p.addCardToDeck(card);
		
		assertTrue(p.getDeck().contains(card));	
	}
	
	@Test
	public void testPlayerCardInDiscard(){
		Player p = Player.makePlayer();
		ACard card = ACard.makeCard();
		p.discard(card);
		
		assertTrue(p.getDiscardPile().contains(card));	
	}
		
}
