//QuickSort Class
package sort;
import list.*;
/** Quick Sort Algorithm. Efficient for ArrayList. */
public class QuickSort<E extends Comparable> implements Sorter<E> {
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		qSort(0, list.size() - 1);
	}
	
	/** Sort the part of the list beginning at start and ending at end */
	private void qSort(int start, int end) {
		if(end - start < 1)
			return;
		int p = partition(start, end);
		qSort(start, p - 1); //Sorting the left part
		qSort(p + 1, end); //Sorting the right part
	}
	
	/** Choose the start value as the pivot
	* Post: All values to the left of p are smaller than the pivot value
	* and all values to the right of p are larger than or equal to the pivot value
	* @return the position of the pivot value */
	private int partition(int start, int end) {
		E pivot = list.get(start);
		int p = start;
		for(int i = start + 1; i <= end; i++)
			if(list.get(i).compareTo(pivot) < 0) {
				list.set(p, list.get(i));
				p++;
				list.set(i, list.get(p));
			}
		list.set(p, pivot);
		return p;
	}
}
