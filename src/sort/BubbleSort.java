package sort;
import list.*;

/**A sorting algorithm called BubbleSort*/
public class BubbleSort<E extends Comparable> implements Sorter<E> {
	
	List <E> list;
	boolean swapped = false;
	
	public BubbleSort() {
		
	}
	
	public void sort(List<E> list) {
		this.list = list;
		boolean breakLoop = false;
		if(!breakLoop) {
			for(int i = 0; i < list.size() - i - 1; i++) {
				
				for(int j = 0; j < list.size() - 1; j++) {
					if(list.get(j).compareTo(list.get(j+1)) > 0)
						swap(j, j+1);
						boolean swapped = true;
				}
				
				if(!swapped)
					breakLoop = true;
					
			}
		}
	}
	
	private void swap(int x, int y) {
		E temp = list.get(x);
		list.set(x,  list.get(y));
		list.set(y,  temp);
	}
}
