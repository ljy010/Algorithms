package tree.binaryTree.binaryTreeVisit.noStackVisit;

import tree.binaryTree.BinaryTreeNode;
import tree.binaryTree.binaryTreeVisit.BinaryTreeVisitor;

public abstract class BinaryTreeNoStackAbstractVisitor<T> implements
		BinaryTreeVisitor<T> {

	protected abstract BinaryTreeNode<T> getNextBinaryTreeNode(
			BinaryTreeNode<T> node);

	protected abstract BinaryTreeNode<T> getFirstBinaryTreeNode(
			BinaryTreeNode<T> root);

	@Override
	public void visitBinaryTree(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}
		BinaryTreeNode<T> nextNode = getFirstBinaryTreeNode(root);
		while (nextNode != null) {
			nextNode.visitData();
			nextNode = getNextBinaryTreeNode(nextNode);
		}

	}
}
