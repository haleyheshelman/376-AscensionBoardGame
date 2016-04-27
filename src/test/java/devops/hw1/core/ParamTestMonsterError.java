package devops.hw1.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParamTestMonsterError {

	private String name;
	private String type;
	private int cost;
	private int honor;
	private int rarity;
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	private ACard card;

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in paramNumbers() method (below)
	public ParamTestMonsterError(String name, String type, 
			int cost, int honor, int rarity,
			String effectString, Integer effectInt, 
			Exception expectedError) {
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.honor = honor;
		this.rarity = rarity;
		this.map.put(effectString, effectInt);
		//		this.errorType = errorType;
   }

   @Parameterized.Parameters
   public static Collection cardNumbers() {
	  ArrayList<Exception> exceptionsList = new ArrayList<Exception>();
	  exceptionsList.add(new IllegalArgumentException("One or more of the arguments given for the card "
				+ "were not correct."));
	  exceptionsList.add(new NullPointerException("The following values can not be null for a card: "
				+ "name, type, cost, honor, rarity, and effect."));
	  
	  return Arrays.asList(new Object[][] {
         { "Somebody", "Moonster", 4, 3, 2, "draw", 1, exceptionsList.get(0)},	//case 0: tests for invalid type, should throw 
         																						//an IllegalArgumentException
         { null, "Monster", 1, 3, 2, "honor", 3, exceptionsList.get(1)},	//case 1: tests for null values, should throw
         																						//a NullPointerException
         { "Nobody", "Monster", 4, 3, 2, "", 0, exceptionsList.get(0)},		//case 2: tests that a card has an effect (all cards do),
         																			//should throw an IllegalArgumentException
         { "Just Me", "Monster", 2, 2, 1, null, 2, exceptionsList.get(1)},	//case 3: tests that effect is not null,
         																			//should throw a NullPointerException
         { "Whoever's Left", null, 3, 4, 7, "honor", 6, exceptionsList.get(1)},	//case 4: tests for null values (similar to case 2)
         																			//should throw a NullPointerException
         { "Anybody", "Monster", 1, 4, 5, "draw", 0, exceptionsList.get(0)}		//case 5: tests for zero in the effects
         																			//should throw an IllegalArgumentException
      });
   }
   
   @Test(expected = Exception.class)
   public void testBuyCardParameterized() {
	   this.card = ACard.makeCard(null, name, null, type, cost, honor, rarity, map);
   }

}
