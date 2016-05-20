package devops.hw1.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.junit.Test;

/**
 * @author fenogljc
 *
 */
public class MutationTests {

	@Test
	public void boardMutation() {
		Board b = new Board();
		ACard card = b.getCenDeck().peek();
		b.centerDeckToField(0);
		assertTrue(b.getCenField()[0] == card);
		b.sendToVoid(card);
		assertFalse(b.getCenField()[0] == card);
		assertTrue(b.getVoid().contains(card));
	}

	@Test
	public void playerMutation() {
		Player p = Player.makePlayer();
		Board b = new Board();

		p.addRunes(1);
		p.addPower(3);
		p.endTurn();
		assertTrue(p.getRunes() == 0);
		assertTrue(p.getPower() == 0);

		ACard fakeEffectCard = ACard.makeCard();
		fakeEffectCard.setEffect("fake effect", 99);
		assertFalse(p.applyEffects(fakeEffectCard));
		ACard blankCard = ACard.makeCard();
		assertTrue(p.applyEffects(blankCard));

		ACard banishCard = ACard.makeCard();
		banishCard.setEffect("banish", 1);
		ACard apprentice = CardCollection.apprentice;
		p.applyEffects(banishCard);
		assertTrue(p.getBanishLocation() == 1);
		p.addCardToHand(apprentice);
		p.banishCard(apprentice, b);
		assertFalse(p.getHand().contains(apprentice));
		assertTrue(b.getVoid().contains(apprentice));
		assertEquals(p.getBanishLocation(), 0);

		p.applyEffects(CardCollection.mephit);
		ACard coolCard = b.getCenField()[1];
		p.addCardToHand(coolCard);
		ArrayList<ACard> hand = (ArrayList<ACard>) p.getHand().clone();
		p.banishCard(coolCard, b);
		assertEquals(hand, p.getHand()); //assert that the hand hasn't changed

		p.endTurn();
		ACard hero = CardCollection.arhaInitiate;
		ACard monster = CardCollection.avatarOfTheFallen;
		b.getCenField()[0] = hero;
		b.getCenField()[1] = monster;
		assertFalse(p.doCard(hero, b));
		assertFalse(p.doCard(monster, b));

	}

	@Test
	public void cardMutation() {
		ACard card = ACard.makeCard();
		Player p = Player.makePlayer();
		Board b = new Board();

		card = CardCollection.burrowerMarkII;
		p.playCard(card);
		assertTrue(p.getConstructs().contains(card));

		assertEquals(card.getTimesActivated(), 0);
		p.applyEffects(card);
		assertEquals(card.getTimesActivated(), 1);
		assertFalse(p.applyEffects(card));
		p.endTurn();
		assertEquals(card.getTimesActivated(), 0);

		p.discardConstruct(card);
		assertTrue(p.getConstructs().isEmpty());
		assertTrue(p.getDiscardPile().contains(card));

	}
}
