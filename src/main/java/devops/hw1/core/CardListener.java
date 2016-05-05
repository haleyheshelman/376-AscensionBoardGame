package devops.hw1.core;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * 
 * Handles mouse clicks on cards and on the board
 *
 * @author bishopcc, fenogljc, gneezyn, heshelhj
 */
public class CardListener implements MouseListener {

	// private Player player;
	private ArrayList<Shape> playerHandImages;
	private ArrayList<Shape> centerHandImages;
	private GameBoard gameboard;
	private Player player;
	private Board board;

	public CardListener(Player player, ArrayList<Shape> playerHandImages,
			ArrayList<Shape> centerHandImages, Board board) {
		if (player == null || board == null)
			throw new NullPointerException(
					"Both a valid Board and Player object must be given.");

		this.playerHandImages = playerHandImages;
		this.centerHandImages = centerHandImages;
		this.player = player;
		this.board = board;
	}

	/**
	 * Determines if a card has been clicked and takes the appropriate action.
	 */
	public void mouseClicked(MouseEvent e) {
		gameboard = (GameBoard) e.getSource();
		Point currentPos = gameboard.getMousePosition();
		int upperBound = 695;
		int lowerBound = 850;

		// if the card clicked is in the player hand
		if (player.getHandSize() != 0) {
			int factor = (1220 - 600) / player.getHandSize();
			
			int banishType = player.getBanishLocation();
			// if banish effect is taking place
			if (banishType > 0) {	//action depends on which banish effect it is
				switch (banishType) {
					case 1: //do something		//1 = banish from hand
							break;
					case 2: //do something		//2 = banish from discard
							break;
					case 3: //do something		//3 = banish from center field
							break;
					case 4: //do something		//4 = banish from center or discard
							break;
					case 5: //do somethign		//5 = banish from hand or discard
							break;
				}
			}	// should never be less than zero since it is initialized at zero
			
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

		int centerUpperBound = 400; // board height - 400
		int centerLowerBound = 530; // upper-bound + card height

		// if the card click is in the center row
		for (int j = 0; j < 6; j++) {
			int leftBound = (100 * j) + 300;
			int rightBound = (100 * j) + 390;
			if ((currentPos.getX() < rightBound && currentPos.getX() > leftBound)
					&& (currentPos.getY() < centerLowerBound && currentPos
							.getY() > centerUpperBound)) {
				if (player.doCard(board.getCenField()[j], board)) {
					board.centerDeckToField(j);
				}
				break;
			}

		}
		updateGUI();

	}

	/**
	 * Updates the labels on the GUI and repaints
	 */
	public void updateGUI() {
		gameboard.runesLabel.setText("Runes: " + player.getRunes());
		gameboard.powerLabel.setText("Power: " + player.getPower());
		gameboard.discard_pileLabel.setText("Discard: "
				+ player.getDiscardSize());
		gameboard.deckLabel.setText("Left in Deck: " + player.getDeckSize());
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
