package devops.hw1.core;

import static org.junit.Assert.*;

import java.awt.Shape;
import java.util.ArrayList;

import org.junit.Test;

/**
 * @author gneezyn
 * For testing the GUI.
 *
 */
public class GuiTests {

	/**
	 * Tests that if a null player is given to the CardListener,
	 * then a NullPointerException is thrown.
	 */
	@Test(expected = NullPointerException.class)
	public void testCardListenerNullPlayer() {
		CardListener cL = new CardListener(null, new ArrayList<Shape>(), new ArrayList<Shape>(), new Board());
	}
	
	/**
	 * Tests that if a null board is given to the CardListener,
	 * then a NullPointerException is thrown.
	 */
	@Test(expected = NullPointerException.class)
	public void testCardListenerNullBoard() {
		CardListener cL = new CardListener(Player.makePlayer(), new ArrayList<Shape>(), new ArrayList<Shape>(), null);
	}
	
	/**
	 * Tests that if a null player and Board is given to the CardListener,
	 * then a NullPointerException is thrown.
	 */
	@Test(expected = NullPointerException.class)
	public void testCardListenerNullPlayerBoard() {
		CardListener cL = new CardListener(null, new ArrayList<Shape>(), new ArrayList<Shape>(), null);
	}

}
