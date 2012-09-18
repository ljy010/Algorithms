package tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import tree.binaryTree.binaryTreeVisit.BinaryTreeVisitor;
import tree.binaryTree.binaryTreeVisit.recursionVisit.MidOrderBinaryTreeRecursionVisitor;
import tree.binaryTree.binaryTreeVisit.recursionVisit.PostOrderBinaryTreeRecursionVisitor;
import tree.binaryTree.binaryTreeVisit.recursionVisit.PreOrderBinaryTreeRecursionVisitor;
import tree.binaryTree.binaryTreeVisit.stackVisit.MidOrderBinaryTreeStackVisitor;
import tree.binaryTree.binaryTreeVisit.stackVisit.PostOrderBinaryTreeWithoutRecursionVisitor;

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
				return null;
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
			return null;
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
		
		System.out.println("===================================pre order==============");
		BinaryTreeVisitor<String> preOrderBinaryTreeRecursionVisitor  = new PreOrderBinaryTreeRecursionVisitor<String>();
		bt.visitTree(preOrderBinaryTreeRecursionVisitor, root);
		System.out.println("===================================pre order　end==============");
		
		System.out.println("===================================mide order==============");
		BinaryTreeVisitor<String> midOrderBinaryTreeRecursionVisitor  = new MidOrderBinaryTreeRecursionVisitor<String>();
		bt.visitTree(midOrderBinaryTreeRecursionVisitor, root);
		System.out.println("===================================mide order end==============");
		
		System.out.println("===================================post order==============");
		BinaryTreeVisitor<String> postOrderBinaryTreeRecursionVisitor  = new PostOrderBinaryTreeRecursionVisitor<String>();
		bt.visitTree(postOrderBinaryTreeRecursionVisitor, root);
		System.out.println("===================================post order end==============");
		
		System.out.println("===================================mid order binaryTreeStack visitor start=========================");
		BinaryTreeVisitor<String> midOrderBinaryTreeStackVisitor = new MidOrderBinaryTreeStackVisitor<String>();
		bt.visitTree(midOrderBinaryTreeStackVisitor, root);
		System.out.println("===================================mid order binaryTreeStack visitor end=========================");
		
		System.out.println("===================================post order binaryTreeStack visitor start=========================");
		BinaryTreeVisitor<String> postOrderBinaryTreeStackVisitor = new PostOrderBinaryTreeWithoutRecursionVisitor<String>();
		bt.visitTree(postOrderBinaryTreeStackVisitor, root);
		System.out.println("===================================post order binaryTreeStack visitor end=========================");
	}

}
