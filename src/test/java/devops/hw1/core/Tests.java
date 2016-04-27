/**
 * 
 */
package devops.hw1.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.easymock.EasyMock;
import org.junit.Test;

/**
 * @author fenogljc, gneezyn, bishopcc, heshelhj
 * 
 */
public class Tests {

	/**
	 * Tests that a card can be made.
	 */
	@Test
	public void testMakeCard() {
		ACard newCard = ACard.makeCard();
		assertTrue(newCard instanceof ACard);
	}

	/**
	 * Tests that you can get a card's cost 
	 * (when it is specified by the constructor).
	 */
	@Test
	public void testGetCardCost() {
		ACard newCard = ACard.makeCard(2);
		assertTrue(newCard.getCost() == 2);
	}

	/**
	 * Tests that when the default constructor
	 * is used, the card's default cost is zero.
	 */
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

	//This test is unnecessary since a more thorough one already exists (see tesPlayerAddRunes()). 
//	/**
//	 * Tests that the player can have runes added (addRunes method).
//	 */
//	@Test
//	public void testPlayerHasRunes() {
//		Player newPlayer = Player.makePlayer();
//		newPlayer.addRunes(3);
//		assertTrue(newPlayer.getRunes() == 3);
//	}

	/**
	 * Tests that the player can have runes added by calling 
	 * the addRunes method. Also checks that the player starts
	 * with no runes.
	 */
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

	/**
	 * Integration test equivalent of testPlayerDiscard.
	 * Tests that the discard method works through the 
	 * use of Mocking.
	 */
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

	/**
	 * Tests that the player can discard pile works appropriately.
	 * This includes checking that cards can be added to the 
	 * discard pile and making sure that the size of the discard
	 * pile is actually increasing.
	 */
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

	/**
	 * Integration test equivalent of testDiscardingCards().
	 * Tests that the discard method actually puts the card(s)
	 * in the discard pile through the use of Mocking.
	 */
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

	/**
	 * Tests that discard actually puts the cards in the 
	 * discard pile and that the hand doesn't have the card.
	 */
	@Test
	public void testDiscardingCards() {
		Player newPlayer = Player.makePlayer();
		ACard newCard = ACard.makeCard(4);
		ACard newCard3 = ACard.makeCard(4);
		newPlayer.discard(newCard);
		assertFalse(newPlayer.getDiscardPile().contains(newCard3));
		assertTrue(newPlayer.getDiscardPile().contains(newCard));
	}

	/**
	 * Tests that a player can "buy" a card from the center
	 * field, if the player has enough runes.
	 */
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

	/**
	 * Error checking for buyCard (method of Player).
	 */
	@Test
	public void testPlayerBuyCardInput() {
		Player player1 = Player.makePlayer();
		player1.addRunes(10);

		assertFalse(player1.buyCard(null));

	}

	/**
	 * Error checking for discard (method of Player).
	 */
	@Test
	public void testPlayerDiscardInput() {
		Player player = Player.makePlayer();
		player.discard(null);
	}

	/**
	 * Testing that the player starts out with 
	 * five cards in their hand.
	 */
	@Test
	public void testPlayerHandSize() {
		Player player = Player.makePlayer();
		int i = player.getHandSize();
		assertTrue(i == 5);
	}

	/**
	 * Tests that a player can draw a card from their deck.
	 * Checks that the player's hand and deck both start
	 * with five cards. Also checks that drawing a card
	 * both increases the size of the player's hand and 
	 * decreases the size of their deck (by one).
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
	 * Integration test equivalent of testPlayerDrawCardWithCard().
	 * Tests that the player can draw a card from their deck and 
	 * that the card is in the player's hand through the use of Mocking.
	 */
	@Test
	public void testPlayerDrawCardWithCardMock() {
		Player player = Player.makePlayer();

		ACard card = EasyMock.niceMock(ACard.class);
		player.addCardToDeck(card);
		player.drawCard(6);
		assertTrue(player.getHand().contains(card));
	}

	/**
	 * Tests that the player can draw a card from their deck.
	 * And checks that the player's hand actually contains
	 * the card that was added.
	 */
	@Test
	public void testPlayerDrawCardWithCard() {
		Player player = Player.makePlayer();
		ACard card = ACard.makeCard();
		player.addCardToDeck(card);
		player.drawCard(6);
		assertTrue(player.getHand().contains(card));
	}

