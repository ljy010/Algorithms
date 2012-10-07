package dataStructure.redBlackTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 红黑树
 * @author ljy
 *
 * @param <T>
 */
public class RedBlackTree<T extends Comparable<T>> {
	
	class RedBlackTreeNode<T extends Comparable<T>>{
		T data;
		
		RedBlackTreeNode<T> leftChild = null;
		
		RedBlackTreeNode<T> rightChild = null;
		
		RedBlackTreeNode<T> parent = null;
		
		RedBlackTreeNodeColor color = RedBlackTreeNodeColor.RED;
		
		
		void visitData(){
			System.out.println(data + "[" + color.getColorStr() + "]");
		}
	}
		
	enum RedBlackTreeNodeColor { 
		RED("red"), 
		
		BLACK("black");
	    
		private String colorStr;
		
		private RedBlackTreeNodeColor(String colorStr){
			this.colorStr = colorStr;
		}
		
		public String getColorStr(){
		    return colorStr;
		}
	};
	
	private RedBlackTreeNode<T> root = null;
	
	private void leftRotate(RedBlackTreeNode<T> node){
		if(node == null){
			return;
		}
		RedBlackTreeNode<T> rightChild = node.rightChild;
		if(rightChild == null){
			return;
		}
		node.rightChild = rightChild.leftChild;
		rightChild.parent = node.parent;
	    if(rightChild.leftChild != null){
	    	rightChild.leftChild.parent = node;
	    }
	    if(node.parent != null){
	    	if(node.parent.leftChild == node){
	    		node.parent.leftChild = rightChild;
	    	}else{
	    		node.parent.rightChild = rightChild;
	    	}
	    }else{
	    	root = rightChild;
	    }
	    
	    node.parent = rightChild;
	    rightChild.leftChild = node;
	}
	
	private void rightRotate(RedBlackTreeNode<T> node){
		if(node == null){
			return;
		}
		RedBlackTreeNode<T> leftChild = node.leftChild;
		leftChild.parent = node.parent;
		node.leftChild = leftChild.rightChild;
		if(leftChild.rightChild != null){
			leftChild.rightChild.parent = node;
		}
		if(node.parent != null){
			if(node.parent.leftChild ==  node){
				node.parent.leftChild = leftChild;
			}else{
				node.parent.rightChild = leftChild;
			}
		}else{
			root = leftChild;	
		}
		
		node.parent = leftChild;
		leftChild.rightChild = node;
	}
	
	private void insertFixup(RedBlackTreeNode<T> node){
		RedBlackTreeNode<T> parentNode = node.parent;
		if(parentNode == null){
			node.color = RedBlackTreeNodeColor.BLACK;
			root = node;
			return;
		}
		RedBlackTreeNode<T> grandParentNode = null;
		RedBlackTreeNode<T> otherNode = null;
		while((parentNode != null) && (parentNode.color == RedBlackTreeNodeColor.RED)){
			grandParentNode = parentNode.parent;
			if(parentNode == grandParentNode.leftChild){
				otherNode = grandParentNode.rightChild;
				if(otherNode.color == RedBlackTreeNodeColor.RED){
					otherNode.color = RedBlackTreeNodeColor.BLACK;
					parentNode.color = RedBlackTreeNodeColor.BLACK;
					grandParentNode.color = RedBlackTreeNodeColor.RED;
					node = grandParentNode;
					parentNode = node.parent;
				}else{
					if(node == parentNode.rightChild){
						leftRotate(parentNode);
					}
					parentNode.color = RedBlackTreeNodeColor.BLACK;
					grandParentNode.color = RedBlackTreeNodeColor.RED;
					rightRotate(grandParentNode);
				}
			}else{
				otherNode = grandParentNode.leftChild;
				if(otherNode.color == RedBlackTreeNodeColor.RED){
					otherNode.color = RedBlackTreeNodeColor.BLACK;
					parentNode.color = RedBlackTreeNodeColor.BLACK;
					grandParentNode.color = RedBlackTreeNodeColor.RED;
					node = grandParentNode;
					parentNode = node.parent;
				}else{
					if(node == parentNode.leftChild){
						rightRotate(parentNode);
					}
					parentNode.color = RedBlackTreeNodeColor.BLACK;
					grandParentNode.color = RedBlackTreeNodeColor.RED;
					leftRotate(grandParentNode);
				}
			}
		}
		root.color = RedBlackTreeNodeColor.BLACK;
	}
	
