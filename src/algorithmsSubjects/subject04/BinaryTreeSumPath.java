package algorithmsSubjects.subject04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import tree.binaryTree.BinaryTreeNode;

/**
 * 在二元树中找出和为某一值的所有路径
题目：输入一个整数和一棵二元树。
从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。
打印出和与输入整数相等的所有路径。
例如 输入整数22和如下二元树
10 
/ \ 
5 12 
/ \ 
4 7
则打印出两条路径：10, 12和10, 5, 7。

二元树节点的数据结构定义为：

struct BinaryTreeNode // a node in the binary tree
{
int m_nValue; // value of node
BinaryTreeNode *m_pLeft; // left child of node
BinaryTreeNode *m_pRight; // right child of node
};

 * @author linjy
 *
 */
public class BinaryTreeSumPath {
	
	private Scanner scanner = new Scanner(System.in);
	
	private BinaryTreeNode root = null;
	
	private List<BinaryTreeNode> pathList = new ArrayList<BinaryTreeNode>();
	
	private class BinaryTreeNode{
		int data;
		
		BinaryTreeNode left;
		
		BinaryTreeNode right;
	}
	
	public BinaryTreeNode createBinaryTree(){
		String input = scanner.next();
		if(input.equals("*")){
			return null;
		}
		BinaryTreeNode node = new BinaryTreeNode();
		node.data = Integer.valueOf(input);
		BinaryTreeNode leftChild = createBinaryTree();
		node.left = leftChild;
		BinaryTreeNode rightChild = createBinaryTree();
		node.right = rightChild;
		return node;
	}
	
	public void printPath(){
		System.out.print("route:");
		for(BinaryTreeNode node : pathList){
			System.out.print(node.data + " ");
		}
		System.out.println(); 
	}
	
	public void findSumPath(BinaryTreeNode node, int val){
		if(node == null){
			return;
		}
		if((node.left == null) && (node.right == null)){
			if(node.data == val){
				pathList.add(node);
				printPath();
				pathList.remove(pathList.size() - 1);
			}
		}else{
			if(node.left != null){
				if(node.data < val){
					pathList.add(node);
					findSumPath(node.left, val - node.data);
					pathList.remove(pathList.size() - 1);
				}
			}
			if(node.right != null){
				if(node.data < val){
					pathList.add(node);
					findSumPath(node.right, val - node.data);
					pathList.remove(pathList.size() - 1);
				}
			}
		}
	}

	/**
	 * 示例输入：10 4 5 * * 8 * * 12 * *
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeSumPath  binarySumPath = new BinaryTreeSumPath();
		BinaryTreeSumPath.BinaryTreeNode root = binarySumPath.createBinaryTree();
		binarySumPath.findSumPath(root, 20);
	}

}
