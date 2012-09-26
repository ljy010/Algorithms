package dataStructure.queue;

public class ArrayQueue<T> implements Queue<T> {
	
	private static int MIN_SIZE = 4;

	private int size = MIN_SIZE;
	
	private T[] arrayQueue = null;
	
	private int head = 0;
	
	private int tail = 0;
	
	public ArrayQueue(){
		arrayQueue = (T[])new Object[size];
	}
	
	public ArrayQueue(int iniSize){
		initCapacity(iniSize);
	}
	
	/**
	 * 分配2的整数倍的空间
	 * @param elementNums
	 */
	private void initCapacity(int elementNums){
		int iniCapaticy = MIN_SIZE;
		if(elementNums >= MIN_SIZE){
			iniCapaticy = elementNums;
			iniCapaticy |= iniCapaticy >>> 1;
			iniCapaticy |= iniCapaticy >>> 2;
			iniCapaticy |= iniCapaticy >>> 4;
			iniCapaticy |= iniCapaticy >>> 8;
			iniCapaticy |= iniCapaticy >>> 16;
			iniCapaticy++;
			if(iniCapaticy < 0 ){
				iniCapaticy = iniCapaticy >>> 1;
			}
		}
		arrayQueue = (T[])new Object[iniCapaticy];
	}
	public int size(){
		return (tail - head) & (arrayQueue.length - 1);
	}
	
	@Override
	public boolean isEmpty() {
		return (head == tail);
	}
	
	public int length(){
		return arrayQueue.length;
	}

	
	public static void main(String[] args){
		ArrayQueue<String> queue = new ArrayQueue<String>(5);
		queue.addFirst("aaa");
		queue.addFirst("bbb");
		queue.addLast("ccc");
		queue.addLast("dddd");
		queue.addFirst("eee");
		queue.addFirst("fff");
		System.out.println(queue.length());
		String f = queue.pollFirst();
		System.out.println(f);
	}
	
	private void doubleCapaticy(){
		int h = head;
		int n = arrayQueue.length;
		int r = n - h;
		int newCapacity = n << 1;
		T[] a = (T[]) new Object[newCapacity];
		System.arraycopy(arrayQueue, h, a, 0, r);
		System.arraycopy(arrayQueue, 0, a, r, h);
		arrayQueue = a;
		head = 0;
		tail = n;
	}

	@Override
	public boolean addFirst(T element) {
		head = (head - 1) & (arrayQueue.length - 1);
		arrayQueue[head] = element;
		if(head == tail){
			doubleCapaticy();
		}
		return true;
	}

	@Override
	public boolean addLast(T element) {
		arrayQueue[tail] = element;
		tail = (tail + 1) & (arrayQueue.length - 1);
		if(head == tail){
			doubleCapaticy();
		}
		return false;
	}

	@Override
	public T pollFirst() {
		T element = arrayQueue[head];
		if(element == null){
			return null;
		}
		arrayQueue[head] = null;
		head = (head + 1) & (arrayQueue.length - 1);
		return element;
	}

	@Override
	public T pollLast() {
		int t  = (tail - 1) & (arrayQueue.length - 1);
		T element = arrayQueue[t];
		if(element == null){
			return null;
		}
		arrayQueue[t] = null;
		tail = t;
		return element;
	}

}
