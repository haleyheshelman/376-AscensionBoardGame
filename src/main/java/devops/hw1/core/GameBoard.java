package devops.hw1.core;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	//TODO: might want to add a start turn button so that player1 doesn't see cards in player2's hand

	// tracking positions of cards based on rectangle objects drawn beneath them
	public ArrayList<Shape> centerList;
	public ArrayList<Shape> playerList;
	public ArrayList<Shape> opponentList;
	public ArrayList<Shape> standardList;

	public Player player;
	public Board board;
	public Player opponent;

	// sets bounds for the player's hand
	public int playerHandLeft = 300;
	public int playerHandRight = WIDTH - 300;
	public int playerHandY = HEIGHT - 200;
	
	// sets bounds for the cpu's hand (same as player's hand, except for the height)
	public int oppHandY = 50;

	// sets positions for the center cards
	public int cardY = HEIGHT - 500;
	public int card1X = 300;
	
	// sets positions (x & y) for the Void
	public int voidX = WIDTH - 150;
	public int voidY = HEIGHT - 500;
	
	// sets positions for the standard cards (Mystic, Heavy Infantry, & Cultist)
	public int standardY = HEIGHT - 300;
	public int standard1X = 150;

	/**
	 * The default constructor for the Game Board.
	 */
	public GameBoard() {
		// first call constructor of superclass
		super();

		this.centerList = new ArrayList<Shape>();
		this.playerList = new ArrayList<Shape>();
		this.opponentList = new ArrayList<Shape>();
		this.standardList = new ArrayList<Shape>();

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

	/**
	 * The main constructor to be used. Takes a Player and 
	 * Board object as it's parameters.
	 * 
	 * @param player the main player (must be Player Object)
	 * @param board the board that the game takes place on
	 */
	public GameBoard(Player player, Board board) {
		// call the default constructor first
		this();

		// then do additional stuff
		this.player = player;
		this.board = board;
		this.opponent = Player.makePlayer();
		this.endTurnButton.addActionListener(new EndTurnListener(this.player,
				this));
	}

	/**
	 * Paints the cards onto the game board.
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		// setting up the player's hand
		int numCards = player.getHandSize();
		if (numCards != 0) {
			int factor = (playerHandRight - playerHandLeft) / numCards;
			for (int i = 0; i < numCards; i++) {
				BufferedImage card = player.getHand().get(i).getImage();
				g2.drawImage(card, 300 + (factor * i), playerHandY, null);
			}
		}
		
		// setting up the center field (cards)
		for (int j = 0; j < board.getCenField().length; j++) {
			BufferedImage card = board.getCenField()[j].getImage();
			g2.drawImage(card, card1X + (100 * j), cardY, null);

		}

		// painting the player's discard pile
		if (player.getDiscardSize() != 0) {
			g2.drawImage(
					player.getDiscardPile().get(player.getDiscardSize() - 1)
							.getImage(), 1100, 650, null);
		}
		
		// painting the back (image) of the opponent's hand
		int opponentCards = opponent.getHandSize();
		if (opponentCards != 0) {
			int factor = (playerHandRight - playerHandLeft) / opponentCards;
			for (int i = 0; i < opponentCards; i++) {
				try {
					BufferedImage card = ImageIO.read(new File("cardImages/back_of_card.png"));
					g2.drawImage(card, 300 + (factor * i), oppHandY, null);
				} catch (IOException e) {
					System.out.println("The image was not found at: " + "cardImages/back_of_card.png");
				}
			}
		}
		
		int numConstructs = player.getConstructs().size();
		if (numConstructs != 0) {
			int factor = (playerHandRight - playerHandLeft) / numConstructs;
			for (int i = 0; i < numConstructs; i++) {
				g2.drawImage(player.getConstructs().get(i).getImage(), 300 + (factor*i), 550, null);
			}
		}
		
		g2.setFont(LABEL_FONT);
		g2.drawString("THE VOID", voidX, voidY - 9);	// the label for the Void
		// painting banished cards onto the Void
		if (board.getVoid().size() != 0) {
			ArrayList<ACard> theVoid = board.getVoid();
			g2.drawImage(theVoid.get(theVoid.size() - 1).getImage(), voidX, voidY, null);
		}
		
		//TODO: setting up the standard cards (only images so far)
//		for (int i = 0; i < 3; i++) {
//			BufferedImage card = board.getStandardField()[i].getImage();
//			g2.drawImage(card, card1X + (50 * i), standardY, null);
//		}

	}

}