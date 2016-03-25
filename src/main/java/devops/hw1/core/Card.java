/**
 * 
 */
package devops.hw1.core;

/**
 * @author fenogljc
 *
 */
public class Card {

	private int cost;

	/**
	 * constructor, makes a Card.
	 */
	private Card(){
		
	}
	
	/**
	 * Constructs a card with cost of the given integer.
	 * @param i
	 */
	private Card(int i) {
		this.cost = i;
	}

	/**
	 * calls the constructor of Card and returns the card
	 * @return the Card
	 */
	public static Card makeCard() {
		Card newCard = new Card();
		return newCard;
	}

	/**
	 * Returns that cost of the card.
	 * @return
	 */
	public int getCost() {
		return this.cost;
	}

	/**
	 * Creates and returns a card with the given integer cost.
	 * @param i
	 * @return
	 */
	public static Card makeCard(int i) {
		Card newCard = new Card(i);
		return newCard;
	}
	
}
