package dataStructure.binarySearchTree;

import java.util.Scanner;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Scanner scanner = new Scanner(System.in);
	
	class BinaryTreeNode{
		private BinaryTreeNode parent;
		
		private BinaryTreeNode leftChild;
		
		private BinaryTreeNode rightChild;
		
		private T data;
		
		public void visitData(){
			System.out.println(data);
		}

		public BinaryTreeNode getParent() {
			return parent;
		}

		public void setParent(BinaryTreeNode parent) {
			this.parent = parent;
		}

		public BinaryTreeNode getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(BinaryTreeNode leftChild) {
			this.leftChild = leftChild;
			if(leftChild != null){
				this.leftChild.setParent(this);
			}
		}

		public BinaryTreeNode getRightChild() {
			return rightChild;
		}

		public void setRightChild(BinaryTreeNode rightChild) {
			this.rightChild = rightChild;
			if(rightChild != null){
				this.rightChild.setParent(this);
			}
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}
		
		
	}
	
	public BinaryTreeNode createBinarySearchTree(){
		BinaryTreeNode node = new BinaryTreeNode();
		String input = scanner.next();
		if("#".equals(input)){
			return null;
		}
		node.setData((T)input);
		
		BinaryTreeNode leftChild = createBinarySearchTree();
		node.setLeftChild(leftChild);
		
		BinaryTreeNode rightChild = createBinarySearchTree();
		node.setRightChild(rightChild);
		return node;
	}
	
	public void inorderTreeWalk(BinaryTreeNode root){
		if(root == null){
			return;
		}
		inorderTreeWalk(root.getLeftChild());
		root.visitData();
		inorderTreeWalk(root.getRightChild());
	}
	
	public BinaryTreeNode treeSearch(BinaryTreeNode node, T key){
		if((node == null) || (node.getData().compareTo(key) == 0)){
			return node;
		}
		if(node.getData().compareTo(key) < 0){
			return treeSearch(node.getRightChild(), key);
		}else{
			return treeSearch(node.getLeftChild(), key);
		}
	}
	
	public BinaryTreeNode iterativeTreeSearch(BinaryTreeNode node, T key){
		while((node != null) && (node.getData().compareTo(key) != 0)){
			if(node.getData().compareTo(key) < 0){
				node = node.getRightChild();
			}
			else{
				node = node.getLeftChild();
			}
		}
		return node;
	}
	
	public BinaryTreeNode treeMinimum(BinaryTreeNode node){
		if(node == null){
			return null;
		}
		BinaryTreeNode currentNode = node;
		BinaryTreeNode left = node.getLeftChild();
		while(left != null){
			currentNode = left;
			left = currentNode.getLeftChild();
		}
		return currentNode;
		
	}
	
	public BinaryTreeNode treeMaximum(BinaryTreeNode node){
		if(node == null){
			return null;
		}
		BinaryTreeNode currentNode = node;
		BinaryTreeNode right = currentNode.getRightChild();
		while(right != null){
			currentNode = right;
			right = currentNode.getRightChild();
		}
		return currentNode;
		
	}
	
	public BinaryTreeNode treeSuccessor(BinaryTreeNode node){
		if(node.getRightChild() != null){
			return treeMinimum(node.getRightChild());
		}
		BinaryTreeNode currentNode = node;
		BinaryTreeNode parentNode = currentNode.getParent();
		while((parentNode != null) && (currentNode == parentNode.getRightChild())){
			currentNode = parentNode;
			parentNode = currentNode.getParent();
		}
		return parentNode;
	}
	
	public void treeInsert(BinaryTreeNode root, T key){
		if(root == null){
			BinaryTreeNode node = new BinaryTreeNode();
			node.setData(key);
			return;
		}
		BinaryTreeNode current = root;
		BinaryTreeNode nextNode = current;
		while(nextNode != null){
			current = nextNode;
			if(nextNode.getData().compareTo(key) > 0){
				nextNode = nextNode.getLeftChild();
			}else{
				nextNode = nextNode.getRightChild();
			}
		}
		BinaryTreeNode newNode = new BinaryTreeNode();
		newNode.setData(key);
		if(current.getData().compareTo(key) > 0){
			current.setLeftChild(newNode);
		}else{
			current.setRightChild(newNode);
		}
	}
	
	public void treeDelete(BinaryTreeNode node){
		if(node.getParent() == null){
			node = null;
		}
		BinaryTreeNode replaceNode = null;
		if((node.getLeftChild() == null) || (node.getRightChild() == null)){
			replaceNode = node;
		}
		else{
			replaceNode = treeSuccessor(node);
		}
		
		BinaryTreeNode parent = replaceNode.getParent();
		if(parent == null){
			node = null;
			return;
		}
		BinaryTreeNode child = null;
		if(replaceNode.getLeftChild() != null){
			child = replaceNode.getLeftChild();
		}
		else if(replaceNode.getRightChild() != null){
			child = replaceNode.getRightChild();
		}
		
		if(child != null){
			child.setParent(parent);
		}
		if(replaceNode == parent.getLeftChild()){
			parent.setLeftChild(child);
		}else if(replaceNode == parent.getRightChild()){
			parent.setRightChild(child);
		}
		
		if(node.getData().compareTo(replaceNode.getData()) != 0){
			node.setData(replaceNode.getData());
		}
	}

	/**
	 *  æ¿˝ ‰»Î£∫15 6 3 2 # # 4 # # 7 # 13 9 # # # 18 17 # # 20 # #
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		BinarySearchTree<String>.BinaryTreeNode root  = tree.createBinarySearchTree();
		tree.inorderTreeWalk(root);
		
		BinarySearchTree<String>.BinaryTreeNode result = tree.treeSearch(root, "18");
		System.out.println(result);
		
		BinarySearchTree<String>.BinaryTreeNode result2 = tree.treeSearch(root, "18");
		System.out.println(result2);
		
		System.out.println("========delete=======");
		tree.treeDelete(result);
		tree.inorderTreeWalk(root);
	}

}
