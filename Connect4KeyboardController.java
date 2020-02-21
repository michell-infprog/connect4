package Connect4;
/**
 * The Controller of the the Connect 4 game.
 * @author Michel, Hamza
 */
import java.awt.event.*;

public class Connect4KeyboardController extends Connect4Controller implements KeyListener {
	
	public Connect4KeyboardController(Connect4Model model) {
		super(model);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Check if we need to do something
		switch (e.getKeyCode()) {
		case KeyEvent.VK_1:
			putChip(1);
			break;

		case KeyEvent.VK_2:
			putChip(2);
			break;

		case KeyEvent.VK_3:
			putChip(3);
			break;
			
		case KeyEvent.VK_4:
			putChip(4);
			break;
			
		case KeyEvent.VK_5:
			putChip(5);
			break;
			
		case KeyEvent.VK_6:
			putChip(6);
			break;
			
		case KeyEvent.VK_7:
			putChip(7);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}