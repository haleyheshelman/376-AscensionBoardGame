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
	private ACard cultist;
	private ACard heavyInf;
	private ACard mystic;

	private Board() {
		this.theVoid = new ArrayList<ACard>();
		this.cenDeck = new LinkedList<ACard>();
		ACard dumCard = ACard.makeCard();
		for (int i = 0; i < 100; i++) {
			this.cenDeck.add(dumCard);
		}
		
		this.cultist = ACard.makeCard();
		this.heavyInf = ACard.makeCard();
		this.mystic = ACard.makeCard();
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

	/**
	 * @return the Cultist (Standard) Card
	 */
	public ACard getCultist() {
		return this.cultist;
	}

	/**
	 * @return the Heavy Infantry (Standard) Card
	 */
	public ACard getHeavyInf() {
		return this.heavyInf;
	}

	/**
	 * @return the Mystic (Standard) Card
	 */
	public ACard getMystic() {
		return this.mystic;
	}
}
