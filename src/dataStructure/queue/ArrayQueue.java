package dataStructure.queue;

public class ArrayQueue<T> implements Queue<T> {

	private int size = 8;
	
	private T[] arrayQueue = null;
	
	private int head = 0;
	
	private int tail = 0;
	
	public ArrayQueue(){
		arrayQueue = (T[])new Object[size];
	}
	
	private int size(){
		return arrayQueue.length;
	}
	
	@Override
	public boolean isEmpty() {
		return (head == tail) ? true : false;
	}

	
	public static void main(String[] args){
		ArrayQueue<String> queue = new ArrayQueue<String>();
		
	}

	@Override
	public boolean addFirst(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addLast(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

}
