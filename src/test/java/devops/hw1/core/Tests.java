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
	public void testPlayerBuyCard() {
		Player newPlayer = Player.makePlayer();
		newPlayer.addRunes(10);
		assertTrue(newPlayer.getDiscardSize() == 0);
		assertTrue(newPlayer.buyCard(Card.makeCard(6)));
		assertTrue(newPlayer.getRunes() == 4);
		assertFalse(newPlayer.getDiscardSize() == 0);
		assertTrue(newPlayer.buyCard(Card.makeCard(3)));
		assertTrue(newPlayer.getRunes() == 1);
		assertTrue(newPlayer.getDiscardSize() == 2);
		assertFalse(newPlayer.buyCard(Card.makeCard(9)));
	}
}
