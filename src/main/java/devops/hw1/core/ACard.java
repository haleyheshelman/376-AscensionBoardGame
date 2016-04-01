/**
 * 
 */
package devops.hw1.core;

import java.util.HashMap;

/**
 * @author fenogljc
 *
 */
public abstract class ACard {

	protected int cost;
	protected HashMap<String,Integer> effects = new HashMap<String, Integer>();
	
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
	public void setCost(int i) {
		this.cost = i;
	}
	
	public HashMap<String,Integer> getEffects(){
		return this.effects;
	}
	
	public void setEffect(String effect, int value){
		this.effects.put(effect, value);
	}
	
}

