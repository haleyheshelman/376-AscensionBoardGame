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
	public void boardMutation(){
		Board b = new Board();
		ACard card = b.getCenDeck().peek();
		b.centerDeckToField(0);
		assertTrue(b.getCenField()[0] == card);
		b.sendToVoid(card);
		assertFalse(b.getCenField()[0] == card);
		assertTrue(b.getVoid().contains(card));
	}
	
	@Test
	public void playerMutation(){
		Player p = Player.makePlayer();
				
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
		p.applyEffects(banishCard);
		assertTrue(p.getBanishLocation() == 1);
		
		p.endTurn();
		Board b = new Board();
		ACard hero = CardCollection.arhaInitiate;
		ACard monster = CardCollection.avatarOfTheFallen;
		b.getCenField()[0] = hero;
		b.getCenField()[1] = monster;
		assertFalse(p.doCard(hero, b));
		assertFalse(p.doCard(monster, b));	
		
	}
}
