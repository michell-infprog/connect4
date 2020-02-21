package Connect4;
import java.awt.Color;
/**
 * Main method of the connect 4 program.
 * @author Michel, Hamza
 */
import acm.program.*;

public class Connect4 extends GraphicsProgram {

	/**
	 * The initiation method.
	 */
	public void init() {
		this.setBackground(Color.WHITE);
		
		//Create a model.
		Connect4Model model = new Connect4Model();
				
		//Create a view.
		Connect4GraphicalView view = new Connect4GraphicalView(model);
		//model.addView(view);
		add(view);
				
		//Create a controller.
		Connect4KeyboardController controller = new Connect4KeyboardController(model);
		getGCanvas().addKeyListener(controller);
	}
	
	public static void main(String[] args) {
		new Connect4().start();
	}
}