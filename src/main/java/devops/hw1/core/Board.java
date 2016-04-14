/**
 * 
 */
package devops.hw1.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author fenogljc
 * @author gneezyn
 * 
 */
public class Board {

	private ArrayList<ACard> theVoid;
	private LinkedList<ACard> cenDeck;

	private Board() {
		this.theVoid = new ArrayList<ACard>();
		this.cenDeck = new LinkedList<ACard>();
		HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
		tempMap.put("draw", 1);
		HeroCard initiateCard = (HeroCard) ACard.makeCard(
				"Heroes/Arha-Initiate.png", "Arha Initiate", "Enlightened",
				"Hero", 1, 1, 3, tempMap);
		for (int i = 0; i < 100; i++) {
			this.cenDeck.add(initiateCard);
		}
	}

	public static Board makeBoard() {
		return new Board();
	}

	/**
	 * @return
	 */
	public ArrayList<ACard> getVoid() {
		return this.theVoid;
	}

	/**
	 * @return
	 */
	public LinkedList<ACard> getCenDeck() {
		return this.cenDeck;
	}
}
