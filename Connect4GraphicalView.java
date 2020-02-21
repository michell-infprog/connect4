package Connect4;
/**
 * The graphic implementation of the Connect 4 game.
 * @author Michel, Hamza
 */
import java.awt.Color;
import acm.graphics.*;

public class Connect4GraphicalView extends GCompound {
	
	//The constructor.
	/** Creates a view. */
	public Connect4GraphicalView(Connect4Model model) {
		drawBackGround();
		//buildView(model);
	}
	
	public void drawBackGround() {
		GRect grid = new GRect(700, 600);
		grid.setFillColor(Color.BLUE);
		grid.setFilled(true);
		add(grid);
		
		for (int row = 0; row <= 6; row++) {
			for (int col = 0; col <= 5; col++) {
				GOval hole = new GOval( 100 * row, 100 * col, 100, 100);
				hole.setFillColor(Color.WHITE);
				hole.setFilled(true);
				add(hole);
			}
		}
	}
	
	//The methods.
	/** Builds a view. */
	public void buildView(Connect4Model model) {
		int[][]grid = model.getGrid();
		for (int row = 0; row <= 6; row++) {
			for (int col = 5; col >= 0; col--) {
				if (grid[row][col] != 0) {
					GOval chip = new GOval(row * 100, 500 - col * 100, 100, 100);
					switch (grid[row][col]) {
						case 1: chip.setFillColor(Color.YELLOW);
						break;
						case 2: chip.setFillColor(Color.RED);
						break;
					}
					chip.setFilled(true);
					add(chip);
				}
			}
		}
	}
	
	/** Updates the display image from the model. */
	public void update(Connect4Model model) {
		removeAll();
		drawBackGround();
		buildView(model);
	}
}