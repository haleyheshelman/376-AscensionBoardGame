package devops.hw1.core;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainGUI {
	
	private static final int WIDTH = 1220;
	private static final int HEIGHT = 900;

	public static void main(String[] args) {
		Player player1 = Player.makePlayer();
		Board board = new Board();
		player1.addRunes(0);
		GameBoard ascension = new GameBoard(player1, board);
		JFrame frame = new JFrame("ASCENSION");
		frame.setSize(WIDTH, HEIGHT);
		
		ascension.addMouseListener(new CardListener(player1, ascension.playerList, ascension.centerList, board));
		
		frame.add(ascension, BorderLayout.CENTER);
		
		ascension.repaint();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
