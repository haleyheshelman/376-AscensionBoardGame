package devops.hw1.core;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * @author gneezyn
 * 
 */
public class CardListener implements MouseListener {
	
//	private Player player;
	private ArrayList<Shape> playerHand;
	private ArrayList<Shape> centerHand;
	private GameBoard board;
	
	public CardListener(Player player, ArrayList<Shape> playerHand, ArrayList<Shape> centerHand) {
		this.playerHand = playerHand;
		this.centerHand = centerHand;
//		this.player = player;
//		this.playerHand = player.getHand();
	}

	public void mouseClicked(MouseEvent e) {
		board = (GameBoard) e.getSource();
		Point currentPos = board.getMousePosition();
		
		for (int i = 0; i < playerHand.size(); i++) {
			if (playerHand.get(i).contains(currentPos)) {
				checkType("add");
			}
		}
		
		for (int i = 0; i < centerHand.size(); i++) {
			if (centerHand.get(i).contains(currentPos)) {
				checkType("spend");
			}
		}
		
	}
	
	/**
	 * @param action a String that specifies whether the runes/power is being spent (spend) or added (add)
	 */
	public void checkType(String action) {
		if (action.toLowerCase().equals("spend")) {
			if (board.type.equals("Rune")) {
				if (board.rune_count == 0) {
					System.out.println("You don't have enough Runes.");
				} else {
					board.rune_count--;
//				player.playCard(playerHand.get(0));
					board.runes.setText("Runes: " + (String.valueOf(board.rune_count)));				
				}
			} else {
				if (board.power_count == 0) {
					System.out.println("You don't have enough Power.");
				} else {
					board.power_count--;
					board.power.setText("Power: " + (String.valueOf(board.power_count)));				
				}
			}			
		} else if (action.toLowerCase().equals("add")) {
			if (board.type.equals("Rune")) {
				board.rune_count++;
//				player.playCard(playerHand.get(0));
				board.runes.setText("Runes: " + (String.valueOf(board.rune_count)));				
			} else {
				board.power_count++;
				board.power.setText("Power: " + (String.valueOf(board.power_count)));				
			}
			board.discard_count++;
			board.discard_pile.setText("Discard: " + (String.valueOf(board.discard_count)));
		} else System.out.println("Something went wrong (in case it wasn't obvious).");
		
	}
	

	public void mouseEntered(MouseEvent arg0) {
		// not implemented
	}

	public void mouseExited(MouseEvent arg0) {
		// not implemented
	}

	public void mousePressed(MouseEvent arg0) {
		// not implemented
	}

	public void mouseReleased(MouseEvent arg0) {
		// not implemented
	}

}
