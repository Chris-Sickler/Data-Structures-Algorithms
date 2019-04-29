package list;

/** An Iterator for LinkedLists */
public class RefIterator<E> implements Iterator <E> {

	LinkedList<E> theList;
	Node<E> cursor;
	
	RefIterator(LinkedList<E> list){
		theList = list;
		cursor = theList.head;
	}
	
	public boolean hasNext() {
		return cursor.next != theList.tail;
	}
	
	public E next() {
		cursor = cursor.next;
		return cursor.value;	
	}
	
	public void remove() {
		cursor.prev.next = cursor.next;
		cursor.next.prev = cursor.prev;
		theList.size--;
	}
	
	/**
	 * The hasNext() call is to make sure the next list element isn't the tail. That case would cause 
	 * cursor.next.next to be null, but would also pass since it's != theList.tail.
	 */
	public boolean has2more() {
		if(hasNext() && (cursor.next.next != theList.tail))
			return true;
		return false;
	}
}
