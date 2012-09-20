package tree.binaryTree;

public class BinaryTreeNode<T> {
	
	private BinaryTreeNode<T> leftChild = null;
	
	private BinaryTreeNode<T> rightChild = null;
	
	private BinaryTreeNode<T> parent = null;
	
	private T data = null;
	
	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}


	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
		this.leftChild.parent = this;
	}


	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}


	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
		this.rightChild.parent = this;
	}


	public BinaryTreeNode<T> getParent() {
		return parent;
	}


	public void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}
	
	public void visitData(){
		System.out.println(data);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
