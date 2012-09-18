package tree.binaryTree.binaryTreeVisit.recursionVisit;

import tree.binaryTree.BinaryTreeNode;
import tree.binaryTree.binaryTreeVisit.BinaryTreeVisitor;

/**
 * ÖÐÐòµÝ¹é±éÀú
 * @author linjy
 *
 * @param <T>
 */
public class MidOrderBinaryTreeRecursionVisitor<T> implements BinaryTreeVisitor<T> {

	@Override
	public void visitBinaryTree(BinaryTreeNode<T> root) {
		if(root == null){
			return;
		}
		visitBinaryTree(root.getLeftChild());
		root.visitData();
		visitBinaryTree(root.getRightChild());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
