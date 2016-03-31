package devops.hw1.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The GUI for the Ascension Game Board.
 */
@SuppressWarnings("serial")
public class GameBoard extends JPanel {
	
	// same width & height as the background image
	private static final int WIDTH = 1220;
	private static final int HEIGHT = 900;
	private static final Font LABEL_FONT = new Font("Serif", Font.BOLD, 18);

	// background may be made into a separate class or just left out entirely
//	private BufferedImage background; currently not used

	// labels that display
	public JLabel runes = new JLabel("Runes: 5");
	public JLabel power = new JLabel("Power: 0");
	public JLabel deck = new JLabel("Left in Deck: 5");
	public JLabel discard_pile = new JLabel("Discard: 0");

	// counters for keeping track of the various information, will be replaced as project progresses
	public int rune_count;
	public int power_count;
	public int deck_count;
	public int discard_count;
	
	// tracking positions of cards based on rectangle objects drawn beneath them
	public ArrayList<Shape> centerList;
	public ArrayList<Shape> playerList;
	
	public String type;
	
	public Player player;
	
	/**
	 * The default constructor for the Game Board.
	 */
	public GameBoard() {
		// first call constructor of superclass 
		super();
		
		// then initialize value
//		background = null;
		rune_count = 5;
		power_count = 0;
		deck_count = 5;
		discard_count = 0;
		
		this.centerList = new ArrayList<Shape>();
		this.playerList = new ArrayList<Shape>();
		
		// Setting the fonts of the labels
		runes.setFont(LABEL_FONT);
		power.setFont(LABEL_FONT);
		deck.setFont(LABEL_FONT);
		discard_pile.setFont(LABEL_FONT);
		
		this.setLayout(new BorderLayout());
		
		JPanel leftInfo = new JPanel();
		leftInfo.setLayout(new GridLayout(3, 1));
		leftInfo.add(runes);
		leftInfo.add(power);
		leftInfo.add(deck);
		
		
		JPanel labels = new JPanel();
		labels.setLayout(new BorderLayout());
		labels.add(leftInfo, BorderLayout.WEST);
		labels.add(discard_pile, BorderLayout.EAST);
		
		labels.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.add(labels, BorderLayout.SOUTH);
		
//		cardListener = new CardListener();
//		this.addMouseListener(cardListener);
	}
	
	public GameBoard(Player player) {
		// call the default constructor first
		this();
		
		// then do additional stuff
		this.player = player;
		rune_count = this.player.getRunes();
		discard_count = this.player.getDiscardSize();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
//		BufferedImage img = null;
//		try {
//			img = ImageIO.read(new File("Game-BoardSmall.png"));
//		} catch (IOException e) {
//			System.out.println("Something went wrong with the Game-BoardSmall.png file.");
//		}
//		g2.drawImage(img, 0, 0, null);
		
		// the center field
		for (int i = 1; i <= 6; i++) {
			
			BufferedImage card = null;
			try {
				card = ImageIO.read(new File("cardImages/Heroes/Arha-Templar.png"));
				
			} catch (IOException e) {
				System.out.println("Something went wrong with the Arha-Templar.png file.");
			}
			
			Rectangle2D.Double cardPos = new Rectangle2D.Double(150 + 100*i, HEIGHT - 475, 90, 125);
			this.centerList.add(cardPos);
			
			g2.drawImage(card, 150 + 100*i, HEIGHT - 475, null);
		}
		
		// the player hand
		for (int i = 1; i <= 5; i++) {
			
			BufferedImage card = null;
			try {
				card = ImageIO.read(new File("cardImages/Standard/Apprentice.png"));
				
			} catch (IOException e) {
				System.out.println("Something went wrong with the Aprrentice.png file.");
			}
			
			Rectangle2D.Double cardPos = new Rectangle2D.Double(200 + 100*i, HEIGHT - 300, 90, 125);
			this.playerList.add(cardPos);
			
			g2.drawImage(card, 200 + 100*i, HEIGHT - 300, null);
		}
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	// TO DO: add discard pile gui, use interface or class? what parameters?
	// Brainstorm about how to move cards (when they are played, through game board or card listener?)
	
}
