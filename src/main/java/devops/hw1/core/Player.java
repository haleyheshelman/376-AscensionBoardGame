/**
 * 
 */
package devops.hw1.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
	private ArrayList<ACard> playerHand;
	private LinkedList<ACard> playerDeck;

	/**
	 * The constructor creates a player with a hand of five cards and a deck of five cards.
	 */
	
	private Player() {	
		try {
			new CardCollection();
		} catch (IOException e) {
			System.out.println("Could not find file");
		}
		this.discardPile = new ArrayList<ACard>();
		this.playerHand = new ArrayList<ACard>();
		this.playerDeck = new LinkedList<ACard>();
		this.initialiseDeck();
		Collections.shuffle(this.playerDeck);
		this.drawCard(5);
	}

	/**
	 * 
	 */
	public void initialiseDeck() {
			for (int i = 0; i < 8; i++) { 
			this.addCardToDeck(CardCollection.apprentice);
		}
		for (int j = 0; j < 2; j++) {
			this.addCardToDeck(CardCollection.militia);
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
			System.out.println("attempted to discard null card");
			return;
		}
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
	 * Attack card will take a card and the board.  
	 * If the player has enough power it will place the card in
	 * the void discard pile
	 */
	
	public boolean attackCard(ACard card, Board board) {
		if (card != null && card.getStrength() <= this.power) {
			this.addPower(0 - card.getStrength());
			board.sendToVoid(card);
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

	/**
	 * 
	 * Draws a card from the player deck and adds it to the player hand
	 *
	 */
	public void drawCard() {
		if (this.playerDeck.isEmpty()){
			this.playerDeck.addAll(this.discardPile);
			this.discardPile.clear();
			Collections.shuffle(this.playerDeck);
		}
		ACard fromDeck = this.playerDeck.remove();
		this.playerHand.add(fromDeck);
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
			System.out.println("attempted to add a null card to deck");
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

		if (card == null){
			System.out.println("attempted to add a null card to hand");
			return;
		}
		this.playerHand.add(card);
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
			System.out.println("attempted to play a null card");
			return;
		}
		this.playerHand.remove(card);
		this.applyEffects(card);
		this.discard(card);
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

	/**
	 * Applies the effects of the given card to the player.
	 * @param card
	 */
	public void applyEffects(ACard card) {
		HashMap<String, Integer> map = card.getEffects();
		for (String k : map.keySet()) {
			switch (k) {
			case CardCollection.RUNES:
				this.addRunes(map.get(k));
				break;
			case CardCollection.POWER:
				this.addPower(map.get(k));
				break;
			case CardCollection.DRAW:
				this.drawCard(map.get(k));
				break;
			case CardCollection.HONOR:
				this.addHonor(map.get(k));
				break;
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
