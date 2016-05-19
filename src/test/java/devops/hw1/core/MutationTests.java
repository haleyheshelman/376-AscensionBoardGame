package devops.hw1.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
		b.centerDeckToField(2);
		assertTrue(b.getCenField()[2] == card);
		b.sendToVoid(card);
		assertFalse(b.getCenField()[2] == card);
		assertTrue(b.getVoid().contains(card));
	}
}
