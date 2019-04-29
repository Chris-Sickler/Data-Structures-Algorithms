package recursion;

public class Recursion {

	public Recursion() {
		
	}
	
	/** @return the quotient when x is divided by y.
     *	Pre:   x and y are both positive
	 */
	public int div (int x, int q) {
		if(x <= q)
			return 1;
		return div(x - q, q) + 1;
	}
	
	public static void main(String args[]) {
		Recursion rec = new Recursion();
		System.out.println(rec.div(56,8));
	}
}

//Hint:  x / y = (x-y)/y + 1