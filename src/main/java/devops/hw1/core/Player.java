/**
 * 
 */
package devops.hw1.core;

import java.util.ArrayList;

/**
 * @author fenogljc
 *
 */
public class Player {

	private int runes;
	private ArrayList<Card> discardPile;

	private Player() {
		discardPile = new ArrayList<Card>(); 
	}
	
	/**
	 * @return
	 */
	public static Player makePlayer() {
		Player newPlayer = new Player();
		return newPlayer;
	}

	/**
	 * @param i
	 */
	public void addRunes(int i) {
		this.setRunes((i + this.getRunes() > 0) ? this.getRunes() + i : 0);
	}

	/**
	 * @return the runes
	 */
	public int getRunes() {
		return this.runes;
	}

	/**
	 * @param runes the runes to set
	 */
	public void setRunes(int runes) {
		this.runes = runes;
	}

	/**
	 * @return
	 */
	public int getDiscardSize() {
		return this.discardPile.size();
	}

	/**
	 * @param card
	 */
	public void discard(Card card) {
		this.discardPile.add(card);
	}

	/**
	 * @return
	 */
	public ArrayList<Card> getDiscardPile() {
		return this.discardPile;
	}

	/**
	 * @param card
	 * @return
	 */
	public boolean buyCard(Card card) {
		if (card.getCost() <= this.runes) {
			this.setRunes(this.runes - card.getCost());
			this.discard(card);
			return true;
		}
		return false;
	}

}
