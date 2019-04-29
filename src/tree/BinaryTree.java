package tree;
import list.*;


/**
 * A Binary Tree ( BT ) may have a value, 2 children
 * @author chris sickler
 *
 * @param <E>
 */
public interface BinaryTree<E>
{

	/*@ return the value of BT*/
	E getValue();
	
	/**
	 * Search BT for a value, return value or null if not found
	 */
	E get(E value);

	/**
	 * @ return truee iff the given object is in family of this BT
	 */
	boolean containsKey(Object obj);
	
	/**
	 * add given value to family of BT, 
	 * @return resulting BT
	 */
	BinaryTree<E> add(E value);
	
	/**
	 * Remove given value from family of BT, if possible
	 * Return new BT.
	 */
	BinaryTree<E> remove(Object obj);
	
	/**
	 * getters setters
	 */
	BinaryTree<E> getLeft();
	
	BinaryTree<E> getRight();
	
	void setLeft(BinaryTree<E> left);
	void setRight(BinaryTree<E> right);
	void setValue(E value);

	boolean isEmpty();
	
	/** @return an Inorder iterator for this BT */
	Iterator<E> iterator();
	
	
}
