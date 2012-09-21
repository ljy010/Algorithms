package tree.binaryTree.binaryTreeVisit.noStackVisit;

import tree.binaryTree.BinaryTreeNode;

public class PostOrderBinaryTreeNoStackVisitor<T> extends
		BinaryTreeNoStackAbstractVisitor<T> {
	
	@Override
	protected  BinaryTreeNode<T> getFirstBinaryTreeNode(BinaryTreeNode<T> root){
		if(root == null){
			return null;
		}
		BinaryTreeNode<T> firstNode = null;
		if(root.getLeftChild() != null){
			firstNode = getLeafBinaryTreeNode(root.getLeftChild());
		}
		else if(root.getRightChild() != null){
			firstNode = getLeafBinaryTreeNode(root.getRightChild());
		}
		else{
			firstNode = root;
		}
		return firstNode;
	}
	
	private BinaryTreeNode<T> getLeafBinaryTreeNode(BinaryTreeNode<T> node){
		if(node == null){
			return null;
		}
		BinaryTreeNode<T> currentNode = node;
		BinaryTreeNode<T> leftNode = node.getLeftChild();
		while(leftNode != null){
			currentNode = leftNode;
			leftNode = currentNode.getLeftChild();
		}
		BinaryTreeNode<T> rightNode = currentNode.getRightChild();
		while(rightNode != null){
			currentNode = rightNode;
			leftNode = currentNode.getLeftChild();
			while(leftNode != null){
				currentNode = leftNode;
				leftNode = currentNode.getLeftChild();
			}
			rightNode = currentNode.getRightChild();
		}
		return currentNode;
		
	}
	
	@Override
	protected BinaryTreeNode<T> getNextBinaryTreeNode(BinaryTreeNode<T> node) {
		if(node == null){
			return null;
		}
		BinaryTreeNode<T> parentNode = node.getParent();
		if(parentNode != null){
			if(parentNode.getLeftChild() == node){
				if(parentNode.getRightChild() != null){
					return getLeafBinaryTreeNode(parentNode.getRightChild());
				}
				else{
					return parentNode;
				}
				
			}
			else if(parentNode.getRightChild() == node){
				return parentNode;
			}
			
		}
		return null;
	}

}
