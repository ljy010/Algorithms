package dataStructure.stack;

public interface Stack<T> {

	void push(T element);
	
	T pop();
	
	boolean isEmpty();
	
	T peek();
}
