package devops.hw1.core;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Parameterized Tests of some of the Unit Tests (found in Tests.java).
 * 
 * @author gneezyn
 *
 */
@RunWith(Parameterized.class)
public class ParameterizedTestBuyCard {
	
//	private ACard fakeCard = EasyMock.niceMock(ACard.class);
	private Integer cardCost;
	private Integer expectedRunes;
	private Integer expectedDiscSize;
	private Boolean bool;
	private Player player1;

	@Before
    public void initialize() {
      player1 = Player.makePlayer();
      player1.addRunes(10); // start the player off with some runes to use to buy a card (
   }
	
   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in paramNumbers() method (below)
	 /**
	 * @param cardCost the cost of the Card (in Runes)
	 * @param expectedRunes the number of runes expected after calling buyCard
	 * @param expectedDiscardSize the expected size of the player's discard pile after calling buyCard
	 * @param bool indicates whether testing for true or false (as result of calling buyCard)
	 */
	public ParameterizedTestBuyCard(Integer cardCost, 
      Integer expectedRunes, Integer expectedDiscardSize, Boolean bool) {
      this.cardCost = cardCost;
      this.expectedRunes = expectedRunes;
      this.expectedDiscSize = expectedDiscardSize;
      this.bool = bool;
   }

   @Parameterized.Parameters
   public static Collection paramNumbers() {
      return Arrays.asList(new Object[][] {
         { 6, 4, 1, true },
         { 3, 7, 1, true },
         { 11, 10, 0, false }
      });
   }
   
   @Test
   public void testBuyCardParameterized() {
	   ACard card = ACard.makeCard(cardCost);
	   
	   if (bool) {
		   assertTrue(player1.buyCard(card));		   
		   assertTrue(player1.getDiscardPile().contains(card));
	   } else {
		   assertFalse(player1.buyCard(card));
		   assertFalse(player1.getDiscardPile().contains(card));
	   }
	   assertTrue(player1.getRunes() == expectedRunes);
	   assertTrue(player1.getDiscardSize() == expectedDiscSize);
   }

}
