package tree.binaryTree.binaryTreeVisit.noStackVisit;

import tree.binaryTree.BinaryTreeNode;

public class MidOrderBinaryTreeNoStackVisitor<T> extends
		BinaryTreeNoStackAbstractVisitor<T> {

	@Override
	protected BinaryTreeNode<T> getNextBinaryTreeNode(BinaryTreeNode<T> node) {
		if(node == null){
			return null;
		}
		BinaryTreeNode<T> currentNode = node;
		BinaryTreeNode<T> parent = currentNode.getParent();
		return null;
	}

}
