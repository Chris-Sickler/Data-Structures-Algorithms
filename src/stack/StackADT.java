package stack;

/**
 * A Last-in First-out List (LIFO)
 * @author chris sickler
 * @param <E>
 */
public interface StackADT <E> {
	
	/**
	 * Add given value at top of stack.
	 * @param value
	 * @return the value that is pushed
	 */
	E push(E value);
	
	/**
	 * Remove the value on top of stack
	 * Precondition: Stack is not empty
	 * @return the removed value
	 */
	E pop();
	
	/**
	 * Precondition: Stack is not empty
	 * @return the value on top of stack
	 */
	E peek();
	
	/** Clear this StackADT */
	void clear();
	 
	/** @return true iff this StackADT is empty */
	boolean isEmpty();
	 
	/** @return the number of values in this StackADT */
	int size();
}
