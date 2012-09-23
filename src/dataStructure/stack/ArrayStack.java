package dataStructure.stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<T> implements Stack<T> {
	
	private int top = -1;
	
	private List<T> array = null;
	
	private int size(){
		return array.size();
	}
	
	public ArrayStack(){
		array = new ArrayList<T>();
		top = size() - 1;
	}

	@Override
	public void push(T element) {
		array.add(element);
		top = size() - 1;
	}

	@Override
	public T pop() {
		if(top < 0){
			throw new RuntimeException("empty stack!");
		}
		T element = array.remove(top);
		top = size() - 1;
		return element;
	}

	@Override
	public boolean isEmpty() {
		return top < 0 ? true : false;
	}

	@Override
	public T peek() {
		return array.get(top);
	}
	
	public static void main(String[] args){
		ArrayStack<String> stringArrayStack = new ArrayStack<String>();
		stringArrayStack.push("aaaa");
		stringArrayStack.push("bbb");
		String element = stringArrayStack.pop();
		System.out.println(element);
		element = stringArrayStack.peek();
		System.out.println(element);
		element = stringArrayStack.pop();
		System.out.println(element);
	}

}
