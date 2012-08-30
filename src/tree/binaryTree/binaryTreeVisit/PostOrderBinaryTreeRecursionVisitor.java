package tree.binaryTree.binaryTreeVisit;

import tree.binaryTree.BinaryTreeNode;

/**
 * ����ݹ����
 * @author linjy
 *
 * @param <T>
 */
public class PostOrderBinaryTreeRecursionVisitor<T> implements BinaryTreeVisitor<T> {

	@Override
	public void visitBinaryTree(BinaryTreeNode<T> root) {
		if(root == null){
			return;
		}
		visitBinaryTree(root.getLeftChild());
		visitBinaryTree(root.getRightChild());
		root.visitData();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
