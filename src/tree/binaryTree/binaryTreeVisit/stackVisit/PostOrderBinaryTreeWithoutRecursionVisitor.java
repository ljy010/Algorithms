package tree.binaryTree.binaryTreeVisit.stackVisit;

import tree.binaryTree.BinaryTreeNode;

public class PostOrderBinaryTreeWithoutRecursionVisitor<T> extends
		BinaryTreeStackVisitor<T> {

	@Override
	public void visitBinaryTree(BinaryTreeNode<T> root) {
		if(root == null){
			return;
		}
		BinaryTreeNode<T> node = root;
		binaryTreeStack.push(node);
		BinaryTreeNode<T> previousNode = null;
		while(!binaryTreeStack.isEmpty()){
			
			while(node != null){
				node = node.getLeftChild();
				if(node != null){
					binaryTreeStack.push(node);
				}
			}
			node = binaryTreeStack.peek();
			if((node.getRightChild() == null) || (node.getRightChild() == previousNode)){
				node = binaryTreeStack.pop();
				node.visitData();
				previousNode = node;
				node = null;
			}else{
				if(node.getRightChild() != null){
					node = node.getRightChild();
					binaryTreeStack.push(node);
				}
			}
		}
	}

}
