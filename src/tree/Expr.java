package tree;

/** Arithmetic expression for ints*/
public abstract class Expr {

	Expr left, right;	//operands
	
	/**@return the value of this Expr*/
	public abstract int eval();
	
	/** Simplify the Expr if possible.
	 *  @return the simplified Expr
	 */
	public abstract Expr simplify();
}
