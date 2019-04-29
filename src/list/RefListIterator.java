package list;

/**
 * A ListIterator for LinkedLists
 * @author Chris Sickler
 */
public class RefListIterator <E> extends RefIterator <E> implements ListIterator <E>{
	
	private boolean forward = true;
	
	public RefListIterator(LinkedList<E> list) {
		super(list);
	}
	
	public RefListIterator(LinkedList<E> list, int start) {
		super(list);
		cursor = theList.head;
		for(int i = 0; i < start; i++)
			cursor = cursor.next;
	}
	
	public boolean hasNext() {
		if(theList.isEmpty())
			return false;
		return cursor.next != theList.tail;
	}
	
	public E next() {
		if(forward)
			cursor = cursor.next;
		forward = true;
		return cursor.value;
	}
	
	public boolean hasPrevious() {
		if(!forward)
			return cursor.prev != theList.head;
		return cursor != theList.head;
	}
	
	public E previous() {
		if(!forward)
			cursor = cursor.prev;
		forward = false;
		return cursor.value;
	}
	
	public void remove() {
		super.remove();
		if(!forward)
			cursor = cursor.next;
		else
			cursor = cursor.prev;
	}
	
	public void add (E value) {
		if(forward) {
			Node<E> temp = new Node<E>(value, cursor.next, cursor);
			cursor.next.prev = temp;
			cursor.next = temp;
			cursor = temp;
			theList.size++;
		}
		else {
			Node<E> temp = new Node<E>(value, cursor, cursor.prev);
			cursor.prev.next = temp;
			cursor.prev = temp;
			theList.size++;
		}
	}
}
