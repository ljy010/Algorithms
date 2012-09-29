package algorithmsSubjects.subject01;

import java.util.Scanner;

/**
 * 1.�Ѷ�Ԫ������ת��������˫������
��Ŀ��
����һ�ö�Ԫ�����������ö�Ԫ������ת����һ�������˫������
Ҫ���ܴ����κ��µĽ�㣬ֻ����ָ���ָ��

10
/ /
6 14
/ / / /
4 8 12 16

ת����˫������
4=6=8=10=12=14=16��

�������Ƕ���Ķ�Ԫ������ �ڵ�����ݽṹ���£�
struct BSTreeNode
{
int m_nValue; // value of node
BSTreeNode *m_pLeft; // left child of node
BSTreeNode *m_pRight; // right child of node
};

 * @author linjy
 *
 * @param <T>
 */
public class BinaryTreeTransLinkList<T extends Comparable<T>> {
	
	private Scanner scanner = new Scanner(System.in);
	
	private class BinaryTreeNode{
		T data;
		
		BinaryTreeNode left;
		
		BinaryTreeNode right;
		
		void visitData(){
			System.out.println(data);
		}
	}
	
	public BinaryTreeNode createTree(){
		String input = scanner.next();
		if("#".equals(input)){
			return null;
		}
		BinaryTreeNode newNode = new BinaryTreeNode();
		newNode.data = (T) input;
		BinaryTreeNode leftNode = createTree();
		newNode.left = leftNode;
		BinaryTreeNode rightNode = createTree();
		newNode.right = rightNode;
		return newNode;
	}
	
	public void transe(BinaryTreeNode node){
		if(node == null){
			return;
		}
		BinaryTreeNode left = node.left;
		BinaryTreeNode right = node.right;
		transe(left);
		if(left != null){
			BinaryTreeNode currentNode = left;
			BinaryTreeNode childRight = left.right;
			while(childRight != null){
				currentNode = childRight;
				childRight = currentNode.right;
			}
			currentNode.right = node;
			node.left = currentNode;
		}
		
		transe(right);
		if(right != null){
			BinaryTreeNode currentNode = right;
			BinaryTreeNode childLeft = right.left;
			while(childLeft != null){
				currentNode = childLeft;
				childLeft = currentNode.left;
			}
			currentNode.left = node;
			node.right = currentNode;
		}
	}
	
	public void visit(BinaryTreeNode root){
		if(root == null){
			return;
		}
		BinaryTreeNode left = root.left;
		BinaryTreeNode currentNode = root;
		while(left != null){
			currentNode = left;
			left = currentNode.left;
		}
		while(currentNode != null){
			currentNode.visitData();
			currentNode = currentNode.right;
		}
	}

	/**
	 * ʾ�����룺10 6 4 # # 8 # # 14 12 # # 16 # #
	 * @param args
	 */
	public static void main(final String[] args) {
		BinaryTreeTransLinkList<String> tree = new BinaryTreeTransLinkList<String>();
		BinaryTreeTransLinkList<String>.BinaryTreeNode root  = tree.createTree();
		tree.transe(root);
		tree.visit(root);
	}

}