	/**
	 * Tests that you can set and get the effects of 
	 * different cards (only checks Hero Cards).
	 */
	@Test
	public void testSetAndGetEffects() {
		ACard card = HeroCard.makeCard(1);
		card.setEffect("draw", 1);
		assertTrue(card.getEffects().containsKey("draw"));
	}

	/**
	 * Tests that the player can draw a card due to the 
	 * effect of a card that the player used.
	 */
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

	/**
	 * Tests that after a card is played, it goes to that
	 * player's discard pile (exception: Constructs aren't
	 * implemented yet and will be tested later).
	 */
	@Test
	public void testCardGoesToDiscardAfterPlaying() {
		Player player = Player.makePlayer();
		ACard card = HeroCard.makeCard();
		player.addCardToDeck(card);
		player.drawCard();
		player.playCard(card);
		assertTrue(player.getDiscardPile().contains(card));
	}

	/**
	 * Tests that a card can have more than one effect.
	 */
	@Test
	public void testSetEffects() {
		ACard card = HeroCard.makeCard();
		card.setEffect("draw", 2);
		card.setEffect("runes", 1);
		assertTrue(card.getEffects().get("draw") == 2);
		assertTrue(card.getEffects().get("runes") == 1);
	}

	/**
	 * Tests that when a card is played, it's effect(s)
	 * take place.
	 */
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

	/**
	 * Error checking for setEffect (method of ACard).
	 */
	@Test
	public void testSetEffectInput() {
		ACard card = ACard.makeCard();
		card.setEffect(null, 1);
	}

	/**
	 * Error checking for playCard (method of ACard).
	 */
	@Test
	public void testPlayCardInput() {
		Player p = Player.makePlayer();
		p.playCard(null);
	}

	// We do not want to allow input of null to the addCardToDeck()

	/**
	 * Error checking for addCardToDeck (method of Player).
	 */
	@Test
	public void testAddCardToDeckInput() {
		Player p = Player.makePlayer();
		p.addCardToDeck(null);
	}

	/**
	 * Tests the Board's (class) default constructor. Checks
	 * that the Board is not null.
	 */
	@Test
	public void testConstructBoard() {
		Board newBored = new Board();
		assertFalse(newBored == null);
	}

	/**
	 * Tests that the Void is properly initialized (starts empty) 
	 * when a new Board is made.
	 */
	@Test
	public void testIsVoidEmpty() {
		Board newBored = new Board();
		assertTrue(newBored.getVoid().isEmpty());
	}

	/**
	 * Tests that the Center Deck is properly initialized (starts 
	 * with 100 cards).
	 */
	@Test
	public void testIsDeckCreated() {
		Board newBored = new Board();
		assertFalse(newBored.getCenDeck().isEmpty());
		assertEquals(100, newBored.getCenDeck().size());
		assertFalse(newBored.getCenDeck().size() == 101);
	}

	/**
	 * Tests that distinct cards can be made and that the cards
	 * have the correct information.
	 */
	@Test
	public void testCompleteCardMaker() {
		HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
		tempMap.put("draw", 1);
			
		HeroCard testCard = (HeroCard) ACard.makeCard(
				null, "Arha Initiate", "Enlightened",
				"Hero", 1, 1, 3, tempMap);
		assertTrue(testCard.getFaction() == "Enlightened");
		assertTrue(testCard.getEffects().containsKey("draw"));
		assertTrue(testCard.getEffects().get("draw") == 1);
		assertTrue(testCard.getName() == "Arha Initiate");
		assertTrue(testCard.getHonor() == 1);
		assertTrue(testCard.getRarity() == 3);
	}

