package list;

/** Iterator for ArrayList */
public class ArrayIterator <E> implements Iterator <E> {

	List<E> theList;
	int ndx = -1;		//position of last value obtained
	
	ArrayIterator(List<E> list){
		theList = list;
	}
	
	public boolean hasNext() {
		return ndx < theList.size() - 1;
	}
	
	public E next() {
		ndx++;
		return theList.get(ndx);
	}
	
	public void remove() {
		theList.remove(ndx);
		ndx--;
	}
}
