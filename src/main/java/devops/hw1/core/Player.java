/**
 * 
 */
package devops.hw1.core;

/**
 * @author fenogljc
 *
 */
public class Player {

	private int runes;
	private int discardSize;

	private Player() {
		
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
		return this.discardSize;
	}
	
	/**
	 * @param size
	 */
	public void setDiscardSize(int size) {
		this.discardSize = size;
	}


	
	
}
