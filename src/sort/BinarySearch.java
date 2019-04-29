//BinarySearch Class
package sort;
import list.*;
/** Search a Sorted List for a given target. For ArrayList. */
public class BinarySearch <E extends Comparable> {
List<E> list;
public BinarySearch(List<E> list) {
this.list = list;
}
/**@return a position of the given target, or -1 if not found. */
public int search(E target) {
return binSearch(0, list.size() - 1, target);
}
/**@return position if target, or -1, if not found. */
private int binSearch(int start, int end, E target) {
if(start > end)
return -1;
int mid = (start + end)/2;
int cmp = target.compareTo(list.get(mid));
if(cmp == 0) //If mid is the target
return mid;
if(cmp < 0) //If the target is in the left half
return binSearch(start, mid - 1, target);
return binSearch(mid + 1, end, target); //If the target is in the right half
}
}
