package devops.hw1.core;

import static org.junit.Assert.*;

import java.awt.Shape;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author gneezyn For testing the GUI.
 *
 */
public class GuiTests {

	private ArrayList<Shape> shapeList;

	@Before
	public void initialize() {
		this.shapeList = new ArrayList<Shape>();
	}

	/**
	 * Tests that if a null player is given to the CardListener, then a
	 * NullPointerException is thrown.
	 */
	@Test(expected = NullPointerException.class)
	public void testCardListenerNullPlayer() {
		CardListener cL = new CardListener(null, this.shapeList,
				this.shapeList, new Board());
	}

	/**
	 * Tests that if a null board is given to the CardListener, then a
	 * NullPointerException is thrown.
	 */
	@Test(expected = NullPointerException.class)
	public void testCardListenerNullBoard() {
		CardListener cL = new CardListener(Player.makePlayer(), this.shapeList,
				this.shapeList, null);
	}

	/**
	 * Tests that if a null player and Board is given to the CardListener, then
	 * a NullPointerException is thrown.
	 */
	@Test(expected = NullPointerException.class)
	public void testCardListenerNullPlayerBoard() {
		CardListener cL = new CardListener(null, this.shapeList,
				this.shapeList, null);
	}
	
	/**
	 * Checks that the CardListener constructor still works properly.
	 */
	@Test
	public void testCardListenerWorks() {
		Player player = Player.makePlayer();
		Board board = new Board();
		CardListener cL = new CardListener(player, this.shapeList, this.shapeList, board);
	}
	
	/**
	 * Checks that the player hand size is handled correctly
	 * within the CardListener class.
	 */
	@Test
	public void testPlayerHandSizeInCardListener() {
		Player player = Player.makePlayer();
		Board board = new Board();
		
		assertEquals(5, player.getHandSize());
		for (int i = 0; i < 5; i++) {	// get to hand size = 0
			ACard card = player.getHand().get(0);
			player.playCard(card);	
		}
		assertEquals(0, player.getHandSize());
		
		//checking that creating card listener doesn't throw an exception
		CardListener cL1 = new CardListener(player, this.shapeList, this.shapeList, board);
		
		//now checking that hand size hasn't changed
		assertEquals(0, player.getHandSize());
	}

}
