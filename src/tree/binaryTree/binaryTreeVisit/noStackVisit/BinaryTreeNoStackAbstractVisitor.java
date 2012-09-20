package tree.binaryTree.binaryTreeVisit.noStackVisit;

import tree.binaryTree.BinaryTreeNode;
import tree.binaryTree.binaryTreeVisit.BinaryTreeVisitor;

public abstract class BinaryTreeNoStackAbstractVisitor<T> implements BinaryTreeVisitor<T> {

	protected abstract BinaryTreeNode<T> getNextBinaryTreeNode(BinaryTreeNode<T> node);
	
	@Override
	public void visitBinaryTree(BinaryTreeNode<T> root) {
		if(root == null){
			return;
		}
		root.visitData();
		BinaryTreeNode<T> nextNode = getNextBinaryTreeNode(root);
		while(nextNode != null){
			nextNode.visitData();
			nextNode = getNextBinaryTreeNode(nextNode);
		}
	}

}
