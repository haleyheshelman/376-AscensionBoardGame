package devops.hw1.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The GUI for the Ascension Game Board.
 */
public class GameBoard extends JPanel {
	
	// same width & height as the background image
	private static final int WIDTH = 1220;
	private static final int HEIGHT = 900;

	private BufferedImage background;
	public JPanel info;
	public JLabel runes;
	public JLabel power;
	public JLabel deck;
	public Integer rune_count;
	public int power_count;
	public int deck_count;
	
	public CardListener cardListener;
	
	/**
	 * The default constructor for the Game Board.
	 */
	public GameBoard() {
		background = null;
//		rune_count = player.getRunes();
		rune_count = 5;
		power_count = 0;
		deck_count = 5;
		
		JLabel runes = new JLabel("Runes: 5");
		JLabel power = new JLabel("Power: 0");
		JLabel deck = new JLabel("Left in Deck: 5");
		
		this.setLayout(new GridLayout(3, 1));
		this.add(runes);
		this.add(power);
		this.add(deck);
		
		cardListener = new CardListener();
		this.addMouseListener(cardListener);
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
		
		for (int i = 1; i <= 6; i++) {
//			g2.setColor(Color.black);
//			Rectangle2D.Double card = new Rectangle2D.Double(100*i, 300, 90, 125);
//			g2.fill(card);
			
			BufferedImage card = null;
			try {
				card = ImageIO.read(new File("card_images/Standard/Apprentice.png"));
				
			} catch (IOException e) {
				System.out.println("Something went wrong with the Aprrentice.png file.");
			}
			
			g2.drawImage(card, 200 + 100*i, HEIGHT - 300, null);
		}
	}
	
	public static void main(String[] args) {
//		Player player1 = new Player();
//		player1.addRunes(i);
		GameBoard ascension = new GameBoard();
		JFrame frame = new JFrame("ASCENSION");
		frame.setSize(WIDTH, HEIGHT);
		
		
//		JLabel runesLeft = new JLabel("Runes: 5");
//		JLabel powerLeft = new JLabel("Power: 0");
//		JLabel deckLeft = new JLabel("Left in Deck: 5");
//		MyComponent info = new MyComponent();
//		info.setLayout(new GridLayout(3, 1));
//		info.add(runesLeft);
//		info.add(powerLeft);
//		info.add(deckLeft);
//		
//		frame.setLayout(new BorderLayout());
//		frame.add(info, BorderLayout.SOUTH);
		frame.add(ascension, BorderLayout.CENTER);
		
//		ascension.addMouseListener(new CardListener());
		
		ascension.repaint();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
