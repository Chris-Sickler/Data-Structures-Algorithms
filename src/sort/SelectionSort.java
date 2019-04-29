package sort;
import list.*;

public class SelectionSort <E extends Comparable> implements Sorter<E> {
	
	List<E> list;
	
	public SelectionSort() {
		
	}
	
	public void sort(List<E> list) {
		this.list = list;
		for(int i = 0; i < list.size() - 1; i++)
			swap(i, posSmallest(i));
	}
	
	/**
	 * @return position of smalles value.
	 * @param starting position
	 */
	private int posSmallest(int start) {
		int result = start;
		for(int i = start + 1; i < list.size(); i++) {
			if(list.get(i).compareTo(list.get(result)) < 0)
				result = i;
		}
		return result;
	}
	
	private void swap(int x, int y) {
		E temp = list.get(x);
		list.set(x,  list.get(y));
		list.set(y,  temp);
	}
}
