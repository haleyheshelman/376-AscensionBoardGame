/**
 * 
 */
package devops.hw1.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author fenogljc
 *
 */
public class EndTurnListener implements ActionListener {

	private Player player;
	private GameBoard gameboard;

	/**
	 * @param player
	 */
	public EndTurnListener(Player player, GameBoard gameboard) {
		super();
		this.player = player;
		this.gameboard = gameboard;
	}

	/**
	 * updates the labels on the GUI and repaints
	 */
	public void updateGUI() {
		gameboard.runesLabel.setText("Runes: " + player.getRunes());
		gameboard.powerLabel.setText("Power: " + player.getPower());
		gameboard.discard_pileLabel.setText("Discard: "
				+ player.getDiscardSize());
		gameboard.deckLabel.setText("Left in Deck: " + player.getDeckSize());
		gameboard.repaint();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.player.endTurn();
		this.updateGUI();
	}

}
