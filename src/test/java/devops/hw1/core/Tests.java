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
}
