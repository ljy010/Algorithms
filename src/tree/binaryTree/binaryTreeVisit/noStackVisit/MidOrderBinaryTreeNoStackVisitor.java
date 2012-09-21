package tree.binaryTree.binaryTreeVisit.noStackVisit;

import tree.binaryTree.BinaryTreeNode;

public class MidOrderBinaryTreeNoStackVisitor<T> extends
		BinaryTreeNoStackAbstractVisitor<T> {
	
	@Override
	protected  BinaryTreeNode<T> getFirstBinaryTreeNode(BinaryTreeNode<T> root){
		if(root == null){
			return null;
		}
		BinaryTreeNode<T> leftNode = root.getLeftChild();
		BinaryTreeNode<T> currentNode = root;
		while(leftNode != null){
			currentNode = leftNode;
			leftNode = currentNode.getLeftChild();
		}
		return currentNode;
	}

	@Override
	protected BinaryTreeNode<T> getNextBinaryTreeNode(BinaryTreeNode<T> node) {
		if(node == null){
			return null;
		}
		BinaryTreeNode<T> leftNode = null;

		BinaryTreeNode<T> parentNode = null;
		BinaryTreeNode<T> currentNode = node;
		if(currentNode.getRightChild() != null){
			currentNode = currentNode.getRightChild();
			leftNode = currentNode.getLeftChild();
			while(leftNode != null){
				currentNode = leftNode;
				leftNode = currentNode.getLeftChild();
			}
			return currentNode;
		}
		parentNode = currentNode.getParent();
		if(parentNode != null){
			if(parentNode.getLeftChild() == currentNode){
				return parentNode;
			}else if(parentNode.getRightChild() == currentNode){
				currentNode = parentNode.getRightChild();
				while((parentNode != null) && (parentNode.getRightChild() == currentNode )){
					currentNode = parentNode;
					parentNode = currentNode.getParent();
				}
				return parentNode;
			}
		}
		
		return null;
	}

}
