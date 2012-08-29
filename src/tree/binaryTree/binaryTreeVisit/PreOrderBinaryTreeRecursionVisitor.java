package tree.binaryTree.binaryTreeVisit;

import tree.binaryTree.BinaryTreeNode;

/**
 * ¶þ²æÊ÷Ç°ÐòµÝ¹é±éÀú
 * @author linjy
 *
 */
public class PreOrderBinaryTreeRecursionVisitor<T> implements BinaryTreeVisitor<T>{

	@Override
	public void visitBinaryTree(BinaryTreeNode<T> root) {
	    if(root == null){
	    	return;
	    }
	    root.visitData();
	    visitBinaryTree(root.getLeftChild());
	    visitBinaryTree(root.getRightChild());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
