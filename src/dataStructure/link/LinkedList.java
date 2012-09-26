package dataStructure.link;

import dataStructure.queue.Queue;

public class LinkedList<T extends Comparable<T>> implements Queue<T> {

	private LinkNode<T> nilNode = null;
	
	private int size = 0;

	@Override
	public boolean isEmpty() {
		return (nilNode.getPrevNode() == nilNode) && (nilNode.getNextNode() == nilNode);
	}

	@Override
	public boolean addFirst(T element) {
		LinkNode<T> newNode = new LinkNode<T>();
		newNode.setData(element);
		LinkNode<T> firstNode = nilNode.getNextNode();
		
		firstNode.setPrevNode(newNode);
		newNode.setNextNode(firstNode);
		nilNode.setNextNode(newNode);
		newNode.setPrevNode(nilNode);
		
		size++;
		return true;
	}

	@Override
	public boolean addLast(T element) {
		LinkNode<T> newNode = new LinkNode<T>();
		newNode.setData(element);
		
		LinkNode<T> lastNode = nilNode.getPrevNode();
		lastNode.setNextNode(newNode);
		newNode.setPrevNode(lastNode);
		newNode.setNextNode(nilNode);
		nilNode.setPrevNode(newNode);
		
		size++;
		return true;
	}
	
	private void deleteNode(LinkNode<T> node){
		node.getPrevNode().setNextNode(node.getNextNode());
		node.getNextNode().setPrevNode(node.getPrevNode());
	}

	@Override
	public T pollFirst() {
		if(size == 0){
			return null;
		}
		LinkNode<T> firstNode = nilNode.getNextNode();
		deleteNode(firstNode);
		size--;
		return firstNode.getData();
	}

	@Override
	public T pollLast() {
		if(size == 0){
			return null;
		}
		LinkNode<T> lastNode = nilNode.getPrevNode();
		deleteNode(lastNode);
		size--;
		return lastNode.getData();
	}
	
	private void iniNilNode(){
		if(nilNode == null){
			nilNode = new LinkNode<T>();
		}
		nilNode.setPrevNode(nilNode);
		nilNode.setNextNode(nilNode);
	}
	
	public LinkedList(){
		iniNilNode();
	}
	
	public void visitList(){
		LinkNode<T> nextNode = nilNode.getNextNode();
		while(nextNode != nilNode){
			nextNode.visitData();
			nextNode = nextNode.getNextNode();
		}
	}
	
	public boolean isContain(T key){
		LinkNode<T> nextNode = nilNode.getNextNode();
		while((nextNode != nilNode) && (nextNode.getData().compareTo(key) != 0)){
			nextNode = nextNode.getNextNode();
		}
		return (nextNode.getData() != null) && (nextNode.getData().compareTo(key) == 0);
	}
	
	public static void main(String[] args){
		//
		LinkedList<String> linkList = new LinkedList<String>();
		linkList.addFirst("aaaa");
		linkList.addLast("abc");
		linkList.addFirst("bbb");
		System.out.println(linkList.isContain("aaa"));
		linkList.pollFirst();
		linkList.visitList();
	}
}
