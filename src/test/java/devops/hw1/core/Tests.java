/**
 * 
 */
package devops.hw1.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		assertTrue(i == 0);
	}

	@Test
	public void testPlayerHandSizeWithInput(){
		Player player = Player.makePlayer();
		player.setHandSize(5);
		int i = player.getHandSize();
		assertTrue(i == 5);
	}
	
	 @Test
	 public void testPlayerDrawCard(){
	 Player player = Player.makePlayer();
	 player.drawCard();
	 assertTrue(player.getHandSize()== 1);
	 }
	 
	 @Test
	 public void testPlayerDrawCardWithCardMock() {
		 Player player = Player.makePlayer();
		 
		 ACard card = EasyMock.niceMock(ACard.class);
		 player.addCardToDeck(card);
		 player.drawCard();
		 assertTrue(player.getHand().contains(card));
	 }
	 
	 @Test
	 public void testPlayerDrawCardwithCard(){
		 Player player = Player.makePlayer();
		 ACard card = ACard.makeCard();
		 player.addCardToDeck(card);
		 player.drawCard();
		 assertTrue(player.getHand().contains(card));	 
	 }
	 
	@Test
	public void testSetAndGetEffects() {
		Player player = Player.makePlayer();
		ACard card = HeroCard.makeCard(1);
		card.setEffect("draw", 1);
		player.addCardToDeck(card);
		player.drawCard();
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

}

