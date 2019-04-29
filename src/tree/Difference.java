package tree;

/** Result of subracting two Exprss
 * 
 * @author chris sickler
 * @version 04/02/2019
 */
public class Difference extends Expr {
	
	public Difference(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() - right.eval();
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left instanceof Constant && right.eval() == 0)
			return left;
		if(right instanceof Constant && left.eval() == 0)
			return right;
		return this;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Difference))
			return false;
		Difference other = (Difference) obj;
		return left.equals(other.left) && right.equals(other.right);
	}
	
	public String toString() {
		return "(" + left + "-" + right + ")";
	}
}
