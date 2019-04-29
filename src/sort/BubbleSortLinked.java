//BubbleSortLinked Class
package sort;
import list.*;

/** Sort a Linked List. O(n^2) runtime. */
public class BubbleSortLinked <E extends Comparable> implements Sorter<E> {
	
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		ListIterator<E> it;
		E left, right;
		for(int i = 0; i < list.size() - 1; i++) {
			it = list.listIterator();
			right = it.next();
			for(int j = 0; j < list.size() - i - 1; j++) {
				left = right;
				right = it.next();
				if(left.compareTo(right) > 0) {
					it.remove();
					it.previous();
					it.add(right);
					right = it.next();
				}
			}
		}
	}
}