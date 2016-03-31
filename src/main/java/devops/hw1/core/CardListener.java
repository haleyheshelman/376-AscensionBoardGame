package devops.hw1.core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * @author gneezyn
 * 
 */
public class CardListener implements MouseListener {
	
	private Player player;
	private ArrayList<ACard> playerHand;
	
	public CardListener(Player player) {
		this.player = player;
		this.playerHand = player.getHand();
	}

	public void mouseClicked(MouseEvent e) {
		GameBoard board = (GameBoard) e.getSource();
		if (board.type.equals("Rune")) {
			if (board.rune_count == 0) {
				System.out.println("You don't have enough Runes.");
			} else {
				board.rune_count--;
				player.playCard(playerHand.get(0));
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
