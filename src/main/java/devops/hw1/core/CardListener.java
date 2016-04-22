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
	private GameBoard gameboard;
	private Player player;
	private Board board;
	
	public CardListener(Player player, ArrayList<Shape> playerHandImages, ArrayList<Shape> centerHandImages,Board board) {
		this.playerHandImages = playerHandImages;
		this.centerHandImages = centerHandImages;
		this.player = player;
		this.board = board;
//		this.playerHand = player.getHand();
	}

	public void mouseClicked(MouseEvent e) {
		gameboard = (GameBoard) e.getSource();
		Point currentPos = gameboard.getMousePosition();
		int upperBound = 695;
		int lowerBound = 850;
		
		if (player.getHandSize() != 0) {
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
		}

		int centerUpperBound = 400; //board height - 400
		int centerLowerBound = 530; //upperbound + card height	
		
		for (int j = 0; j < 6; j++) {
			int leftBound = (100 * j) + 300;
			int rightBound = (100 * j) + 390;
			if ((currentPos.getX() < rightBound && currentPos.getX() > leftBound)
					&& (currentPos.getY() < centerLowerBound && currentPos.getY() > centerUpperBound)) {
				if (player.buyCard(board.getCenField()[j])) {
					board.centerDeckToField(j);					
				}
				break;
			}

		}
		updateGUI();

	}
	
	public void updateGUI() {
		gameboard.runesLabel.setText("Runes: " + player.getRunes());
		gameboard.powerLabel.setText("Power: " + player.getPower());				
		gameboard.discard_pileLabel.setText("Discard: " + player.getDiscardSize());
		gameboard.repaint();
		
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
