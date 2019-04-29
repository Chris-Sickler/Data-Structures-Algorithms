package tree;

/** An Expr which is a constant int
 * 
 * @author chris sickler
 * @version 04/02/2019
 */
public class Constant extends Expr {
	
	int value;
	
	public Constant(int value) {
		this.value = value;
	}
	
	public int eval() {
		return value;
	}
	
	public Expr simplify() {
		return this;
	}
	
	public boolean equals(Object obj) {
		Constant other = null;
		if(obj instanceof Constant)
			other = (Constant) obj;
		return this.value == other.value;
	}
	
	public String toString() {
		return value + "";
	}
}
