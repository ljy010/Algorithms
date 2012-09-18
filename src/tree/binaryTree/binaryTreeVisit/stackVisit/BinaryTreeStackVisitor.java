package tree.binaryTree.binaryTreeVisit.stackVisit;

import java.util.Stack;

import tree.binaryTree.BinaryTreeNode;
import tree.binaryTree.binaryTreeVisit.BinaryTreeVisitor;

public abstract class BinaryTreeStackVisitor<T> implements BinaryTreeVisitor<T> {

	protected Stack<BinaryTreeNode<T>> binaryTreeStack = new Stack<BinaryTreeNode<T>>();
}
