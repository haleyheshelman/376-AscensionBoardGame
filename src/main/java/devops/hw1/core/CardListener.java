package devops.hw1.core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author gneezyn
 * 
 */
public class CardListener implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		GameBoard src = (GameBoard) e.getSource();
//		System.out.println("IT WORKS!");
		src.runes.setText("Runes: " + (String.valueOf(src.rune_count - 1)));
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
