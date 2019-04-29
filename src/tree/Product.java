package tree;

/** Result of multiplying two Exprss
 * 
 * @author chris sickler
 * @version 04/02/2019
 */
public class Product extends Expr {
	
	public Product(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() * right.eval();
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(right instanceof Constant && right.eval() == 1)
			return left;
		if(left instanceof Constant && left.eval() == 1)
			return right;
		if(right instanceof Constant && right.eval() == 0)
			return right;
		if(left instanceof Constant && left.eval() == 0)
			return left;
		return this;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return left.equals(other.left) && right.equals(other.right) || 
				left.equals(other.right) && right.equals(other.left); 
	}
	
	public String toString() {
		return "(" + left + "*" + right + ")";
	}
}
