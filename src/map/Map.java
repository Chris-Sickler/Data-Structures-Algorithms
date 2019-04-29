package map;
import set.*;

/**
 * Values associated with unique keys. Lookup of keys is efficient.
 * @author Chris Sickler
 * @version 4/22/19
 * @param <K> key
 * @param <V> value
 */
public interface Map<K, V> {

	/**
	 * @return true iff the map contains the given key
	 */
	boolean containsKey(K key);
	
	/**
	 * @return the value associated with the given key or null if none.
	 */
	V get(K key);
	
	/**
	 * Put a new entry into map with given key and value.
	 * @return old value or null.
	 */
	V put(K key, V value);
	
	/**
	 * Remove the entry that has the given key.
	 * @return it's value or null.
	 */
	V remove(K key);
	
	/** Clear this Map */
	void clear();
	 
	/** @return true iff this Map is empty */
	boolean isEmpty();
	 
	/** @return the number of entries in this Map  */
	int size();
	
	/**  @return the entries in this Map as a String, in the format key=value */
	String toString();
	
	/** @ return a Set of all the keys in this Map */
	Set< K> keySet();
	
}
