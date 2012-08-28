package sort.heap;

import sort.SortUtils;


/**
 * ∂—≈≈–Ú£¨O(nlog(n)), ≤ªŒ»∂®
 * @author linjy
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> {
	
	private T[] sortArray;
	
	private int heapSize = 0;
	
	public HeapSort(T[] sortArray){
		this.sortArray = sortArray;
		heapSize = this.sortArray.length;
	}
	
	public int leftChild(int parentIndex){
		return (parentIndex + 1) * 2 - 1;
	}
	
	public int rightChild(int parentIndex){
		return (parentIndex + 1) * 2;
	}
	
	public void adjustHeap(int i){
		if((i < 0) || (i > heapSize)){
			return;
		}
		int leftIndex = leftChild(i);
		int rightIndex = rightChild(i);
		int largestIndex = i;
		if((leftIndex < heapSize) && (sortArray[largestIndex].compareTo(sortArray[leftIndex]) < 0)){
			largestIndex = leftIndex;
		}
		if((rightIndex < heapSize) && (sortArray[largestIndex].compareTo(sortArray[rightIndex]) < 0)){
			largestIndex = rightIndex;
		}
		if(largestIndex != i){
			SortUtils.swap(sortArray, i, largestIndex);
			adjustHeap(largestIndex);
		}
	}
	
	public void buildHeap(){
		for(int i = sortArray.length / 2; i >= 0; i--){
			adjustHeap(i);
		}
	}
	
	public void sort(){
		buildHeap();
		for(int i = heapSize - 1; i >= 0; i--){
			System.out.println(sortArray[0]);
			SortUtils.swap(sortArray, 0, heapSize - 1);
			heapSize--;
			adjustHeap(0);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = {23, 4, 12, 33, 56, 78, 89, 69};
		HeapSort<Integer> hs = new HeapSort<Integer>(a);
		hs.sort();
	}

}
