package devops.hw1.core;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.easymock.EasyMock;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParameterizedTests {
	
	private ACard fakeCard = EasyMock.niceMock(ACard.class);
	private Integer inputNumber;
	private Boolean expectedResult;
	private Player player1;

	@Before
    public void initialize() {
      player1 = Player.makePlayer();
      player1.addRunes(3); // start the player off with some runes to use to buy a card
   }

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in paramNumbers() method (below)
   public ParameterizedTests(Integer cardCost, 
      Boolean expectedResult) {
      this.inputNumber = inputNumber;
      this.expectedResult = expectedResult;
   }

   @Parameterized.Parameters
   public static Collection paramNumbers() {
      return Arrays.asList(new Object[][] {
         { 2, true },
         { 6, false },
         { 3, true },
         { 4, false }
      });
   }
   
   @Test
   public void testBuyCardParameterized() {
	   System.out.println("Parameterized Number is: " + inputNumber);
	   assertEquals(expectedResult, player1.buyCard(fakeCard));
//	   assertTrue(expectedResult == player1.getPower());
   }

}
