package tree;
import list.*;

/**An iterator for EBST*/
public class EmptyIterator<E> implements Iterator<E> {
	
	public boolean hasNext() {
		return false;
	}
	
	public E next() {
		return null;
	}
	
	public void remove() {
		
	}
}
