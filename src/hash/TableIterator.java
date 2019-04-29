package hash;
import list.*;

/**An Iterator for HashTables*/
public class TableIterator<K> implements Iterator<K> {
	HashTable<K> table;
	int ndx=0; //currently iterating through this LL
	Iterator<K> itty; //Iterator for a Linked List
	
	/** Set itty to the given list*/
	private void setItty(int ndx) {
		itty = table.lists.get(ndx).iterator();
	}
	
	/**@return the position of the next non-empty LL, or -1 if none*/
	private int nextList() {
		for(int i = ndx + 1; i < table.lists.size(); i++) {
			if(!table.lists.get(i).isEmpty())
				return i;
		}
		return -1;
	}
	
	public TableIterator(HashTable<K> table) {
		this.table = table;
		setItty(0);
	}
	
	public boolean hasNext() {
		if(itty.hasNext())
			return true;
		return nextList() > 0;
	}
	
	public K next() {
		if(!itty.hasNext()) {
			ndx = nextList();
			setItty(ndx);
		}
		return itty.next();
	}
	
	public void remove() {
		itty.remove();
		table.size--;
	}
}
