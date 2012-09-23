package dataStructure.queue;

public interface Queue<T> {
	
	boolean isEmpty();

	boolean addFirst(T element);
	
	boolean addLast(T element);
	
	T pollFirst();
	
	T pollLast();
}
