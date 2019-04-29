package list;

/**
 * An Iterator for Lists. Can go either direction.
 * @author Chris Sickler
 * @param <E>
 */

public interface ListIterator <E> extends Iterator <E> {

	/**
	 * @return true if there is another previous element
	 */
	boolean hasPrevious();
	
	/**
	 * @return the value to the left of the implicit cursor.
	 */
	public E previous();
	
	/**
	 * Remove the last value obtained by a call to next() or previous().
	 */
	void remove();
	
	/** Insert the given value just prior to the implicit cursor position.  A subsequent call to previous()
    should return the inserted value, and a subsequent call to next() should be unaffected.
	 */
	public void add (E value);
}
