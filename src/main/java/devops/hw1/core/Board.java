/**
 * 
 */
package devops.hw1.core;

import java.util.ArrayList;
import java.util.Collections;
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
		ACard dumCard = ACard.makeCard();
		for (int i = 0; i < 100; i++) {
			this.cenDeck.add(dumCard);
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
