/**
 * 
 */
package devops.hw1.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.easymock.EasyMock;
import org.junit.Test;

/**
 * @author fenogljc
 * 
 */
public class Tests {

	@Test
	public void testMakeCard() {
		ACard newCard = ACard.makeCard();
		assertTrue(newCard instanceof ACard);
	}

	@Test
	public void testGetCardCost() {
		ACard newCard = ACard.makeCard(2);
		assertTrue(newCard.getCost() == 2);
	}

	@Test
	public void testGetDefaultCardCost() {
		ACard newCard = ACard.makeCard();
		assertTrue(newCard.getCost() == 0);
	}

	/**
	 * Tests that a player is properly initialized.
	 */
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
	public void testPlayerDiscardMock() {
		Player newPlayer = Player.makePlayer();

		ACard card1 = EasyMock.niceMock(ACard.class);
		ACard card2 = EasyMock.niceMock(ACard.class);
		ACard card3 = EasyMock.niceMock(ACard.class);

		assertTrue(newPlayer.getDiscardSize() == 0);
		newPlayer.discard(card1);
		assertTrue(newPlayer.getDiscardSize() == 1);
		newPlayer.discard(card2);
		newPlayer.discard(card3);
		assertTrue(newPlayer.getDiscardSize() == 3);

	}

	@Test
	public void testPlayerDiscard() {
		Player newPlayer = Player.makePlayer();
		assertTrue(newPlayer.getDiscardSize() == 0);
		newPlayer.discard(ACard.makeCard());
		assertTrue(newPlayer.getDiscardSize() == 1);
		newPlayer.discard(ACard.makeCard());
		newPlayer.discard(ACard.makeCard());
		assertTrue(newPlayer.getDiscardSize() == 3);
	}

	@Test
	public void testDiscardingCardsMock() {
		Player newPlayer = Player.makePlayer();
		ACard card1 = EasyMock.niceMock(ACard.class);
		ACard card2 = EasyMock.niceMock(ACard.class);
		ACard card3 = EasyMock.niceMock(ACard.class);

		newPlayer.discard(card1);
		assertFalse(newPlayer.getDiscardPile().contains(card2));
		assertFalse(newPlayer.getDiscardPile().contains(card3));
		assertTrue(newPlayer.getDiscardPile().contains(card1));
	}

	@Test
	public void testDiscardingCards() {
		Player newPlayer = Player.makePlayer();
		ACard newCard = ACard.makeCard(4);
		ACard newCard2 = ACard.makeCard(5);
		ACard newCard3 = ACard.makeCard(4);
		newPlayer.discard(newCard);
		assertFalse(newPlayer.getDiscardPile().contains(newCard3));
		assertTrue(newPlayer.getDiscardPile().contains(newCard));
	}

