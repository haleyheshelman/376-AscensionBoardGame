/**
 * 
 */
package devops.hw1.core;

import java.util.ArrayList;

/**
 * @author fenogljc
 * @author gneezyn
 * 
 */
public class Board {

	private ArrayList<ACard> theVoid;

	private Board() {
		this.theVoid = new ArrayList<ACard>();
	}
	
	public static Board makeBoard(){
		return new Board();
	}

	/**
	 * @return
	 */
	public ArrayList<ACard> getVoid() {
		return this.theVoid;
	}
}
