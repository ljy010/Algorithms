package dataStructure.link;

public class LinkNode<T> {

	private LinkNode<T> prevNode;
	
	private LinkNode<T> nextNode;
	
	private T data = null;
	
	public void visitData(){
		System.out.println(data);
	}

	public LinkNode<T> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(LinkNode<T> prevNode) {
		this.prevNode = prevNode;
	}

	public LinkNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkNode<T> nextNode) {
		this.nextNode = nextNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
