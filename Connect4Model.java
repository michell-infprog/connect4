package Connect4;
/**
 * The data of the Connect 4 game.
 * @author Michel, Hamza
 */
import java.util.*;

public class Connect4Model {
	
	//The instance variables.
	/** The status of the holes of the connect 4 game. **/
	private int[][] grid;
	
	/** The number of chips left in the game. **/
	private int chips;
	
	/** A list of the views the model has. */
	private ArrayList<Connect4GraphicalView> views;
	
	//The constructor.
	/** Creates a model.*/
	public Connect4Model() {
		this.grid = new int[7][6];
		this.chips = 42;
	}
	
	//The setters.
	/** Sets the grid. */
	public void setGrid(int[][] grid) {
		this.grid = grid;
		notifyViews();
	}
	
	/** Sets the chips. */
	public void setChips(int chips) {
		this.chips = chips;
	}
	
	//The getters.
	/** Gets the grid. */
	public int[][] getGrid() {
		return this.grid;
	}
	
	/** Gets the chips. */
	public int getChips() {
		return this.chips;
	}
	
	//The view methods.
	/** Adds a view to the list of views for this model.*/
	public void addView(Connect4GraphicalView view) {
		views.add(view);
		view.update(this);
	}
	
	/** Calls update(this) on every view to reconstruct their displays.*/
	private void notifyViews() {
		for (Connect4GraphicalView view : views) {
			view.update(this);
		}
	}
}