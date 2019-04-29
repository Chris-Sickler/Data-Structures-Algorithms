package list;

/**
 * @author Chris Sickler
 * @version 02/05/2019
 * 
 */
 
public class LinkedList<E> implements List<E> {
	
	int size = 0;
	Node<E> head = new Node<E>(null, null, null);
	Node<E> tail = new Node<E>(null, null, head);
	private Node<E> ref;
	
	public LinkedList() {
		head.next = tail;
		
	}
	
	/** Add the given value at the end */
	public void add(E value) {
		
		Node<E> temp = new Node<E>(value, tail, tail.prev);
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
		
	}
	
	/** Insert given value at given position in this list
 		@param 0 <= ndx <= size
	 */
	public void add(int ndx, E value) {
		setRef(ndx);
		Node<E> temp = new Node<E>(value, ref, ref.prev);
		ref.prev.next = temp;
		ref.prev = temp;
		size++;
	}
	
	/**@return value at given ndx
	   @param 0 <= ndx < size
	 */
	public E get(int ndx) {
		setRef(ndx);
		return ref.value;
	}
	
	/** Change the value at given ndx to given value
 		@return old value
 		@param 0 <= ndx < size
	 */
	public E set(int ndx, E value) {
		setRef(ndx);
		E result = ref.value;
		ref.value = value;
		return result;
	}
	
	/** Remove the value at given ndx from this list
 		@return the value which was removed
 		@param 0 <= ndx < size
	 */
	public E remove(int ndx) {
		setRef(ndx);
		ref.prev.next = ref.next;
		ref.next.prev = ref.prev;
		size--;
		return ref.value;
	}
	
	private void setRef(int ndx) {
		if(ndx < size/2) {
			ref = head.next;
			for(int i = 0; i < ndx; i++)
				ref = ref.next;
		}
		else{ 
			ref = tail.prev;
			for(int i = 0; i < (size - ndx - 1) ; i++)
				ref = ref.prev;
		}
	}
	
	/** 
	 * @return the position of the first occurrence of the given Object in this List,
	 * or -1 if it is not in this List  
	 */
	public int indexOf(Object obj) {
		ref = head.next;
		for(int index = 0; index < size(); index++) {
			if(ref.value.equals(obj)) {
				return index;
			}
		ref = ref.next;
		}			
		return -1;
	}
	
	public boolean contains(Object obj) {
		if(indexOf(obj) == -1) 
			return false;
		
		return true;
	}

	/** Clear this List */
	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/** @return true iff this List is empty */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	/** @return the size of this List */
	public int size() {
		
		return size;
	}
	
	public String toString() {
		ref = head.next;
		String list = "[";
		for(int i = 0; i < size() - 1; i++) {
			list += ref.value + ", ";
			ref = ref.next;
		}
		return list + ref.value + "]";
	}
	
	public Iterator<E> iterator(){
		return new RefIterator<E>(this);
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
		return new RefListIterator<E>(this);
	}
	
	public ListIterator <E> listIterator(int start){
		return new RefListIterator<E>(this, start);
	}
}

