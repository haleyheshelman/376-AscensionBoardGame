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
	 * @return
	 */
	public int getCost() {
		// TODO Auto-generated method stub
		return this.cost;
	}

	/**
	 * @param i
	 * @return
	 */
	public static Card makeCard(int i) {
		Card newCard = new Card(i);
		return newCard;
	}
	
}
