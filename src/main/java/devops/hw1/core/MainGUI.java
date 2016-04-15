package devops.hw1.core;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainGUI {
	
	private static final int WIDTH = 1220;
	private static final int HEIGHT = 900;

	public static void main(String[] args) {
		Player player1 = Player.makePlayer();
		player1.addRunes(5);
		player1.drawCard(5);
		GameBoard ascension = new GameBoard(player1);
		ascension.setType("Rune");
		JFrame frame = new JFrame("ASCENSION");
		frame.setSize(WIDTH, HEIGHT);
		
		ascension.addMouseListener(new CardListener(player1, ascension.playerList, ascension.centerList));
		
		frame.add(ascension, BorderLayout.CENTER);
		
		ascension.repaint();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

// code that might be used later
//		MyComponent info = new MyComponent();
//		info.setLayout(new GridLayout(3, 1));
//		info.add(runesLeft);
//		info.add(powerLeft);
//		info.add(deckLeft);
//		
//		frame.setLayout(new BorderLayout());
//		frame.add(info, BorderLayout.SOUTH);