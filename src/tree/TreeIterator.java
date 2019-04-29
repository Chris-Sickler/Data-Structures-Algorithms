package tree;
import list.*;
import queue.*;

/**An iterator for BST, using Inorder traversal*/
public class TreeIterator<E> implements Iterator<E> {
	
	BinaryTree<E> tree;
	QueueADT<E> queue = new Queue<E>();
	E lastGotten;     //last value obtained by call to next
	
	public TreeIterator(BinaryTree<E> tree){
		this.tree = tree;
		buildQ(tree);
	}
	
	//  Add all values in the given BT to a queue, 
	//  using an inorder traversal of the BT
	private void buildQ(BinaryTree< E> tree)
	{  
		if (! tree.getLeft().isEmpty())
	        buildQ (tree.getLeft());
		queue.add(tree.getValue());
		if (! tree.getRight().isEmpty())
	        buildQ (tree.getRight());
	}
/**	
	private void buildQ(BinaryTree< E> tree)
	{  
		if (! tree.getLeft().isEmpty())
	        buildQ (tree.getLeft());
		if (! tree.getRight().isEmpty())
	        buildQ (tree.getRight());
		queue.add(tree.getValue());
	}
*/	
	public boolean hasNext() {
		return ! queue.isEmpty();
	}
	
	public E next() {
		E lastGotten = queue.remove();
		return lastGotten;
	}
	
    /** Pre: The elements are unique.     
     *  Pre: The size of the tree > 1.     
     */    
	public void remove() {          //  This fails if lastGotten is the root and has 0 or 1 child.
           //    tree = tree.remove (lastGotten); 
		if (!tree.getLeft().isEmpty() && !tree.getRight().isEmpty() 
              || ! tree.getValue().equals(lastGotten))   // 2 children or removing root?          
		{   
			tree = tree.remove(lastGotten); 
			return; 
		}
		E repl;                      // Replacement value 
		if (tree.getLeft().isEmpty())   
            repl = getSuccessorValue(); 
     	else 
            repl = getPredecessorValue(); 
		tree.remove(repl); 
		tree.setValue (repl); 
	}
	
	private E getSuccessorValue() {
		BinaryTree<E> temp = tree.getRight();
		while (!temp.getLeft().isEmpty())
			temp = temp.getLeft();
		return temp.getValue();
	}
	
	private E getPredecessorValue() {
		BinaryTree<E> temp = tree.getLeft();
		while (!temp.getRight().isEmpty())
			temp = temp.getRight();
		return temp.getValue();
	}
	
	public E getLastGotten() {
		return lastGotten;
	}
	
	
}
