package tree;
import list.*;

/*
 * A BT which satisifes propertires of BST
 */
public class BinarySearchTree<E extends Comparable> implements BinaryTree<E> {

	E value;
	BinaryTree<E> left = new EmptyBinarySearchTree<E>();
	BinaryTree<E> right = new EmptyBinarySearchTree<E>();
	
	public BinarySearchTree(E value)
	{
		this.value = value;
	}
	@Override
	public E getValue() {		//E return type
		return value;
	}

	
	public E get(E value) {	//E return type
		int cmp = this.value.compareTo(value);
		if(cmp ==0) return this.value;
		if(cmp < 0) return right.get(value);
		return left.get(value);
	}

	@Override
	public boolean containsKey(Object obj) {
		int cmp = this.value.compareTo(obj);
		if(cmp ==0) return true;
		if(cmp <0) return right.containsKey(obj);
		return left.containsKey(obj);
	}

	
	public BinaryTree<E> add(E value) {
		int cmp = this.value.compareTo(value);
		if(cmp < 0 )
			right = right.add(value);
		if(cmp > 0)
			left = left.add(value);
		return this;
	}

	@Override
	public BinaryTree<E> remove(Object obj) {
		int cmp = value.compareTo(obj);
		if(cmp<0)
			right = right.remove(obj);
		else if (cmp > 0)
			left = left.remove(obj);
		else //found the obj == value
		{
			List <BinaryTree<E>> kids = children();
			if(kids.size()==0)	//no children
				return new EmptyBinarySearchTree<E>();
			if(kids.size()==1)	//one child
				return kids.get(0);
			//Two Children
			BinaryTree<E> successor = getSuccessor();
			remove(successor.getValue());
			value = successor.getValue();
		}
			return this;
		}		
				
		private BinaryTree<E> getSuccessor() {
		BinaryTree<E> result = right;
			while(!result.getLeft().isEmpty())
				result = result.getLeft();
			
		return result;
	}
	private List<BinaryTree<E>> children() {
		List<BinaryTree<E>> result = new LinkedList<BinaryTree<E>>();
		if(!left.isEmpty())
			result.add(left);
		if(!right.isEmpty())
			result.add(right);
		return result;
	}
	@Override
	public BinaryTree<E> getLeft() {
		return left;
	}

	@Override
	public BinaryTree<E> getRight() {
	
		return right;
	}

	public void setLeft(BinaryTree<E> left) {
		this.left = left;
	}

	public void setRight(BinaryTree<E> right) {
		this.right = right;
	}

	@Override
	public void setValue(E value) {
		this.value = value;
	}
	
	public boolean isEmpty() {
		return false;
	}

	public Iterator<E> iterator(){
		return new TreeIterator<E>(this);
	}
	
	public String toString() {
		String treeString = "[";
		Iterator<E> it = iterator();
		while(it.hasNext()) {
			treeString += it.next() + " ";
		}
		return treeString + "]";
	}
	
	//Final Exam
	public int height() {
		if(this.isEmpty())
			return 0;
		if(right.isEmpty())
			return 1 + left.height();
		if(left.isEmpty())
			return 1 + right.height();
		if(left.height() > right.height())
			return 1 + left.height();
		return 1 + right.height();
	}
}
