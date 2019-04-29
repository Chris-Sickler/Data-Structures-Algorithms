package map;
import hash.*;
import list.Iterator;
import set.*;

/**
 * A map using a HashTable of Entries.
 * @author Chris Sickler
 * @version 4/22/19
 * @param <K> key
 * @param <V> value
 */
public class HashMap<K, V> implements Map<K, V> {

	//inner class
	class Entry<K,V> {
		K key;
		V value;
		Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		//Entries are equal if they both have the same key.
		public boolean equals(Object obj) {
			Entry<K,V> other = (Entry) obj;
			return key.equals(other.key);
		}
		
		public int hashCode() {
			return key.hashCode();
		}
		
		public String toString(){
			return key + "=" + value;
		}
	}
	
	HashTable<Entry<K,V>> table = new HashTable<Entry<K,V>>();
	private Entry<K,V> entry;
	
	public boolean containsKey(K key) {
		entry = new Entry<K,V>(key, null);
		return table.containsKey(entry);
	}
	
	public V get(K key) {
		entry = new Entry<K,V>(key, null);
		entry = table.get(entry);
		if(entry == null)
			return null;
		return entry.value;
	}
	
	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V>(key, value);
		Entry<K,V> oldEntry = table.get(newEntry);
		
		if(oldEntry == null) {
			table.put(newEntry);
			return null;
		}
		
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
	}

	public V remove(K key) {
		entry = new Entry<K,V>(key, null);
		entry = table.get(entry);
		if(table.remove(entry))
			return entry.value;
		return null;
	}
	
	public void clear() {
		table.clear();
	}
	
	public boolean isEmpty() {
		return table.isEmpty();
	}
	
	public int size() {
		return table.size();
	}
	
	public String toString() {
		int i = 0;
		String result = "[";
		
		Iterator<Entry<K,V>> it = table.iterator();
		while(it.hasNext() && i < table.size()-1) {
			result += it.next().toString() + ",";
			i++;
		}
		return result + it.next() + "]";
	}
	
	public Set<K> keySet(){
		Set<K> keys = new HashSet<K>();
		Iterator<Entry<K,V>> it = table.iterator();
		while(it.hasNext()) {
			keys.add(it.next().key);
		}
		return keys;
	}
}