	@Test
	public void testPlayerBuyCard() {
		Player newPlayer = Player.makePlayer();
		newPlayer.addRunes(10);
		ACard card6 = ACard.makeCard(6);
		ACard card3 = ACard.makeCard(3);
		ACard card9 = ACard.makeCard(9);

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

	@Test
	public void testPlayerHandSize() {
		Player player = Player.makePlayer();
		int i = player.getHandSize();
		assertTrue(i == 5);
	}

	@Test
	public void testPlayerHandSizeWithInput() {
		Player player = Player.makePlayer();
		player.setHandSize(5);
		int i = player.getHandSize();
		assertTrue(i == 5);
	}

	/**
	 * Tests that a player can draw a card from their deck.
	 */
	@Test
	public void testPlayerDrawCard() {
		Player player1 = Player.makePlayer();
		Player player2 = Player.makePlayer();
		
		// checking that the player starts with five cards in their deck and hand (individually)
		assertEquals(5, player1.getHandSize());
		assertEquals(5, player1.getDeckSize());
		assertEquals(5, player2.getHandSize());
		assertEquals(5, player2.getDeckSize());
		
		player1.drawCard();
		
		// checking that the hand size has increased by 1 and the deck size has decreased by 1
		assertTrue(player1.getHandSize() == 6);
		assertEquals(4, player1.getDeckSize());
		
		// checking that player1 is not the same as player2
		assertFalse(player1.equals(player2));
	}

	/**
	 * Tests (with Mocking) that the player can draw a card from their deck.
	 */
	@Test
	public void testPlayerDrawCardWithCardMock() {
		Player player = Player.makePlayer();

		ACard card = EasyMock.niceMock(ACard.class);
		player.addCardToDeck(card);
		player.drawCard();
		assertTrue(player.getHand().contains(card));
	}

	@Test
	public void testPlayerDrawCardwithCard() {
		Player player = Player.makePlayer();
		ACard card = ACard.makeCard();
		player.addCardToDeck(card);
		player.drawCard();
		assertTrue(player.getHand().contains(card));
	}

	@Test
	public void testSetAndGetEffects() {
		ACard card = HeroCard.makeCard(1);
		card.setEffect("draw", 1);
		assertTrue(card.getEffects().containsKey("draw"));
	}

	@Test
	public void testDrawACardAfterPlayingCard() {
		Player player = Player.makePlayer();
		ACard cardInHand = HeroCard.makeCard(3);
		cardInHand.setEffect("draw", 1);
		ACard cardInDeck = HeroCard.makeCard(3);
		player.addCardToDeck(cardInHand);
		player.addCardToDeck(cardInDeck);
		player.drawCard();
		assertTrue(player.getHandSize() == 1);
		assertFalse(player.getHand().contains(cardInDeck));
		player.playCard(cardInHand);
		assertTrue(player.getHandSize() == 2);
		assertTrue(player.getHand().contains(cardInDeck));
	}

	@Test
	public void testCardGoesToDiscardAfterPlaying() {
		Player player = Player.makePlayer();
		ACard card = HeroCard.makeCard();
		player.addCardToDeck(card);
		player.drawCard();
		player.playCard(card);
		assertTrue(player.getDiscardPile().contains(card));
	}

	@Test
	public void testSetEffects() {
		ACard card = HeroCard.makeCard();
		card.setEffect("draw", 2);
		card.setEffect("runes", 1);
		assertTrue(card.getEffects().get("draw") == 2);
		assertTrue(card.getEffects().get("runes") == 1);
	}

	@Test
	public void testPlayCardAddingRunes() {
		Player player = Player.makePlayer();
		ACard card = HeroCard.makeCard();
		card.setEffect("runes", 3);
		player.addCardToDeck(card);
		player.drawCard();
		player.playCard(card);
		assertTrue(player.getRunes() == 3);
	}

	// We do not want to allow input of null to the setEffect()

	@Test
	public void testSetEffectInput() {
		ACard card = ACard.makeCard();
		card.setEffect(null, 1);
	}

	@Test
	public void testPlayCardInput() {
		Player p = Player.makePlayer();
		p.playCard(null);
	}

	// We do not want to allow input of null to the addCardToDeck()

	@Test
	public void testAddCardToDeckInput() {
		Player p = Player.makePlayer();
		p.addCardToDeck(null);
	}

	@Test
	public void testConstructBoard() {
		Board newBored = Board.makeBoard();
		assertFalse(newBored == null);
	}

	/**
	 * Tests whether the void is properly initialized when a new Board is made.
	 */
	@Test
	public void testIsVoidEmpty() {
		Board newBored = Board.makeBoard();
		assertTrue(newBored.getVoid().isEmpty());
	}

	@Test
	public void testIsDeckCreated() {
		Board newBored = Board.makeBoard();
		assertFalse(newBored.getCenDeck().isEmpty());
		assertEquals(newBored.getCenDeck().size(), 100);
		assertFalse(newBored.getCenDeck().size() == 101);
	}

	@Test
	public void testCompleteCardMaker() {
		HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
		tempMap.put("draw", 1);
		HeroCard testCard = (HeroCard) ACard.makeCard(
				"Heroes/Arha-Initiate.png",
				"Arha Initiate", "Enlightened", "Hero", 1, 1, 3, tempMap);
		assertTrue(testCard.getFaction() == "Enlightened");
		assertTrue(testCard.getEffects().containsKey("draw"));
		assertTrue(testCard.getEffects().get("draw") == 1);
		assertTrue(testCard.getName() == "Arha Initiate");
		assertTrue(testCard.getHonor() == 1);
		assertTrue(testCard.getRarity() == 3);
	}

	
	@Test
	public void testStandardCards() {
		// initialize the game board
		Board newBored = Board.makeBoard();
		
		// check that cultist is not null 
		assertFalse(newBored.getCultist() == null);
		
		// check that heavy infantry is not null
		assertFalse(newBored.getHeavyInf() == null);
		
		// check that mystic is not null
		assertFalse(newBored.getMystic() == null);
	}
	
//	@Test
//	public void testPlayerDeckAndHandWithMock() {
//		// initialize the Player Objects
//		Player newPlayer1 = Player.makePlayer();
//		Player newPlayer2 = Player.makePlayer();
//
//		// check that player deck has five cards (and is not null) and player hand has five cards (do for each player)
//		assertFalse(newPlayer1.getDeck() == null);
//		assertEquals(5, newPlayer1.getHandSize());
//		assertEquals(5, newPlayer1.getDeckSize());
//		
//		assertFalse(newPlayer2.getDeck() == null);
//		assertEquals(5, newPlayer2.getHandSize());
//		assertEquals(5, newPlayer2.getDeckSize());
//		
//		// check that player1 is not equal to player 2 (object-wise)
//		assertFalse(newPlayer1.equals(newPlayer2));
//	}
	
	/**
	 * Tests that cards can be added to the player's hand
	 */
	@Test
	public void testAddCardToHand() {
		// initialize the Player Object
		Player newPlayer = Player.makePlayer();
		
		// using mock to create a "fake" card
		ACard card1 = EasyMock.niceMock(ACard.class);
		
		// check that adding null card does not increase the hand size
		newPlayer.addCardToHand(null);
		assertEquals(5, newPlayer.getHandSize());
		
		// adding single card to hand
		newPlayer.addCardToHand(card1);
		
		// check that the size of the hand is now equal to one
		assertEquals(6, newPlayer.getHandSize());
		
		// no limit to number of cards in hand, so checking that adding several cards in a row works
		newPlayer.addCardToHand(card1);
		newPlayer.addCardToHand(card1);
		newPlayer.addCardToHand(card1);
		// check hand size
		assertEquals(9, newPlayer.getHandSize());
		
	}
	
	@Test
	public void testCenterDeckToField() {
		Board newBored = Board.makeBoard();
		
		// cards should be added to the Center Field based on indexes [0-5] (6 positions)
		for (int i = 0; i < 6; i++) {
			newBored.centerDeckToField(i);
			assertEquals(100 - (i + 1), newBored.getCenDeck().size());
		}
	}
}
