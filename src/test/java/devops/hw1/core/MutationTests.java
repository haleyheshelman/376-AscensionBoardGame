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
				
		p.addRunes(3);
		p.addPower(3);
		p.endTurn();
		assertTrue(p.getRunes() == 0);
		assertTrue(p.getPower() == 0);
	}
}
