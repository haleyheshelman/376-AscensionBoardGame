/**
 * 
 */
package devops.hw1.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author fenogljc
 * @author gneezyn
 * @author heshelhj
 * @author bishopcc
 */
public class Board {

	private ArrayList<ACard> theVoid;
	private LinkedList<ACard> cenDeck;
	private ACard[] cenField;
	private ACard cultist;
	private ACard heavyInf;
	private ACard mystic;

	/**
	 * The default constructor for the Board Class.
	 * 
	 */
	public Board() {
		try {
			new CardCollection();
		} catch (IOException exception) {
			System.out.println("File not found");
		}
		this.theVoid = new ArrayList<ACard>();
		this.cenDeck = new LinkedList<ACard>();
		this.cenField = new ACard[6];
		
		initializeCenterDeck();
		
		for (int m = 0; m < 6; m++) {
			centerDeckToField(m);
		}
		this.cultist = ACard.makeCard();
		this.heavyInf = ACard.makeCard();
		this.mystic = ACard.makeCard();
	}
	
	private void initializeCenterDeck() {
		for (int i = 0; i < CardCollection.cards.length; i++) {
			for (int j = 0; j < CardCollection.cards[i].rarity; j++) {
				this.cenDeck.add(CardCollection.cards[i]);
			}
		}
		Collections.shuffle(this.cenDeck);
	}

	/**
	 * @return the Void field (where banished cards and defeated Monsters go)
	 */
	public ArrayList<ACard> getVoid() {
		return this.theVoid;
	}

	
	
	/**
	 * @return the Center Deck 
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

	/**
	 * Moves the card from the Center Deck to the Center Field
	 * @param cenCard the card to move
	 * @param index the index on the Center Field that the card is moving to (base zero)
	 */
	public void centerDeckToField(int index) {
		ACard card = this.cenDeck.remove();
		this.cenField[index] = card;
	}
	/**
	 * 
	 * gets the center row
	 *
	 * @return the center cards 
	 */
	public ACard[] getCenField() {
		return this.cenField;
	}
}
