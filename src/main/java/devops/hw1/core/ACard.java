/**
 * 
 */
package devops.hw1.core;

/**
 * @author fenogljc
 *
 */
public abstract class ACard {

	protected int cost;
	
	public static ACard makeCard() {
		return new DrawCard();
	}
	
	public static ACard makeCard(int i) {
		return new DrawCard(i);
	}

	/**
	 * Returns that cost of the card.
	 * @return
	 */
	public int getCost() {
		return this.cost;
	}
	
	/**
	 * Sets the cost of the card.
	 * @return
	 */
	public boolean setCost(int i) {
		this.cost = i;
		return true;
	}
	
	public abstract void effect();
}

