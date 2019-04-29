package tree;
import list.*;

public class EmptyBinarySearchTree<E extends Comparable> implements BinaryTree<E> {
	
	@Override
	public E getValue() {
		
		return null;
	}

	
	public E get(E value) { //Should bE E not object but error
		return null;
	}

	@Override
	public boolean containsKey(Object obj) {
		return false;
	}

	
	public BinaryTree<E> add(E value) {
		return new BinarySearchTree<E>(value);
	}

	public BinaryTree<E> remove(Object value) {
		
		return this;
	}


	public BinaryTree<E> getLeft() {
		return null;
	}


	public BinaryTree<E> getRight() {
		return null;
	}

	public void setLeft(BinaryTree<E> left) {
		
	}

	public void setRight(BinaryTree<E> right) {
		
	}

	public void setValue(E value) {
		
	}
	
	public boolean isEmpty() {
		return true;
	}
	
	public Iterator<E> iterator() {
		return new EmptyIterator<E>();
	}

}