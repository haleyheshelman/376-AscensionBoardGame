<<<<<<< HEAD
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
		newPlayer.discard(Card.makeCard());
		assertTrue(newPlayer.getDiscardSize() == 1);
		newPlayer.discard(Card.makeCard());
		newPlayer.discard(Card.makeCard());
		assertTrue(newPlayer.getDiscardSize() == 3);
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
	
	@Test
	public void testPlayerBuyCard() {
	Player newPlayer = Player.makePlayer();
	newPlayer.addRunes(10);
	Card card6 = Card.makeCard(6);
	Card card3 = Card.makeCard(3);
	Card card9 = Card.makeCard(9);
	
	assertTrue(newPlayer.buyCard(card6));
	assertTrue(newPlayer.getRunes() == 4);
	assertFalse(newPlayer.getDiscardSize() == 0);
	
	assertTrue(newPlayer.buyCard(card3));
	assertTrue(newPlayer.getRunes() == 1);
	assertTrue(newPlayer.getDiscardSize() == 2);
	
	assertFalse(newPlayer.buyCard(card9));
	assertTrue(newPlayer.getDiscardPile().contains(card6));
	assertTrue(newPlayer.getDiscardPile().contains(card3));
	assertFalse(newPlayer.getDiscardPile().contains(card9));
	
	}
	
	@Test
	public void testPlayerBuyCardInput() {
		Player player1 = Player.makePlayer();
		player1.addRunes(10);
		
		assertFalse(player1.buyCard(null));
		
	}
	
	@Test
	public void testPlayerDiscardInput() {
		Player player = Player.makePlayer();
		player.discard(null);
	}
}
=======
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
		newPlayer.discard(Card.makeCard());
		assertTrue(newPlayer.getDiscardSize() == 1);
		newPlayer.discard(Card.makeCard());
		newPlayer.discard(Card.makeCard());
		assertTrue(newPlayer.getDiscardSize() == 3);
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
	
	@Test
	public void testPlayerBuyCard() {
	Player newPlayer = Player.makePlayer();
	newPlayer.addRunes(10);
	Card card6 = Card.makeCard(6);
	Card card3 = Card.makeCard(3);
	Card card9 = Card.makeCard(9);
	
	assertTrue(newPlayer.buyCard(card6));
	assertTrue(newPlayer.getRunes() == 4);
	assertFalse(newPlayer.getDiscardSize() == 0);
	
	assertTrue(newPlayer.buyCard(card3));
	assertTrue(newPlayer.getRunes() == 1);
	assertTrue(newPlayer.getDiscardSize() == 2);
	
	assertFalse(newPlayer.buyCard(card9));
	assertTrue(newPlayer.getDiscardPile().contains(card6));
	assertTrue(newPlayer.getDiscardPile().contains(card3));
	assertFalse(newPlayer.getDiscardPile().contains(card9));
	
	}
	
	@Test
	public void testPlayerBuyCardInput() {
		Player player1 = Player.makePlayer();
		player1.addRunes(10);
		
		assertFalse(player1.buyCard(null));
		
	}
	
	@Test
	public void testPlayerDiscardInput() {
		Player player = Player.makePlayer();
		player.discard(null);
	}
}
>>>>>>> ddd0d43532a856c81207ac0bda08ad7f87275130
