package dataStructure.mulChildTree;

public class TreeNode<T> {

	private TreeNode<T> parentNode = null;
	
	private TreeNode<T> leftChild = null;
	
	private TreeNode<T> rightSlibling = null;
	
	private T data;
	
	public void visitData(){
		System.out.println(data);
	}

	public TreeNode<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(TreeNode<T> parentNode) {
		this.parentNode = parentNode;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightSlibling() {
		return rightSlibling;
	}

	public void setRightSlibling(TreeNode<T> rightSlibling) {
		this.rightSlibling = rightSlibling;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
