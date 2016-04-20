/**
 * 
 */
package devops.hw1.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fenogljc
 *
 */
public class Player {

	private int runes;
	private int power;
	private int honor;
	private ArrayList<ACard> discardPile;
	// private int handSize;
	private ArrayList<ACard> playerHand;
	private Queue<ACard> playerDeck;

	private Player() {
		this.discardPile = new ArrayList<ACard>();
		this.playerHand = new ArrayList<ACard>();
		this.playerDeck = new LinkedList<ACard>();
		for (int i = 0; i < 5; i++) { // adds 5 cards to the player's hand and
										// deck (at start of game)
			this.addCardToHand(ACard.makeCard());
			this.addCardToDeck(ACard.makeCard());
		}
	}

	/**
	 * This constructs and returns a player.
	 * 
	 * @return
	 */
	public static Player makePlayer() {
		Player newPlayer = new Player();
		return newPlayer;
	}

	/**
	 * This adds the given integer amount of runes to the players current total.
	 * 
	 * @param i
	 */
	public void addRunes(int i) {
		this.setRunes((i + this.getRunes() > 0) ? this.getRunes() + i : 0);
	}

	/**
	 * This returns the amount of runes the player currently has.
	 * 
	 * @return the runes
	 */
	public int getRunes() {
		return this.runes;
	}

	/**
	 * Sets the amount of runs the player has to the given integer value.
	 * 
	 * @param runes
	 *            the runes to set
	 */
	public void setRunes(int runes) {
		this.runes = runes;
	}

	/**
	 * Returns the size of the player's discard pile.
	 * 
	 * @return
	 */
	public int getDiscardSize() {
		return this.discardPile.size();
	}

	/**
	 * This puts the card given into the discard pile.
	 * 
	 * @param card
	 */
	public void discard(ACard card) {
		if (card == null) {
		}
		;
		this.discardPile.add(card);
	}

	/**
	 * Returns the player's discard pile.
	 * 
	 * @return
	 */
	public ArrayList<ACard> getDiscardPile() {
		return this.discardPile;
	}

	/**
	 * Places the given card into the player's discard pile as well as well as
	 * subtracts the amount of runes the player has available. If you do not
	 * have enough runes, this returns false, otherwise true.
	 * 
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

	/**
	 * 
	 * Returns the size of the player hand
	 *
	 * @return the size of the player hand
	 */
	public int getHandSize() {
		return this.playerHand.size();
	}

	// /**
	// *
	// * sets the size of a hand
	// * for testing purposes only
	// *
	// * @param i
	// */
	// public void setHandSize(int i) {
	// this.handSize = i;
	//
	// }

	/**
	 * 
	 * Draws a card from the player deck and adds it to the player hand
	 *
	 */
	public void drawCard() {
		ACard fromDeck = this.playerDeck.remove();
		this.playerHand.add(fromDeck);
		// this.handSize = this.handSize + 1;

	}

	/**
	 * 
	 * Adds a card to the player's deck
	 *
	 * @param card
	 *            to be added
	 */
	public void addCardToDeck(ACard card) {

		if (card == null) {
			return;
		}

		this.playerDeck.add(card);
	}

	/**
	 * Adds the given card to the player's hand
	 * 
	 * @param card
	 *            to be added
	 */
	public void addCardToHand(ACard card) {

		if (card == null)
			return;
		this.playerHand.add(card);
		// this.handSize++;
	}

	/**
	 * 
	 * Gets the current player hand
	 *
	 * @return the player hand
	 */
	public ArrayList<ACard> getHand() {
		return this.playerHand;
	}

	/**
	 * 
	 * Input check card in hand
	 *
	 * @param card
	 */
	public void playCard(ACard card) {

		if (card == null) {
			return;
		}

		HashMap<String, Integer> effects = card.getEffects();
		this.playerHand.remove(card);
		this.discard(card);
		if (effects.containsKey("draw")) {
			this.drawCard(effects.get("draw"));
		}
		if (effects.containsKey("runes")) {
			this.addRunes(effects.get("runes"));
		}

	}

	/**
	 * @param integer
	 */
	public void drawCard(int cards) {
		for (int i = 0; i < cards; i++) {
			this.drawCard();
		}
	}

	/**
	 * @return the Player's Deck
	 */
	public Queue<ACard> getDeck() {
		return this.playerDeck;
	}

	/**
	 * @return the size of the Player's Deck for unit testing
	 */
	public int getDeckSize() {
		return this.playerDeck.size();
	}

	/**
	 * This method returns the amount of power the player currently has.
	 * @return how much power the player has
	 */
	public int getPower() {
		return this.power;
	}

	/**
	 * This method adds power to the total amount of power the player has.
	 * @param i
	 */
	public void addPower(int i) {
		this.power += i;
	}

	public void applyEffects(ACard card) {
		HashMap<String, Integer> map = card.getEffects();
		for (String k : map.keySet()) {
			switch (k) {
			case "rune":
				this.addRunes(map.get(k));
				break;
			case "power":
				this.addPower(map.get(k));
			case "draw":
				this.drawCard(map.get(k));
			case "honor":
				this.addHonor(map.get(k));
			}
		}
	}
	
	/**
	 * This method returns the amount of honor the player has.
	 * @return amount of honor
	 */
	public int getHonor() {
		return this.honor;
	}

	/**
	 * This method adds the amount given to the total amount of honor that the player has.
	 * @param i
	 */
	public void addHonor(int i) {
		this.honor += i;
	}
}
