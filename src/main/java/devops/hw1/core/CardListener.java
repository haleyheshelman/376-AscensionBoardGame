package devops.hw1.core;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 
 * Handles mouse clicks on cards and on the board
 *
 * @author bishopcc, fenogljc, gneezyn, heshelhj
 */
public class CardListener implements MouseListener {

	// private Player player;
	private ArrayList<Shape> playerHandImages; // for later use
	private ArrayList<Shape> centerHandImages; // for later use
	private GameBoard gameboard;
	private Player player;
	private Board board;
	private Locale locale;
	private ResourceBundle messages;

	public CardListener(Player player, ArrayList<Shape> playerHandImages, ArrayList<Shape> centerHandImages,
			Board board) {
		if (player == null || board == null)
			throw new NullPointerException("Both a valid Board and Player object must be given.");

		this.playerHandImages = playerHandImages;
		this.centerHandImages = centerHandImages;
		this.player = player;
		this.board = board;
		this.locale = new Locale("la", "LA");
		this.messages = ResourceBundle.getBundle("messages", this.locale);
	}

	/**
	 * Determines if a card has been clicked and takes the appropriate action.
	 */
	public void mouseClicked(MouseEvent e) {
		gameboard = (GameBoard) e.getSource();
		Point currentPos = gameboard.getMousePosition();
		int upperBound = 695;
		int lowerBound = 850;
		System.out.println(player.getBanishLocation());
		if (player.getBanishLocation() > 0) {
			nextMouseClick(e.getPoint(), player.getBanishLocation());
			updateGUI();
			return;
		}

		// if the card clicked is in the player hand
		if (player.getHandSize() != 0) {
			int factor = (1220 - 600) / player.getHandSize();

			for (int i = 0; i < player.getHandSize(); i++) {
				int leftBound = (factor * i) + 300;
				int rightBound = (factor * i) + 390;
				if ((currentPos.getX() < rightBound && currentPos.getX() > leftBound)
						&& (currentPos.getY() < lowerBound && currentPos.getY() > upperBound)) {
					player.playCard(player.getHand().get(i));
					updateGUI();
					return;
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
					&& (currentPos.getY() < centerLowerBound && currentPos.getY() > centerUpperBound)) {
				if (player.doCard(board.getCenField()[j], board)) {
					board.centerDeckToField(j);
				}
				updateGUI();
				return;
			}

		}
		updateGUI();

	}

	@SuppressWarnings("resource")
	private void nextMouseClick(Point currentPos, int location) { // currently
																	// has a
																	// ConcurrentModification
																	// Error
		int lowerBound = 850;
		int upperBound = 695;
		if (player.getHandSize() != 0 && (location == 1 || location == 5)) { // banishing
																				// from
																				// hand

			int factor = (1220 - 600) / player.getHandSize();

			for (int i = 0; i < player.getHandSize(); i++) {
				int leftBound = (factor * i) + 300;
				int rightBound = (factor * i) + 390;
				if ((currentPos.getX() < rightBound && currentPos.getX() > leftBound)
						&& (currentPos.getY() < lowerBound && currentPos.getY() > upperBound)) {
					player.banishCard((player.getHand().get(i)), board);
					updateGUI();
					return;
				}
			}

		} else if (player.getDiscardSize() != 0 && (location == 2 || location == 4 || location == 5)) {
			// implement later
		} else if (location == 3 || location == 4) { // might result in bug
			int centerUpperBound = 400; // board height - 400
			int centerLowerBound = 530; // upper-bound + card height

			// if the card click is in the center row
			for (int j = 0; j < 6; j++) {
				int leftBound = (100 * j) + 300;
				int rightBound = (100 * j) + 390;
				if ((currentPos.getX() < rightBound && currentPos.getX() > leftBound)
						&& (currentPos.getY() < centerLowerBound && currentPos.getY() > centerUpperBound)) {
					player.banishCard(board.getCenField()[j], board);
					updateGUI();
					return;
				}

			}
			updateGUI();

		}

	}

	/**
	 * Updates the labels on the GUI and repaints
	 */
	public void updateGUI() {
		gameboard.runesLabel.setText(messages.getString("VOID") + player.getRunes());
		gameboard.powerLabel.setText(messages.getString("POWER") + player.getPower());
		gameboard.discard_pileLabel.setText(messages.getString("DISCARD") + player.getDiscardSize());
		gameboard.deckLabel.setText(messages.getString("LEFTINDECK") + player.getDeckSize());
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
