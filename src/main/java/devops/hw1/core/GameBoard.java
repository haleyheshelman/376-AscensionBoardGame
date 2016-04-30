package devops.hw1.core;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The GUI for the Ascension Game Board. Contains none of the game logic code.
 * 
 * @author bishopcc, fenogljc, gneezyn, heshelhj
 */
@SuppressWarnings("serial")
public class GameBoard extends JPanel {

	// same width & height as the background image
	private static final int WIDTH = 1220;
	private static final int HEIGHT = 900;
	private static final Font LABEL_FONT = new Font("Serif", Font.BOLD, 18);

	// background may be made into a separate class or just left out entirely
	// private BufferedImage background; currently not used

	// labels that display
	public JLabel runesLabel = new JLabel("Runes: 0");
	public JLabel powerLabel = new JLabel("Power: 0");
	public JLabel deckLabel = new JLabel("Left in Deck: 5");
	public JLabel discard_pileLabel = new JLabel("Discard: 0");
	public JButton endTurnButton = new JButton("End Turn");

	// counters for keeping track of the various information, will be replaced
	// as project progresses
	public int runeCount;
	public int powerCount;
	public int deckCount;
	public int discardCount;
	public int honorCount;

	// tracking positions of cards based on rectangle objects drawn beneath them
	public ArrayList<Shape> centerList;
	public ArrayList<Shape> playerList;

	public Player player;
	public Board board;

	// sets bounds for player hand
	public int playerHandLeft = 300;
	public int playerHandRight = WIDTH - 300;
	public int playerHandY = HEIGHT - 200;

	// sets positions for the center cards
	public int cardY = HEIGHT - 500;
	public int card1X = 300;

	/**
	 * The default constructor for the Game Board.
	 */
	public GameBoard() {
		// first call constructor of superclass
		super();

		// then initialize value
		this.runeCount = 0;
		this.powerCount = 0;
		this.deckCount = 5;
		this.discardCount = 0;

		this.centerList = new ArrayList<Shape>();
		this.playerList = new ArrayList<Shape>();

		// Setting the fonts of the labels
		this.runesLabel.setFont(LABEL_FONT);
		this.powerLabel.setFont(LABEL_FONT);
		this.deckLabel.setFont(LABEL_FONT);
		this.discard_pileLabel.setFont(LABEL_FONT);

		this.setLayout(new BorderLayout());

		JPanel leftInfo = new JPanel();
		leftInfo.setLayout(new GridLayout(4, 1));
		leftInfo.add(this.endTurnButton);
		leftInfo.add(this.runesLabel);
		leftInfo.add(this.powerLabel);
		leftInfo.add(this.deckLabel);

		JPanel labels = new JPanel();
		labels.setLayout(new BorderLayout());
		labels.add(leftInfo, BorderLayout.WEST);
		labels.add(this.discard_pileLabel, BorderLayout.EAST);
		labels.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.add(labels, BorderLayout.SOUTH);
	}

	public GameBoard(Player player, Board board) {
		// call the default constructor first
		this();

		// then do additional stuff
		this.player = player;
		this.runeCount = this.player.getRunes();
		this.discardCount = this.player.getDiscardSize();
		this.board = board;
		this.endTurnButton.addActionListener(new EndTurnListener(this.player,
				this));
	}

	/**
	 * Paints the cards onto the game baord
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		int numCards = player.getHandSize();
		if (numCards != 0) {
			int factor = (playerHandRight - playerHandLeft) / numCards;
			for (int i = 0; i < numCards; i++) {
				BufferedImage card = player.getHand().get(i).getImage();
				g2.drawImage(card, 300 + (factor * i), playerHandY, null);

			}
		}
		for (int j = 0; j < board.getCenField().length; j++) {
			BufferedImage card = board.getCenField()[j].getImage();
			g2.drawImage(card, card1X + (100 * j), cardY, null);

		}

		if (player.getDiscardSize() != 0) {
			g2.drawImage(
					player.getDiscardPile().get(player.getDiscardSize() - 1)
							.getImage(), 20, 600, null);
		}

	}

}