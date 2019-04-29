package sort;
import list.*;

/**HeapSort Algorithm. Given list should be an Array List*/
public class HeapSort<E extends Comparable> implements Sorter<E> {
	
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		int last = list.size() - 1;
		heapify(0);
		while(last > 0) {
			swap(0, last);
			last--;
			percDown(0,last);
		}
	}
	
	private void swap(int x, int y) {
		E temp = list.get(x);
		list.set(x,  list.get(y));
		list.set(y,  temp);
	}
	
	private void heapify(int root) {
		int max = list.size()-1;
		if(root >= max)
			return;
		heapify(2 * root + 1); //left child
		heapify(2 * root + 2); //right child
		percDown(root, max);
	}
	
	private void percDown(int root, int max) {
		int bc = biggerChild(root, max);
		while(2 * root + 1 <= max && greater(bc, root)) {
			swap(root, bc);
			root = bc;
			bc = biggerChild(root, max);
		}
	}
	
	private int biggerChild(int root, int max) {
		int left = 2 * root + 1;
		int right = 2 * root + 2;
		if(right > max) //no right child
			return left;
		if(greater(left, right))
			return left;
		return right;
	}
	
	/**
	 * @return true iff value at position x is greater than value of position y
	 */
	private boolean greater(int x, int y) {
		return list.get(x).compareTo(list.get(y)) > 0;
	}
}
