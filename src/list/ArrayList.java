package list;

/**
 * ArrayList
 * @author Chris Sickler
 * @version 02/05/2019
 * @param <E>
 */

public class ArrayList <E> implements List<E> {
	
	int size = 0;
	E[] values;
	
	/** Constructor */
	public ArrayList() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int cap) {
		values = (E[])new Object[cap];
	}
	
	/**@return value at given ndx
	   @param 0 <= ndx < size
	 */
	public E get(int ndx) {
		return values[ndx];
	}
	
	/** Change the value at given ndx to given value
 		@return old value
 		@param 0 <= ndx < size
	 */
	public E set(int ndx, E value) {
		E result = values[ndx];
		values[ndx] = value;
		return result;
	}
	
	/** Add the given value at the end */
	public void add(E value) {
		add(size, value);
	}
	
	/** Insert given value at given position in this list
 		@param 0 <= ndx <= size
	 */
	public void add(int ndx, E value) {
		if(size == values.length)
			alloc();
		
		for(int i = size; i > ndx; i--)
			values[i] = values[i - 1];
		
		values[ndx] = value;
		size++;
	}
	
	@SuppressWarnings("unchecked")
	private void alloc() {
		E[] temp = (E[])new Object[values.length * 2];
		
		for(int i = 0; i < size; i++)
			temp[i] = values[i];
		
		values = temp;
	}
	
	/** Remove the value at given ndx from this list
 		@return the value which was removed
 		@param 0 <= ndx < size
	 */
	public E remove(int ndx) {
		E result = values[ndx];
		
		for(int i = ndx; i < size - 1; i++)
			values[i] = values[i + 1];
		size--;
		return result;
	}
	
	/** @return the size of this List */
	public int size() {
		return size;
	}
	
	/** Clear this List */
	public void clear() {
		size = 0;
	}
	
	/** @return true iff this List is empty */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public int indexOf(Object obj) {
		for(int index = 0; index < size(); index++) {
			if(values[index].equals(obj))
				return index;
			
		}
		return -1;
	}
	
	public boolean contains(Object obj) {
		if(indexOf(obj) == -1) 
			return false;
		
		return true;
	}

	/** @return this List as a String  */
	public String toString() {
		String listString = "[";
		
		if(isEmpty()) 
			return "[ ]";
		for(int i = 0; i < size()-1; i++)
			listString += values[i] + ", ";
		
		return listString + values[size()-1] + "]";
	}
	
	/** 
	 * @return the index of the last occurrence of obj
	 *  in this ArrayList, or -1 if not found
	 */
	public int indexOfLast(Object obj) {
		for(int index = size() - 1; index == 0; index--) {
			if(values[index].equals(obj))
				return index;
		}
		
		return -1;
	}
	
	public Iterator<E> iterator(){
		return new ArrayIterator<E>(this);
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof List)) 
			return false;
		
		List localList = (List)obj;
		if(localList.size() == this.size()) {
			Iterator<E> it1 = localList.iterator();
			Iterator<E> it2 = this.iterator();
			
			while(it1.hasNext()) {
				if(!(it1.next().equals(it2.next())))
					return false;
			}
		}
		
		return true;
	}
	
	public boolean remove(Object obj) {
		if(contains(obj)) {
			remove(indexOf(obj));
			return true;
		}
		return false;
	}
	
	public ListIterator <E> listIterator(){
		return new ArrayListIterator<E>(this);
	}
	
	public ListIterator <E> listIterator(int start){
		return new ArrayListIterator<E>(this, start);
	}
}
