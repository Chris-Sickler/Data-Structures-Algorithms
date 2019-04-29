package queue;

/** A FIFO list */
public interface QueueADT <E>{
	/**
	 * Add the given value at the back of this QueueADT
	 */
	void add(E value);
	
	/**
	 * Remove value at front of QueueADT.
	 * Pre: Queue is not empty.
	 * @return value removed
	 */
	E remove();
	
	/**
	 * @return value at front of QueueADT, or null if empty.
	 */
	E peek();

	/** @return the size of this QueueADT */
	int size();
	 
	/** Clear this QueueADT */
	void clear();
	 
	/** @return true iff this QueueADT is empty */
	boolean isEmpty();
}
