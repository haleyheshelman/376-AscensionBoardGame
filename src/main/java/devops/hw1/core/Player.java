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
		this.setRunes(this.getRunes() + i);
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
	
	
}