	public void insert(T data){
		RedBlackTreeNode<T> currentNode = root;
		RedBlackTreeNode<T> childNode = root;
		while(childNode != null){
			currentNode = childNode;
			if(childNode.data.compareTo(data) > 0){
				childNode = currentNode.leftChild;
			}else{
				childNode = currentNode.rightChild;
			}
		}
		RedBlackTreeNode<T> newNode = new RedBlackTreeNode<T>();
		newNode.data = data;
		newNode.parent = currentNode;
		newNode.leftChild = null;
		newNode.rightChild = null;
		newNode.color = RedBlackTreeNodeColor.RED;
		if(currentNode != null){
			if(currentNode.data.compareTo(data) > 0){
				currentNode.leftChild = newNode;
			}else{
				currentNode.rightChild = newNode; 
			}
		}
		insertFixup(newNode);
	}
	
	public void printTree(){
		Queue<RedBlackTreeNode<T>> queue = new LinkedList<RedBlackTreeNode<T>>();
		queue.offer(root);
		RedBlackTreeNode<T> queueNode = null;
		while(!queue.isEmpty()){
			queueNode = queue.poll();
			queueNode.visitData();
			if(queueNode.leftChild != null){
				queue.offer(queueNode.leftChild);
			}
			if(queueNode.rightChild != null){
				queue.offer(queueNode.rightChild);
			}
		}
	}
	
	public RedBlackTreeNode<T> treeMinimum(RedBlackTreeNode<T> node){
		if(node == null){
			return null;
		}
		RedBlackTreeNode<T> currentNode = node;
		RedBlackTreeNode<T> leftNode = currentNode.leftChild;
		while(leftNode != null){
			currentNode = leftNode;
			leftNode = currentNode.leftChild;
		}
		return currentNode;
	}
	
	public RedBlackTreeNode<T> treeSuccessor(RedBlackTreeNode<T> node){
		if(node.rightChild != null){
			return treeMinimum(node.rightChild);
		}
		RedBlackTreeNode<T> currentNode = node;
		RedBlackTreeNode<T> parentNode = currentNode.parent;
		while((parentNode != null) && (parentNode.rightChild == currentNode)){
			currentNode = parentNode;
			parentNode = currentNode.parent;
		}
		return parentNode;
	}
	
	public void delete(RedBlackTreeNode<T> node){
		RedBlackTreeNode<T> replaceNode = null;
		if((node.leftChild == null) || (node.rightChild == null)){
			replaceNode = node;
		}else{
			replaceNode = treeSuccessor(node);
		}
		
		RedBlackTreeNode<T> parentNode = replaceNode.parent;
		if(parentNode == null){
			node = null;
			return;
		}
		RedBlackTreeNode<T> childNode = null;
		if(replaceNode.leftChild != null){
			childNode = replaceNode.leftChild;
		}else if(replaceNode.rightChild != null){
			childNode = replaceNode.rightChild;
		}
		if(childNode != null){
			childNode.parent = parentNode;
		}
		if(replaceNode == parentNode.leftChild){
			parentNode.leftChild = childNode;
		}else{
			parentNode.rightChild = childNode;
		}
		
		if(replaceNode.data.compareTo(node.data) != 0){
			node.data = replaceNode.data;
		}
		
		if(replaceNode.color == RedBlackTreeNodeColor.BLACK){
			deleteFixup(childNode);
		}
	}
	
	private void deleteFixup(RedBlackTreeNode<T> node){
		//TODO 调整删除节点着色
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>();
		
		redBlackTree.insert(11);
		redBlackTree.insert(2);
		redBlackTree.insert(14);
		redBlackTree.insert(1);
		redBlackTree.insert(7);
		redBlackTree.insert(15);
		redBlackTree.insert(5);
		redBlackTree.insert(8);
		redBlackTree.insert(4);

		redBlackTree.printTree();
	}

}
