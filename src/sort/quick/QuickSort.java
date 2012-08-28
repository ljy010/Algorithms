package sort.quick;

import sort.SortUtils;

public class QuickSort<T extends Comparable<T>> {

	private T[] sortArray;
	
	public QuickSort(T[] sortArray){
		this.sortArray = sortArray;
	}
	
	private int partition(int begin, int end){
		int middle = (begin + end) / 2;
		T  middleVal = sortArray[middle];
		int index = begin;
		int largeIndex = begin - 1;
		int smallIndex = largeIndex;
		while(index <= end){
			if(sortArray[index].compareTo(middleVal) > 0){
				largeIndex = index;
			}
				index++;
		}
	}
	
	public void sort(){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
