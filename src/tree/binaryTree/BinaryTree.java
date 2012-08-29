package tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import tree.binaryTree.binaryTreeVisit.BinaryTreeVisitor;
import tree.binaryTree.binaryTreeVisit.PreOrderBinaryTreeRecursionVisitor;

public class BinaryTree {
	
	private int binaryTreeIndex = 0;
	
	/**
	 * 构造一棵通过控制台输入的二叉树
	 * @return
	 */
	public BinaryTreeNode<String> createBinaryTreeFromInput(){
		BinaryTreeNode<String> root = new BinaryTreeNode<String>();
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		try{
			String data = bufferReader.readLine().trim();
			root.setData(data);
			if ("#".equals(data)) {
				return root;
			}
			BinaryTreeNode<String> leftChild = createBinaryTreeFromInput();
			root.setLeftChild(leftChild);
			BinaryTreeNode<String> rightChild = createBinaryTreeFromInput();
			root.setRightChild(rightChild);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return root;
	}
	
	/**
	 * 构造一棵由list输入的二叉树
	 * @param list
	 * @param index
	 * @return
	 */
	public BinaryTreeNode<String> createBinaryTreeFromList(List<String> list, int index){
		binaryTreeIndex = index;
		if(binaryTreeIndex >= list.size()){
			return null;
		}
		BinaryTreeNode<String> root = new BinaryTreeNode<String>();
		String data = list.get(index);
		root.setData(data);
		if("#".equals(data)){
			return root;
		}
		BinaryTreeNode<String> leftChild = createBinaryTreeFromList(list, ++binaryTreeIndex);
		if(leftChild != null){
			root.setLeftChild(leftChild);
		}
		BinaryTreeNode<String> rightChild = createBinaryTreeFromList(list, ++binaryTreeIndex);
		if(rightChild != null){
			root.setRightChild(rightChild);
		}
		return root;
	}
	
	public BinaryTreeNode<String> createBinaryTreeFromStr(String treeStr){
		List<String> list = new ArrayList<String>();
		String[] str = treeStr.split(",");
		for(int i = 0; i < str.length; i++){
			list.add(str[i].trim());
		}
		return createBinaryTreeFromList(list, 0);
	}
	
	public<T> void visitTree(BinaryTreeVisitor<T> binaryTreeVisitor, BinaryTreeNode<T> root){
		binaryTreeVisitor.visitBinaryTree(root);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		String treeInputStr = "34, 4, #, 7, #, #, 5, 8, #, #, 9, #, #";
		BinaryTreeNode<String> root = bt.createBinaryTreeFromStr(treeInputStr);
		PreOrderBinaryTreeRecursionVisitor<String> preOrderBinaryTreeRecursionVisitor  = new PreOrderBinaryTreeRecursionVisitor<String>();
		bt.visitTree(preOrderBinaryTreeRecursionVisitor, root);
	}

}
