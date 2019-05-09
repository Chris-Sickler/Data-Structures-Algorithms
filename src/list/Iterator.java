package list;

/** Allow the client to visit each value in a collection */
public interface Iterator <E> {

	/**
	 * @return true iff there are more values
	 */
	boolean hasNext();
	
	/**
	 * @return the next value from the collection.
	 * Precondition: hasNext() is true.
	 */
	E next();
	
	/** 
	 * Remove the last value obtained by next().
	 * Precondition: next() has been called at least once since last call to remove().
	 */
	void remove();
	
	/** @return true iff there are at least two more items remaining 
	  * to be visited for this Iterator */
	boolean has2more();	
}
