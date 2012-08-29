package tree.binaryTree.binaryTreeVisit;

import tree.binaryTree.BinaryTreeNode;

public interface BinaryTreeVisitor<T> {
	public void visitBinaryTree(BinaryTreeNode<T> root);
}
