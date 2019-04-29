package sort;
import list.*;

/**An ADT for sorting Lists of values which are Comparable*/
public interface Sorter <E extends Comparable> {
	void sort(List<E> list);
}
