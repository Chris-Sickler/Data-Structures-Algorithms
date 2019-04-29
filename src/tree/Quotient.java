package tree;

/** Result of dividing two Exprss
 * 
 * @author chris sickler
 * @version 04/02/2019
 */
public class Quotient extends Expr {
	
	public Quotient(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() / right.eval();
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left instanceof Constant && right.eval() == 0)
			return null;
		if(right instanceof Constant && left.eval() == 0)
			return new Constant(0);
		if(left instanceof Constant && right.eval() == 1)
			return left;
		if(left.equals(right))
			return new Constant(1);
		//if(left.right.equals(right.right))
			//return this;
		//if(left.left.equals(right.left))
			//return this;
		return this;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Quotient))
			return false;
		Quotient other = (Quotient) obj;
		return left.equals(other.left) && right.equals(other.right); 
	}
	
	public String toString() {
		return "(" + left + "/" + right + ")";
	}
	
	/** For Quiz 5 problem 3a I see
	 * 				/
	 * 			/		/
	 * 		 a	  b   c    b	
	 * as my tree. I figure left.right.equals(right.right) will check 
	 * for equivalence in the denominator. I just can't figure out how to 
	 * return the expression.
	 */
}
