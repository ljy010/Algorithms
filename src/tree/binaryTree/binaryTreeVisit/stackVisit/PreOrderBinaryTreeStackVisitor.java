package tree.binaryTree.binaryTreeVisit.stackVisit;

import tree.binaryTree.BinaryTreeNode;

public class PreOrderBinaryTreeStackVisitor<T> extends BinaryTreeStackVisitor<T> {

	@Override
	public void visitBinaryTree(BinaryTreeNode<T> root) {
		if(root == null){
			return;
		}
		binaryTreeStack.push(root);
		while(!binaryTreeStack.isEmpty()){
			BinaryTreeNode<T> node = binaryTreeStack.pop();
			node.visitData();
			if(node.getLeftChild() != null){
				binaryTreeStack.push(node.getLeftChild());
			}
			if(node.getRightChild() != null){
				binaryTreeStack.push(node.getRightChild());
			}
		}
	}

}
