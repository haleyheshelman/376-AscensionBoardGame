/**
 * 
 */
package devops.hw1.core;

/**
 * @author fenogljc
 *
 */
public class Card {

	/**
	 * constructor, makes a Card.
	 */
	private Card(){
		
	}
	
	/**
	 * calls the constructor of Card and returns the card
	 * @return the Card
	 */
	public static Card makeCard() {
		Card newCard = new Card();
		return newCard;
	}
	
}
