/**
 * 
 */
package devops.hw1.core;

import static org.junit.Assert.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

/**
 * @author fenogljc
 *
 */
public class TestCard {

	@Test
	public void testMakeCard() {
		Card newCard = Card.makeCard();
		assertTrue(newCard instanceof Card);
	}

}
