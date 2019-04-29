package stack;
import list.*;

/**
 * An implementation of StackADT using a list
 * @author chris sickler
 * @param <E>
 */
public class Stack <E> implements StackADT <E> {
	List<E> list = new LinkedList<E>();
	
	public Stack() {}
	 
	public Stack(boolean arrayBased) {
		if(arrayBased)
			list = new ArrayList<E>();
	}
	
	public E push(E value) {
		list.add(value);
		return value;
	}
	
	public E pop() {
		return list.remove(list.size()-1);
	}
	
	public E peek() {
		return list.get(list.size() - 1);
	}
	
	/** Clear this StackADT */
	public void clear() {
		list.clear();
	}
	 
	/** @return true iff this StackADT is empty */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	 
	/** @return the number of values in this StackADT */
	public int size() {
		return list.size();
	}
}
