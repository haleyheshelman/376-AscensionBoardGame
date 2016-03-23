/**
 * 
 */
package devops.hw1.core;

import static org.junit.Assert.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

/**
 * @author fenogljc
 *
 */
public class Tests {

	@Test
	public void testMakeCard() {
		Card newCard = Card.makeCard();
		assertTrue(newCard instanceof Card);
	}
	
	@Test
	public void testGetCardCost() {
		Card newCard = Card.makeCard(2);
		assertTrue(newCard.getCost() == 2);
	}
	
	@Test
	public void testGetDefaultCardCost() {
		Card newCard = Card.makeCard();
		assertTrue(newCard.getCost() == 0);
	}
	
	@Test
	public void testMakePlayer() {
		Player newPlayer = Player.makePlayer();
		assertTrue(newPlayer instanceof Player);
	}
	
	@Test
	public void testPlayerHasRunes() {
		Player newPlayer = Player.makePlayer();
		newPlayer.addRunes(3);
		assertTrue(newPlayer.getRunes() == 3);
	}
	
	@Test
	public void testPlayerAddRunes() {
		Player newPlayer = Player.makePlayer();
		assertTrue(newPlayer.getRunes() == 0);
		newPlayer.addRunes(3);
		assertTrue(newPlayer.getRunes() == 3);
		newPlayer.addRunes(-1);
		assertFalse(newPlayer.getRunes() == 3);
		assertTrue(newPlayer.getRunes() == 2);
		newPlayer.addRunes(-4);
		assertTrue(newPlayer.getRunes() == 0);
	}
	
	@Test
	public void testPlayerDiscard() {
		Player newPlayer = Player.makePlayer();
		assertTrue(newPlayer.getDiscardSize() == 0);
		newPlayer.setDiscardSize(newPlayer.getDiscardSize() + 1);
		assertTrue(newPlayer.getDiscardSize() == 1);
		newPlayer.setDiscardSize(newPlayer.getDiscardSize() + 2);
		newPlayer.setDiscardSize(newPlayer.getDiscardSize() - 1);
		assertTrue(newPlayer.getDiscardSize() == 2);
	}
	
	@Test
	public void testDiscardingCards() {
		Player newPlayer = Player.makePlayer();
		Card newCard = Card.makeCard(4);
		Card newCard2 = Card.makeCard(5);
		Card newCard3 = Card.makeCard(4);
		newPlayer.discard(newCard);
		assertFalse(newPlayer.getDiscardPile().contains(newCard3));
		assertTrue(newPlayer.getDiscardPile().contains(newCard));
	}
}
