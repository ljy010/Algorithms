package dataStructure.mulChildTree;

import java.util.Scanner;

public class MulChildRootTree {

	private Scanner scanner = new Scanner(System.in);

	public TreeNode<String> createTreeNode() {
		String input = scanner.next();
		if (input.equals("#")) {
			return null;
		}
		TreeNode<String> node = new TreeNode<String>();
		node.setData(input);
		TreeNode<String> leftChild = createTreeNode();
		node.setLeftChild(leftChild);
		if (leftChild != null) {
			leftChild.setParentNode(node);
		}
		TreeNode<String> rightSibling = createTreeNode();
		node.setRightSlibling(rightSibling);
		if (rightSibling != null) {
			rightSibling.setParentNode(node.getParentNode());
		}
		return node;
	}

	/**
	 * 分支无限的有根树，先根递归遍历
	 * 
	 * @param root
	 */
	public void visitTree(TreeNode<String> root) {
		if (root == null) {
			return;
		}
		root.visitData();
		visitTree(root.getLeftChild());
		visitTree(root.getRightSlibling());
	}

	/**
	 * 一个示例输入： 6 4 10 # 12 14 # # # 2 18 # 17 # 15 21 # 22 # # 11 # # 3 20 # # # #
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MulChildRootTree childRootTree = new MulChildRootTree();
		TreeNode<String> root = childRootTree.createTreeNode();
		childRootTree.visitTree(root);
	}

}
