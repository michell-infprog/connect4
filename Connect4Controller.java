package Connect4;
/**
 * @author Michel
 */
public class Connect4Controller {

	//The instance variables.
	/** The model of the controller. */
	private Connect4Model model;

	//The constructor.
	/** Creates a controller. */
	public Connect4Controller(Connect4Model model) {
		this.model = model;
	}

		//The controller methods.
		/** Puts a chip in the grid. */
		public void putChip(int col) {
			
			//We create a new grid.
			int[][] grid = this.model.getGrid();
			
			int spotx = col - 1;
			for (int row = 5; row >= 0; row++) {
				
				//We check if the spot is free.
				if (grid[spotx][row] == 0) {
					
					//We change the spot.
					grid[spotx][row] = turn();
					this.model.setGrid(grid);
					
					//We check for 4 in a row.
					check(spotx, row, turn());
				}
			}
		}
		
		/** Checks if there are four chips of one kind in a row. */
		public boolean check(int x, int y, int turn) {
			int inARow = 0;
			//We check horizontally.
			for (int i = - 3; i <= 3; i++) {
				if (model.getGrid()[x + i][y] == turn) {
					inARow++;
				} else {
					inARow = 0;
				}
				if (inARow == 4) {
					model.setChips(0);
					break;
				}
			}
			//We check vertically.
			for (int i = - 3; i <= 3; i++) {
				if (model.getGrid()[x][y + 1] == turn) {
					inARow++;
				} else {
					inARow = 0;
				}
				if (inARow == 4) {
					model.setChips(0);
					break;
				}
			}
			//We check diagonally.
			for (int i = - 3; i <= 3; i++) {
				if (model.getGrid()[x + i][y + i] == turn) {
					inARow++;
				} else {
					inARow = 0;
				}
				if (inARow == 4) {
					return true;
				}
			}
			for (int i = - 3; i <= 3; i++) {
				if (model.getGrid()[x - i][y + i] == turn) {
					inARow++;
				} else {
					inARow = 0;
				}
				if (inARow == 4) {
					model.setChips(0);
					break;
				}
			}
			return false;
		}
		
		/** Returns whose turn it is. */
		public int turn() {
			if (model.getChips() % 2 == 0 && model.getChips() > 0) {
				return 1;
			} else if (model.getChips() % 2 == 1 && model.getChips() > 0) {
				return 2;
			} else {
				return 0;
			}
		}
}