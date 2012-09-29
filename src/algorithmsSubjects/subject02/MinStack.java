package algorithmsSubjects.subject02;

import java.util.Stack;

/**
 * 设计包含min函数的栈。
定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。
要求函数min、push以及pop的时间复杂度都是O(1)。
 * @author linjy
 *
 */
public class MinStack<T extends Comparable<T>> {
	
	private Stack<T> valueStack = new Stack<T>();
	
	private Stack<T> minStack = new Stack<T>();
	
	private T currentMin;
	
	public T pop(){
		T val = valueStack.pop();
		minStack.pop();
		currentMin = minStack.peek();
		return val;
	}

	public void push(T val){
		valueStack.push(val);
		if((minStack.isEmpty()) || (currentMin.compareTo(val) > 0)){
			currentMin = val;
			
		}
		minStack.push(currentMin);
	}
	
	public T min(){
		return currentMin;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack<Integer> minStack = new MinStack<Integer>();
		minStack.push(12);
		minStack.push(15);
		System.out.println(minStack.min());
		minStack.push(6);
		minStack.push(23);
		System.out.println(minStack.min());
		
	}

}