	/**
	 * Tests that Standard Cards. Checks that the standard cards
	 * are properly initialized when the Board is created.
	 */
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
	 * Tests that cards can be added to the player's hand (doesn't
	 * worry about where the cards are coming from).
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

	/**
	 * Tests that cards can be moved from the Center Deck to the 
	 * field.
	 */
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
	 * Tests that the player can have power added by calling 
	 * the getPower method. Also checks that the player starts
	 * with no power and that the player never has negative power.
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

	/**
	 * Integration test equivalent of testApplyEffectsRunesMockless().
	 * Tests that applyEffects method (from Player) works for "runes" 
	 * through the use of Mocking.
	 */
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

	/**
	 * Tests that applying the effect of a card leads to the 
	 * effect taking place (only tested with "runes" effect).
	 */
	@Test
	public void testApplyEffectsRunesMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("runes", 1);
		ACard runeCard = ACard.makeCard(null, "", "", "Hero", 0, 0, 0, map);
		assertEquals(0, player.getRunes());
		player.applyEffects(runeCard);
		assertEquals(1, player.getRunes());
	}

	/**
	 * Integration test equivalent of testApplyEffectsRunesMockless().
	 * Tests that applyEffects method (from Player) works for "power" 
	 * through the use of Mocking.
	 */
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
	 * Tests that applying the effect of a card leads to the 
	 * effect taking place (only tested with "power" effect).
	 */
	@Test
	public void testApplyEffectsPowerMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("power", 1);
		ACard powerCard = ACard.makeCard(null, "", "", "Hero", 0, 0, 0, map);
		assertEquals(0, player.getPower());
		player.applyEffects(powerCard);
		assertEquals(1, player.getPower());
	}

	/**
	 * Integration test equivalent of testApplyEffectsRunesMockless().
	 * Tests that applyEffects method (from Player) works for "draw" 
	 * through the use of Mocking.
	 */
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
	 * Tests that applying the effect of a card leads to the 
	 * effect taking place (only tested with "draw" effect).
	 */
	@Test
	public void testApplyEffectsDrawMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("draw", 1);
		ACard drawCard = ACard.makeCard(null, "", "", "Hero", 0, 0, 0, map);
		assertEquals(5, player.getHandSize());
		assertEquals(5, player.getDeckSize());
		player.applyEffects(drawCard);
		assertEquals(6, player.getHandSize());
		assertEquals(4, player.getDeckSize());
	}

	/**
	 * Tests the addHonor method (of Player). Checks that the
	 * player can have honor added to his/her honor pile and that
	 * the player starts out with no honor.
	 */
	@Test
	public void testGetAddHonor() {
		Player player = Player.makePlayer();
		assertEquals(0, player.getHonor());
		player.addHonor(5);
		assertEquals(5, player.getHonor());
	}

	/**
	 * Integration test equivalent of testApplyEffectsRunesMockless().
	 * Tests that applyEffects method (from Player) works for "honor" 
	 * through the use of Mocking.
	 */
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
	 * Tests that applying the effect of a card leads to the 
	 * effect taking place (only tested with "honor" effect).
	 */
	@Test
	public void testApplyEffectsHonorMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("honor", 5);
		ACard honorCard = ACard.makeCard(null, "", "", "Hero", 0, 0, 0, map);
		assertEquals(0, player.getHonor());
		player.applyEffects(honorCard);
		assertEquals(5, player.getHonor());
	}

	/**
	 * Integration test equivalent of testApplyEffectsAllBasicMockless().
	 * Tests that when a card has more than one effect, all of the 
	 * effects are applied properly.
	 */
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
	 * Tests (for all of the basic effects) that a card can have
	 * more than one effect and that when the card's effect(s) 
	 * are applied, they produce the correct results.
	 */
	@Test
	public void testApplyEffectsAllBasicMockless() {
		Player player = Player.makePlayer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("honor", 5);
		map.put("runes", 3);
		map.put("draw", 2);
		map.put("power", 4);
		ACard allCard = ACard.makeCard(null, "", "", "Hero", 0, 0, 0, map);
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

	/**
	 * Tests that the proper effects take place when a card 
	 * is played. Uses real cards (i.e. "Apprentice").
	 */
	@Test
	public void testPlayingRealCardsWithRealEffects() {
		// initialise player
		Player player = Player.makePlayer();
		System.out.println(player.getHand().get(0).name);
		// check that player has 5 cards
		assertEquals(5, player.getHandSize());
		// keep track of runes and power
		int runesExpected = 0;
		int powerExpected = 0;
		for (int i = 0; i < 5; i++) {
			// get the first card in hand
			ACard card = player.getHand().get(0);
			// do stuff based on the name of the card
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

	/**
	 * Tests that when a player tries to draw from their 
	 * deck when it is empty, the player's discard pile is
	 * shuffled and becomes the new deck. Also makes sure 
	 * that the size of the deck never becomes negative.
	 */
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
	
	/**
	 * Tests that the Center Field properly initializes when
	 * a Board is made.
	 */
	@Test
	public void testGetCen() {
		Board board = new Board();
		assertFalse(board.getCenField() == null);
	}
	
	
	/**
	 * Tests monster class
	 */
	@Test
	public void testMonster(){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("draw", 1);
		ACard m = ACard.makeCard(null, "Name", null, "Monster", 4, 3, 2, map);
		assertEquals(4, m.getStrength());
		
	}

}
