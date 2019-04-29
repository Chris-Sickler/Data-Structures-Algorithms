package map;


import list.Iterator;
import set.HashSet;
import set.Set;
import tree.*;

/**
 * A map using a Binary Tree of Entries.
 * @author Chris Sickler
 * @version 4/22/19
 * @param <K> key
 * @param <V> value
 */
public class TreeMap <K extends Comparable, V> implements Map<K,V> {
	
	//inner class
	class Entry<K extends Comparable,V> implements Comparable<Entry<K,V>> {
		K key;
		V value;
		Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public int compareTo(Entry<K,V> other) {
			return key.compareTo(other.key);
		}
		
		public String toString(){
			return key + "=" + value;
		}
	}
	
	BinaryTree<Entry<K,V>> tree = new EmptyBinarySearchTree<Entry<K,V>>();
	int size = 0;	
	
	public boolean containsKey(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		return tree.containsKey(entry);
	}
	
	public V get(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = tree.get(entry);
		if(entry == null)
			return null;
		return entry.value;
	}
	
	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V>(key, value);
		Entry<K,V> oldEntry = tree.get(newEntry);
		
		if(oldEntry == null) {
			tree = tree.add(newEntry);
			size++;
			return null;
		}
		
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
	}

	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = tree.get(entry);
		if(entry == null)
			return null;
		tree = tree.remove(entry);
		size--;
		return entry.value;
	}
	
	public void clear() {
		tree = new EmptyBinarySearchTree<Entry<K,V>>();
	}
	
	public boolean isEmpty() {
		return tree.isEmpty();
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		if(this.isEmpty())
			return "[]";
		Iterator<Entry<K,V>> it = tree.iterator();
		String result = "[";
		while(it.hasNext()) {
			result += it.next().toString() + ",";
		}
		return result + "]";
	}
	
	public Set<K> keySet(){
		Set<K> keys = new HashSet<K>();
		Iterator<Entry<K,V>> it = tree.iterator();
		while(it.hasNext()) {
			keys.add(it.next().key);
		}
		return keys;
	}
}
