package tree.binaryTree.binaryTreeVisit.stackVisit;

import tree.binaryTree.BinaryTreeNode;

public class MidOrderBinaryTreeStackVisitor<T> extends BinaryTreeStackVisitor<T> {

	@Override
	public void visitBinaryTree(BinaryTreeNode<T> root) {
		if(root == null){
			return;
		}
		binaryTreeStack.push(root);
		BinaryTreeNode<T> node = root;
		while(!binaryTreeStack.isEmpty()){
			while(node != null){
				node = node.getLeftChild();
				if(node != null){
					binaryTreeStack.push(node);
				}
			}
			BinaryTreeNode<T> child = binaryTreeStack.pop();
			child.visitData();
			node = child.getRightChild();
			if(node != null){
				binaryTreeStack.push(node);
			}
		}
	}

}
