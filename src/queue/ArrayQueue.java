package queue;
import list.*;

public class ArrayQueue <E> implements QueueADT<E>{

	List <E> list = new ArrayList<E>();
	int size = 0;    //size of queue
	int front = 0;
	int back = 0;
	
	public E remove() {
		E result = list.get(front);
		size--;
		front = (front+1) % list.size();
		return result;
	}
	
	public void add(E value) {
		if(size == list.size()) {
			list.add(back, value);
			front = (front+1) % list.size();
		}
		else {
			list.set(back, value);
		}
		back = (back+1) % list.size();
		size++;
	}
	
	public E peek() {
		if(list.isEmpty()) 
			return null;
		return list.get(front);
	}
	
	public int size() {
		return size;
	}
	 
	public void clear() {
		list.clear();
		size = 0;
		front = 0; 
		back = 0;
	}
	 
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		//for(int i = front; i <= (back +1) % list.size(); i++) {
		//	
		//}
		return list.toString();
	}
}
