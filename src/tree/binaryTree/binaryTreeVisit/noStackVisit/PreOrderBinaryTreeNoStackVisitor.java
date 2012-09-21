package tree.binaryTree.binaryTreeVisit.noStackVisit;

import tree.binaryTree.BinaryTreeNode;

public class PreOrderBinaryTreeNoStackVisitor<T> extends
		BinaryTreeNoStackAbstractVisitor<T> {
	
	@Override
	protected  BinaryTreeNode<T> getFirstBinaryTreeNode(BinaryTreeNode<T> root){
		return root;
	}

	@Override
	protected BinaryTreeNode<T> getNextBinaryTreeNode(BinaryTreeNode<T> node) {
		if((node.getLeftChild() != null)){
			return node.getLeftChild();
		}
		if(node.getRightChild() != null){
			return node.getRightChild();
		}
		BinaryTreeNode<T> curNode = node;
		BinaryTreeNode<T> parentNode = node.getParent();
		while((parentNode != null)){
			if((parentNode.getRightChild() != null) && (curNode != parentNode.getRightChild())){
				return parentNode.getRightChild();
			}
			curNode = parentNode;
			parentNode = parentNode.getParent();
		}
		return null;
	}
}
