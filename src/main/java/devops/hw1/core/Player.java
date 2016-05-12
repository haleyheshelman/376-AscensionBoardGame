package devops.hw1.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bishopcc, fenogljc, gneezyn, heshelhj
 */
public class Player {

	private int runes;
	private int power;
	private int honor;
	private ArrayList<ACard> discardPile;
	private ArrayList<ACard> playerHand;
	private LinkedList<ACard> playerDeck;
	private int banishLocation = 0;
	private ArrayList<ACard> constructs;

	/**
	 * The constructor creates a player with a hand of five cards and a deck of
	 * five cards.
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
		this.constructs = new ArrayList<ACard>();
		this.initialiseDeck();
		Collections.shuffle(this.playerDeck);
		this.drawCard(5);
	}

	/**
	 * Initializes the player's deck (adds cards).
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
	 * Puts all of the players cards into the discard pile and draws 5 cards
	 * for a new hand.
	 */
	public void endTurn() {
		this.discardPile.addAll(this.getHand());
		this.getHand().clear();
		this.setRunes(0);
		this.addPower(0 - this.power);
		this.drawCard(5);
	}

	/**
	 * This constructs and returns a player.
	 * 
	 * @return a new Player object
	 */
	public static Player makePlayer() {
		Player newPlayer = new Player();
		return newPlayer;
	}

	/**
	 * This adds the given integer amount of runes to the players current total.
	 * @param i amount of runes to add (must be greater than zero)
	 */
	public void addRunes(int i) {
		this.setRunes((i + this.getRunes() > 0) ? this.getRunes() + i : 0);
	}

	/**
	 * This returns the amount of runes the player currently has.
	 * @return the number of runes this player has
	 */
	public int getRunes() {
		return this.runes;
	}

	/**
	 * Sets the amount of runs the player has to the given integer value.
	 * @param runes the value to set the player's number of runes as
	 */
	public void setRunes(int runes) {
		this.runes = runes;
	}

	/**
	 * Returns the size of the player's discard pile.
	 * @return the size of the player's discard pile
	 */
	public int getDiscardSize() {
		return this.discardPile.size();
	}

	/**
	 * This puts the given card into the discard pile (does not
	 * remove the card from the hand).
	 * @param card the card to be put in the discard pile
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
	 * @return the player's discard pile (as an ArrayList<ACard>)
	 */
	public ArrayList<ACard> getDiscardPile() {
		return this.discardPile;
	}

	/**
	 * Places the given card into the player's discard pile as well as well as
	 * subtracts the amount of runes the player has available. If you do not
	 * have enough runes, this returns false, otherwise true.
	 * 
	 * @param card the card that the player is attempting to buy
	 * @return true if the card can be bought by the player, false otherwise
	 */
	public boolean buyCard(ACard card) {
		if (card != null){
			int cost = card.getCost();
			if (cost <= this.runes) {
				this.setRunes(this.runes - cost);
				this.discard(card);
				return true;
			}
		}
		return false;
	}

	/**
	 * Attack card will take a card and the board. If the player has enough
	 * power it will place the card in the void discard pile
	 * 
	 * @param card the card that is being attacked
	 * @return true if the attack is successful and sent to void and false otherwise
	 */

	public boolean attackCard(ACard card, Board board) {
		if (card != null){
			int strength = card.getStrength();
			if (strength <= this.power) {
				this.addPower(0 - strength);
				this.applyEffects(card);
				board.sendToVoid(card);
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the size of the player hand
	 * @return the size of the player's hand
	 */
	public int getHandSize() {
		return this.playerHand.size();
	}

	/**
	 * Draws a card from the player deck and adds it to the player's hand
	 */
	public void drawCard() {
		if (this.playerDeck.isEmpty()) {
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
	 * @param card the card to be added to the player's deck
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
	 * @param card the card to be added to the player's hand
	 */
	public void addCardToHand(ACard card) {

		if (card == null) {
			System.out.println("attempted to add a null card to hand");
			return;
		}
		this.playerHand.add(card);
	}

	/**
	 * Gets the current player hand
	 * @return the player's hand (as an ArrayList<ACard>)
	 */
	public ArrayList<ACard> getHand() {
		return this.playerHand;
	}

	/**
	 * Input check card in hand
	 * @param card the card to be played (by the player)
	 */
	public void playCard(ACard card) {

		if (card == null) {
			System.out.println("attempted to play a null card");
			return;
		}
		this.playerHand.remove(card);
		if (card.getType().equals("Construct")) {
			this.addConstruct(card);
			return;
		}
		this.applyEffects(card);
		this.discard(card);
	}
	
	public void addConstruct(ACard card) {
		this.constructs.add(card);
	}

	/**
	 * Adds the designated number of cards (from the player's deck)
	 * to the player's hand.
	 * @param integer the number of cards to draw
	 */
	public void drawCard(int cards) {
		for (int i = 0; i < cards; i++) {
			this.drawCard();
		}
	}

	/**
	 * @return the player's deck
	 */
	public Queue<ACard> getDeck() {
		return this.playerDeck;
	}

	/**
	 * @return the size of the player's deck for unit testing
	 */
	public int getDeckSize() {
		return this.playerDeck.size();
	}

	/**
	 * This method returns the amount of power the player currently has.
	 * 
	 * @return how much power the player has
	 */
	public int getPower() {
		return this.power;
	}

	/**
	 * This method adds power to the total amount of power the player has.
	 * 
	 * @param i
	 */
	public void addPower(int i) {
		this.power += i;
	}

	/**
	 * Applies the effects of the given card to the player.
	 * 
	 * @param card the card whose effect(s) are being used
	 */
	@SuppressWarnings("boxing")
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
			case CardCollection.BANISH:
				this.banishLocation += map.get(k);
				break;			 
			}
		}
	}
	
	public void banishCard(ACard toBanish, Board board){
		if (toBanish != null && board != null){
			board.sendToVoid(toBanish);
		}
	}

	/**
	 * This method returns the amount of honor the player has.
	 * 
	 * @return amount of honor the player has
	 */
	public int getHonor() {
		return this.honor;
	}

	/**
	 * This method adds the amount given to the total amount of honor that the
	 * player has.
	 * 
	 * @param i the amount of honor to add
	 */
	public void addHonor(int i) {
		this.honor += i;
	}
	
	/**
	 * This function takes a card and decides how to handle the card.
	 * @param card 
	 * @param board 
	 * @return 
	 */
	public boolean doCard(ACard card, Board board) {
		String type = card.getType();
		if (type.equals("Hero") || type.equals("Construct")) {
			return this.buyCard(card);
		}
		return this.attackCard(card, board); // There is a problem here........
	}
	
	public int getBanishLocation() {
		return this.banishLocation;
	}

	public ArrayList<ACard> getConstructs() {
		return this.constructs;
	}
}
