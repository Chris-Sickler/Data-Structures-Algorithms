package set;
import list.*;
import tree.Sum;
import hash.*;

/**
 * A set using a hash table
 * @author Chris Sickler
 * @version 04/23/19
 */
public class HashSet<E> implements Set<E>{
	
	HashTable<E> table;
	int size = 0;
	
	public HashSet() {
		this(10);
	}
	
	public HashSet(int cap) {
		table = new HashTable<E>(cap);
	}
	
	public boolean contains(Object obj) {
		return table.containsKey(obj);
	}
	
	public boolean add(E value) {
		if(contains(value))
			return false;
		table.put(value);
		size++;
		return true;
	}
	
	public Iterator<E> iterator() {
		return table.iterator();
	}
	
	public boolean remove(Object obj) {
		size--;
		return table.remove(obj);
	}

	public void clear() {
		size = 0;
		table = new HashTable<E>(10);
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
		Set<E> temp = new HashSet<E>();
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
	
	//Final Exam
	public Set<E> intersection(Set <E> other){
		if(this.isEmpty()) 
			return this;
		if(other.isEmpty())
			return other;
		Set<E> temp = new HashSet<E>();
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {
			E next = it.next();
			if(other.contains(next)) 
				temp.add(next);
		}
		return temp;
	}
}
