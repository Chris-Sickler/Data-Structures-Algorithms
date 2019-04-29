package list;

/**
 * A ListIterator for ArrayLists. ndx= implicit cursor between pos i and i+1.
 * @author sicklerc4
 * @param <E>
 */
public class ArrayListIterator <E> extends ArrayIterator <E> implements ListIterator <E>{

	private boolean forward = true; //remember direction
	
	ArrayListIterator(List<E> list){
		super(list);
	}
	
	ArrayListIterator(List<E> list, int start){
		super(list);
		ndx = start -1;
	}
	
	public boolean hasPrevious() {
		return ndx >= 0;
	}
	
	public E previous() {
		ndx--; //moves cursor left
		forward = false;
		return theList.get(ndx + 1);
	}
	
	public E next() {
		forward = true;
		return super.next();
	}
	
	public void remove() {
		if(forward) {
			theList.remove(ndx);
			ndx--;
		}
		else
			theList.remove(ndx+1);
	}
	
	public void add (E value) {
		theList.add(ndx +1, value);
		ndx++;
	}
	
}
