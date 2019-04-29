package list;

/** 
 * A list is an abstract data type for a collection maintaining order, with duplicates permitted 
 * @author Chris Sickler
 * @version 02/05/2019
 */

public interface List <E> {
	
	/**@return value at given ndx
	   @param 0 <= ndx < size
	 */
	E get(int ndx);
	
	/** Change the value at given ndx to given value
	 	@return old value
	 	@param 0 <= ndx < size
	 */
	E set(int ndx, E value);
	
	/** Add the given value at the end */
	void add(E value);
	
	/** Insert given value at given position in this list
	 	@param 0 <= ndx <= size
	 */
	void add(int ndx, E value);
	
	/** Remove the value at given ndx from this list
	 	@return the value which was removed
	 	@param 0 <= ndx < size
	 */
	E remove (int ndx);
	
	/** Clear this List */
	void clear();
	
	/** @return true iff this List is empty */
	boolean isEmpty();

	/** @return the size of this List */
	int size();
	
	/** 
	 * @return the position of the first occurrence of the given Object in this List,
	 * or -1 if it is not in this List  
	 */
	int indexOf (Object obj);
	
	/** @return true only if the given Object is in this List */
	boolean contains (Object obj);
	
	/** @return true only if the parameter obj is a List and 
	 * contains the same elements (in the same sequence) as this List. 
	 */
	boolean equals (Object obj);

	/**@return an Iterator */
	Iterator<E> iterator();
	
	/**  Remove the first occurrence of the given object from this List, if possible.
	  *  @return true iff it was removed.
	*/
	boolean remove (Object obj);	
	
	ListIterator <E> listIterator();
	
	ListIterator <E> listIterator(int start);
}