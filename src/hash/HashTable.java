package hash;
import list.*;

/**Use a list of list for quick access to data(may be duplicates)
 *@author Chris Sickler 
 */
public class HashTable <K> {

	int size = 0;
	List<List<K>> lists;
	
	public HashTable() {
		this(10);
	}
	
	public HashTable(int cap) {
		lists = new ArrayList<List<K>>(cap);
		for(int i = 0; i < cap; i++) 
			lists.add(new LinkedList<K>());
	}
	
	/**@return true iff this hashtable contains given key*/
	public boolean containsKey(Object obj) {
		int ndx = getIndex(obj);
		return lists.get(ndx).contains(obj);
	}
	
	/**
	 * @return the key in this HashTable, which equals given key, or null if not in table
	 */
	public K get(K key) {
		int ndx = getIndex(key);
		List<K> list = lists.get(ndx);
		ndx = list.indexOf(key);
		if(ndx < 0)   		//key is not in table
			return null;
		return list.get(ndx);
	}
	
	 /** @return a valid index to lists using given object*/
	private int getIndex(Object obj) {
		int ndx = obj.hashCode();
		ndx = Math.abs(ndx);
		ndx = ndx % lists.size();
		return ndx;
	}
	
	/**Put the given key into this HashTable*/
	public void put(K key) {
		int ndx = getIndex(key);
		lists.get(ndx).add(key);
		size++;
	}
	
	/**Remove the given obj from this HashTable if possible
	 * @return true iff it was removed
	 */
	public boolean remove(Object obj) {
		int ndx = getIndex(obj);
		List<K>  list = lists.get(ndx);
		if(list.remove(obj)) {
			size--;
			return true;
		}
		return false;
	}
	
	/** @return the number of keys in this HashTable */
	public int size() {
		return size;
	}
	 
	/** Clear this HashTable  */
	public void clear() {
		size = 0;
		lists = new ArrayList<List<K>>(10);
		for(int i = 0; i < 10; i++) 
			lists.add(new LinkedList<K>());
		
	}
	 
	/** @return true iff this HashTable is empty */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	public Iterator<K> iterator(){
		return new TableIterator<K>(this);
	}
	
	public String toString() {
		Iterator<K> it = this.iterator();
		String output = "";
		while(it.hasNext()) {
			output += it.next().toString();
		}
		return output;
	}
}
