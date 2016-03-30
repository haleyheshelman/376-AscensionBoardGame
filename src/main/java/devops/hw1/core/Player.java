/**
 * 
 */
package devops.hw1.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fenogljc
 *
 */
public class Player {

	private int runes;
	private ArrayList<ACard> discardPile;
	private int handSize;
	private ArrayList<ACard> playerHand;
	private Queue<ACard> playerDeck;

	private Player() {
		discardPile = new ArrayList<ACard>(); 
		playerHand = new ArrayList<ACard>();
		playerDeck = new LinkedList<ACard>();
	}
	
	/**
	 * This constructs and returns a player.
	 * @return
	 */
	public static Player makePlayer() {
		Player newPlayer = new Player();
		return newPlayer;
	}

	/**
	 * This adds the given integer amount of runes to the players current total.
	 * @param i
	 */
	public void addRunes(int i) {
		this.setRunes((i + this.getRunes() > 0) ? this.getRunes() + i : 0);
	}

	/**
	 * This returns the amount of runes the player currently has.
	 * @return the runes
	 */
	public int getRunes() {
		return this.runes;
	}

	/**
	 * Sets the amount of runs the player has to the given integer value.
	 * @param runes the runes to set
	 */
	public void setRunes(int runes) {
		this.runes = runes;
	}

	/**
	 * Returns the size of the player's discard pile.
	 * @return
	 */
	public int getDiscardSize() {
		return this.discardPile.size();
	}

	/**
	 * This puts the card given into the discard pile.
	 * @param card
	 */
	public void discard(ACard card) {
		this.discardPile.add(card);
	}

	/**
	 * Returns the player's discard pile.
	 * @return
	 */
	public ArrayList<ACard> getDiscardPile() {
		return this.discardPile;
	}

	/**
	 * Places the given card into the player's discard pile as well as well as subtracts the amount of
	 * runes the player has available. If you do not have enough runes, this returns false, otherwise true.
	 * @param card
	 * @return
	 */
	public boolean buyCard(ACard card) {
		if (card != null && card.getCost() <= this.runes) {
			this.setRunes(this.runes - card.getCost());
			this.discard(card);
			return true;
		}
		return false;
	}

	public int getHandSize() {
		return this.handSize;
	}

	public void setHandSize(int i) {
		this.handSize = i;

	}

	public void drawCard() {
		ACard fromDeck = playerDeck.poll();
		playerHand.add(fromDeck);
		this.handSize = this.handSize + 1;

	}
	
	public void addCardToDeck(ACard card){
		playerDeck.add(card);
	}
	
	public ArrayList<ACard> getHand(){
		return this.playerHand;
	}
	
		
}
