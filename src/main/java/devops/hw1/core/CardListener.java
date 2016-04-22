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
	private ArrayList<Shape> playerHandImages;
	private ArrayList<Shape> centerHandImages;
	private GameBoard board;
	private Player player;
	
	public CardListener(Player player, ArrayList<Shape> playerHandImages, ArrayList<Shape> centerHandImages) {
		this.playerHandImages = playerHandImages;
		this.centerHandImages = centerHandImages;
		this.player = player;
//		this.playerHand = player.getHand();
	}

	public void mouseClicked(MouseEvent e) {
		board = (GameBoard) e.getSource();
		Point currentPos = board.getMousePosition();
		int upperBound = 695;
		int lowerBound = 850;

		int factor = (1220-600) / player.getHandSize();

		for (int i = 0; i < player.getHandSize(); i++) {
			int leftBound = (factor * i) + 300;
			int rightBound = (factor * i) + 390;
			if ((currentPos.getX() < rightBound && currentPos.getX() > leftBound)
					&& (currentPos.getY() < lowerBound && currentPos.getY() > upperBound)) {
				player.playCard(player.getHand().get(i));
				break;
			}

		}
		updateGUI();

	}
	
	public void updateGUI() {
		board.runesLabel.setText("Runes: " + player.getRunes());
		board.powerLabel.setText("Power: " + player.getPower());				
		board.discard_pileLabel.setText("Discard: " + player.getDiscardSize());
		board.repaint();
		
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
