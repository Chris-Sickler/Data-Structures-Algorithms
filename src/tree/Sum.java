package tree;

/** Result of adding two Exprss
 * 
 * @author chris sickler
 * @version 04/02/2019
 */
public class Sum extends Expr {
	
	public Sum(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() + right.eval();
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(right instanceof Constant && right.eval() == 0)
			return left;
		if(left instanceof Constant && left.eval() == 0)
			return right;
		return this;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Sum))
			return false;
		Sum other = (Sum) obj;
		return left.equals(other.left) && right.equals(other.right) || 
				left.equals(other.right) && right.equals(other.left); 
	}
	
	public String toString() {
		return "(" + left + "+" + right + ")";
	}
}
