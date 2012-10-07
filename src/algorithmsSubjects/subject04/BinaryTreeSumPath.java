package algorithmsSubjects.subject04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import tree.binaryTree.BinaryTreeNode;

/**
 * �ڶ�Ԫ�����ҳ���Ϊĳһֵ������·��
��Ŀ������һ��������һ�ö�Ԫ����
�����ĸ���㿪ʼ���·���һֱ��Ҷ��������������н���γ�һ��·����
��ӡ����������������ȵ�����·����
���� ��������22�����¶�Ԫ��
10 
/ \ 
5 12 
/ \ 
4 7
���ӡ������·����10, 12��10, 5, 7��

��Ԫ���ڵ�����ݽṹ����Ϊ��

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
	 * ʾ�����룺10 4 5 * * 8 * * 12 * *
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeSumPath  binarySumPath = new BinaryTreeSumPath();
		BinaryTreeSumPath.BinaryTreeNode root = binarySumPath.createBinaryTree();
		binarySumPath.findSumPath(root, 20);
	}

}
