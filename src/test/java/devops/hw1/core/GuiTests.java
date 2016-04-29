package devops.hw1.core;

import static org.junit.Assert.*;

import java.awt.Shape;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author gneezyn
 * For testing the GUI.
 *
 */
public class GuiTests {
	
	private ArrayList<Shape> shapeList;
	
	@Before
	public void initialize() {
		this.shapeList = new ArrayList<Shape>();
	}

	/**
	 * Tests that if a null player is given to the CardListener,
	 * then a NullPointerException is thrown.
	 */
	@Test(expected = NullPointerException.class)
	public void testCardListenerNullPlayer() {
		CardListener cL = new CardListener(null, this.shapeList, this.shapeList, new Board());
	}
	
	/**
	 * Tests that if a null board is given to the CardListener,
	 * then a NullPointerException is thrown.
	 */
	@Test(expected = NullPointerException.class)
	public void testCardListenerNullBoard() {
		CardListener cL = new CardListener(Player.makePlayer(), this.shapeList, this.shapeList, null);
	}
	
	/**
	 * Tests that if a null player and Board is given to the CardListener,
	 * then a NullPointerException is thrown.
	 */
	@Test(expected = NullPointerException.class)
	public void testCardListenerNullPlayerBoard() {
		CardListener cL = new CardListener(null, this.shapeList, this.shapeList, null);
	}
	
	/**
	 * Tests the CardListener with various Player hands.
	 * Error checking (with negative, positive and zero; 
	 * for hand size). Introduces setHandSize (just for 
	 * testing purposes).
	 */
	@Test
	public void testCardListenerWithPlayerHand() {
		Player player1 = Player.makePlayer();
		Player player2 = Player.makePlayer();
		
		CardListener cL1 = new CardListener(player1, new ArrayList<Shape>(), new ArrayList<Shape>(), new Board());
		CardListener cL2 = new CardListener(player2, new ArrayList<Shape>(), new ArrayList<Shape>(), new Board());
		
		player1.setHandSize(0);
		
	}

}
