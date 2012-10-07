package tree.binaryTree.binaryTreeVisit.layVisit;

import java.util.LinkedList;
import java.util.Queue;

import tree.binaryTree.BinaryTreeNode;
import tree.binaryTree.binaryTreeVisit.BinaryTreeVisitor;

public class LayBinaryTreeVisitor<T> implements BinaryTreeVisitor<T> {
	
	private Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
	@Override
	public void visitBinaryTree(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		queue.offer(root);
		BinaryTreeNode<T> node = null;
		while(!queue.isEmpty()){
			node = queue.poll();
			node.visitData();
			if(node.getLeftChild() != null){
				queue.offer(node.getLeftChild());
			}
			if(node.getRightChild() != null){
				queue.offer(node.getRightChild());
			}
			
		}
	}

}
