package recursion;
import list.*;

/**
 * 
 * @author Chris Sickler
 */
public class Board {

	List<Position> queens = new ArrayList<Position>();
	
	public Board() {
		
	}
	
	public Board(Board b) {
		queens = new ArrayList<Position> (b.queens);
	}
	
	/**
	 * Place a Queen on this Board at given Position
	 */
	public void addQueen(Position p) {
		queens.add(p);
	}
	
	
}
