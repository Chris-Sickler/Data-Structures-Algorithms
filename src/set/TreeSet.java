package set;
import hash.HashTable;
import list.*;
import tree.*;

/**
 * A set using a BST. Values are in natural order
 * @author Chris Sickler
 */
public class TreeSet<E extends Comparable> implements Set<E> {

	BinaryTree<E> tree = new EmptyBinarySearchTree<E>();
	int size = 0;
	
	public boolean contains(Object obj) {
		return tree.containsKey(obj);
	}
	
	public boolean add(E value) {
		if(contains(value))
			return false;
		tree = tree.add(value);
		size++;
		return true;
	}
	
	public boolean remove(Object obj) {
		if(!contains(obj))
			return false;
		tree = tree.remove(obj);
		size--;
		return true;
	}
	
	public Iterator<E> iterator(){
		if(size==0)
			return new EmptyIterator<E>();
		return new TreeSetIterator<E>(this);
	}
	
	public void clear() {
		size = 0;
		tree = new EmptyBinarySearchTree<E>();
	}
	 
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	 
	public int size() {
		return size;
	}
	
	public Set<E> union (Set<E> other){
		Set<E> temp = new TreeSet<E>();
		Iterator<E> it = this.iterator();
		Iterator<E> it2 = other.iterator();
		
		while(it.hasNext()) {
			E next = it.next();
			if(!other.contains(next)) 
				temp.add(next);
		}
		
		while(it2.hasNext()) {
			temp.add(it2.next());
		}
		return temp;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Set))
			return false;
		Set<E> other = (Set<E>) obj;
		if(this.size != other.size())
			return false;
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {
			if(!other.contains(it.next()))
				return false;
		}
		return true;
	}
	
	public String toString() {
		Iterator<E> it = this.iterator();
		String output = "";
		while(it.hasNext())
			output += it.next().toString() + " ";
		return output;
	}
	
	public boolean isSubset(Set<E> other) {
		if(this.size > other.size())  //if this set is bigger it can't be a subset.
			return false;
		if(this.isEmpty())			  //Empty set is a subset of every set.
			return true;
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {		  //Makes sure other contains every element in this set.
			if(!other.contains(it.next()))
				return false;
		}
		return true;
	}

}
