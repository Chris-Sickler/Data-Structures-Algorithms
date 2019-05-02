package recursion;

/**
 * A Position has a row number and a column number. 
 * @author Chris Sickler
 */
public class Position {

	int row, col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * @param other
	 * @return true iff a Queen on this position is attacking a Queen on other Position.
	 */
	public boolean isAttacking(Position other) {
		if(this.row == other.row)
			return true;
		if(this.col == other.col) 
			return true;
		if(this.row + this.col == other.row + other.col)   //major diagonal
			return true;
		if(this.row - this.col == other.row - other.col)   //minor diagonal
			return true;
		return false;
	}
	
}
