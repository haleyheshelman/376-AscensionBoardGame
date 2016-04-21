/**
 * 
 */
package devops.hw1.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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

	/**
	 * Tests that a player can draw a card from their deck.
	 */
	@Test
	public void testPlayerDrawCard() {
		Player player1 = Player.makePlayer();
		Player player2 = Player.makePlayer();

		// checking that the player starts with five cards in their deck and
		// hand (individually)
		assertEquals(5, player1.getHandSize());
		assertEquals(5, player1.getDeckSize());
		assertEquals(5, player2.getHandSize());
		assertEquals(5, player2.getDeckSize());

		player1.drawCard();

		// checking that the hand size has increased by 1 and the deck size has
		// decreased by 1
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
		player.drawCard(6);
		assertTrue(player.getHand().contains(card));
	}

	@Test
	public void testPlayerDrawCardwithCard() {
		Player player = Player.makePlayer();
		ACard card = ACard.makeCard();
		player.addCardToDeck(card);
		player.drawCard(6);
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
		player.drawCard(6);
		assertTrue(player.getHandSize() == 11);
		assertFalse(player.getHand().contains(cardInDeck));
		player.playCard(cardInHand);
		assertTrue(player.getHandSize() == 11);
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
		Board newBored = new Board();
		assertFalse(newBored == null);
	}

	/**
	 * Tests whether the void is properly initialized when a new Board is made.
	 */
	@Test
	public void testIsVoidEmpty() {
		Board newBored = new Board();
		assertTrue(newBored.getVoid().isEmpty());
	}

	@Test
	public void testIsDeckCreated() {
		Board newBored = new Board();
		assertFalse(newBored.getCenDeck().isEmpty());
		assertEquals(newBored.getCenDeck().size(), 100);
		assertFalse(newBored.getCenDeck().size() == 101);
	}

	@Test
	public void testCompleteCardMaker() {
		HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
		tempMap.put("draw", 1);
		HeroCard testCard = (HeroCard) ACard.makeCard(
				"Heroes/Arha-Initiate.png", "Arha Initiate", "Enlightened",
				"Hero", 1, 1, 3, tempMap);
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
		Board newBored = new Board();

		// check that cultist is not null
		assertFalse(newBored.getCultist() == null);

		// check that heavy infantry is not null
		assertFalse(newBored.getHeavyInf() == null);

		// check that mystic is not null
		assertFalse(newBored.getMystic() == null);
	}

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

		// no limit to number of cards in hand, so checking that adding several
		// cards in a row works
		newPlayer.addCardToHand(card1);
		newPlayer.addCardToHand(card1);
		newPlayer.addCardToHand(card1);
		// check hand size
		assertEquals(9, newPlayer.getHandSize());

	}

	@Test
	public void testCenterDeckToField() {
		Board newBored = new Board();

		// cards should be added to the Center Field based on indexes [0-5] (6
		// positions)
		for (int i = 0; i < 6; i++) {
			newBored.centerDeckToField(i);
			assertEquals(100 - (i + 1), newBored.getCenDeck().size());
		}
	}

	/**
	 * This tests the getPower function for the player.
	 */
	@Test
	public void testGetPlayerPower() {
		Player player = Player.makePlayer();
		assertEquals(0, player.getPower());
		player.addPower(2);
		assertEquals(2, player.getPower());

		// Tests negative inputs.

		player.addPower(-2);
		assertEquals(0, player.getPower());
	}

	@Test
	public void testApplyEffectsRunes() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("runes", 1);
		ACard runeCard = EasyMock.niceMock(HeroCard.class);
		EasyMock.expect(runeCard.getEffects()).andReturn(map);
		EasyMock.replay(runeCard);

		assertEquals(0, player.getRunes());
		player.applyEffects(runeCard);
		assertEquals(1, player.getRunes());
		EasyMock.verify(runeCard);
	}

	@Test
	public void testApplyEffectsRunesMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("runes", 1);
		ACard runeCard = ACard.makeCard("", "", "", "Hero", 0, 0, 0, map);
		assertEquals(0, player.getRunes());
		player.applyEffects(runeCard);
		assertEquals(1, player.getRunes());
	}

	@Test
	public void testApplyEffectsPower() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("power", 1);
		ACard powerCard = EasyMock.niceMock(HeroCard.class);
		EasyMock.expect(powerCard.getEffects()).andReturn(map);
		EasyMock.replay(powerCard);

		assertEquals(0, player.getPower());
		player.applyEffects(powerCard);
		assertEquals(1, player.getPower());
		EasyMock.verify(powerCard);
	}

	/**
	 * same as above, without mocking
	 */
	@Test
	public void testApplyEffectsPowerMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("power", 1);
		ACard powerCard = ACard.makeCard("", "", "", "Hero", 0, 0, 0, map);
		assertEquals(0, player.getPower());
		player.applyEffects(powerCard);
		assertEquals(1, player.getPower());
	}

	@Test
	public void testApplyEffectsDraw() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("draw", 1);

		ACard drawCard = EasyMock.niceMock(HeroCard.class);
		EasyMock.expect(drawCard.getEffects()).andReturn(map);
		EasyMock.replay(drawCard);

		assertEquals(5, player.getHandSize());
		assertEquals(5, player.getDeckSize());
		player.applyEffects(drawCard);
		assertEquals(6, player.getHandSize());
		assertEquals(4, player.getDeckSize());
		EasyMock.verify(drawCard);
	}

	/**
	 * same as above, without mocking
	 */
	@Test
	public void testApplyEffectsDrawMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("draw", 1);
		ACard drawCard = ACard.makeCard("", "", "", "Hero", 0, 0, 0, map);
		assertEquals(5, player.getHandSize());
		assertEquals(5, player.getDeckSize());
		player.applyEffects(drawCard);
		assertEquals(6, player.getHandSize());
		assertEquals(4, player.getDeckSize());
	}

	@Test
	public void testGetAddHonor() {
		Player player = Player.makePlayer();
		assertEquals(0, player.getHonor());
		player.addHonor(5);
		assertEquals(5, player.getHonor());
	}

	@Test
	public void testApplyEffectsHonor() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("honor", 5);
		ACard honorCard = EasyMock.niceMock(HeroCard.class);
		EasyMock.expect(honorCard.getEffects()).andReturn(map);
		EasyMock.replay(honorCard);

		assertEquals(0, player.getHonor());
		player.applyEffects(honorCard);
		assertEquals(5, player.getHonor());
		EasyMock.verify(honorCard);
	}

	/**
	 * same as above, without mocking
	 */
	@Test
	public void testApplyEffectsHonorMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("honor", 5);
		ACard honorCard = ACard.makeCard("", "", "", "Hero", 0, 0, 0, map);
		assertEquals(0, player.getHonor());
		player.applyEffects(honorCard);
		assertEquals(5, player.getHonor());
	}

	@Test
	public void testApplyEffectsAllBasic() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("honor", 5);
		map.put("runes", 3);
		map.put("draw", 2);
		map.put("power", 4);
		ACard allCard = EasyMock.niceMock(HeroCard.class);
		EasyMock.expect(allCard.getEffects()).andReturn(map);
		EasyMock.replay(allCard);

		assertEquals(0, player.getHonor());
		assertEquals(0, player.getPower());
		assertEquals(0, player.getRunes());
		assertEquals(5, player.getHandSize());
		assertEquals(5, player.getDeckSize());

		player.applyEffects(allCard);
		assertEquals(5, player.getHonor());
		assertEquals(4, player.getPower());
		assertEquals(3, player.getRunes());
		assertEquals(3, player.getDeckSize());
		assertEquals(7, player.getHandSize());
		EasyMock.verify(allCard);
	}

	/**
	 * same as above, without mocking
	 */
	@Test
	public void testApplyEffectsAllBasicMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("honor", 5);
		map.put("runes", 3);
		map.put("draw", 2);
		map.put("power", 4);
		ACard allCard = ACard.makeCard("", "", "", "Hero", 0, 0, 0, map);
		assertEquals(0, player.getHonor());
		assertEquals(0, player.getPower());
		assertEquals(0, player.getRunes());
		assertEquals(5, player.getHandSize());
		assertEquals(5, player.getDeckSize());
		player.applyEffects(allCard);
		assertEquals(5, player.getHonor());
		assertEquals(4, player.getPower());
		assertEquals(3, player.getRunes());
		assertEquals(3, player.getDeckSize());
		assertEquals(7, player.getHandSize());
	}

	@Test
	public void testPlayingRealCardsWithRealEffects() {
		// initialise player
		Player player = Player.makePlayer();
		// check that player has 5 cards
		assertEquals(5, player.getHandSize());
		// keep track of runes and power
		int runesExpected = 0;
		int powerExpected = 0;
		for (int i = 0; i < 5; i++) {
			// get the first card in hand
			ACard card = player.getHand().get(0);
			// do stuff based on the name of the card
			System.out.println(card.getName());
			if (card.getName().equals("Apprentice")) {
				runesExpected++;
				player.playCard(card);
				assertEquals(runesExpected, player.getRunes());
			} else if (card.getName().equals("Militia")) {
				powerExpected++;
				player.playCard(card);
				assertEquals(powerExpected, player.getPower());
			} else {
				fail();
			}
			assertEquals(4 - i, player.getHandSize());
		}
	}

	@Test
	public void testDrawingCardsWithZeroCardsInDeck() {
		Player player = Player.makePlayer();
		player.drawCard(5);
		assertTrue(player.getDeck().isEmpty());
		assertEquals(10, player.getHandSize());
		for (int i = 0; i < 7; i++) {
			player.playCard(player.getHand().get(0));
		}
		assertEquals(7, player.getDiscardSize());
		assertEquals(3, player.getHandSize());
		player.drawCard();
		assertEquals(0, player.getDiscardSize());
		assertEquals(6, player.getDeckSize());
		assertEquals(4, player.getHandSize());
	}

}
