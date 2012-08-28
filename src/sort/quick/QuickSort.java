package sort.quick;

import sort.SortUtils;


/**
 * øÏ≈≈£¨O(nlog(n)), ≤ªŒ»∂®, µ›πÈ
 * @author ljy
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> {

	private T[] sortArray;
	
	public QuickSort(T[] sortArray){
		this.sortArray = sortArray;
	}
	
	private int partition(int begin, int end){
		int key = end;
		T  keyVal = sortArray[key];
		int smallIndex = begin - 1;
		for(int i = begin; i < end; i++){
			if(sortArray[i].compareTo(keyVal) <= 0){
				smallIndex++;
				SortUtils.swap(sortArray, smallIndex, i);
			}
		}
		SortUtils.swap(sortArray, ++smallIndex, key);
		return smallIndex;
	}
	
	private void quickSort(int begin, int end){
		if(begin < end){
			int partition = partition(begin, end);
			quickSort(begin, partition - 1);
			quickSort(partition + 1, end);
		}
	}
	
	public void sort(){
		quickSort(0, sortArray.length - 1);
		for(T t : sortArray){
			System.out.println(t);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = {12, 3, 4, 56, 55, 67, 89, 546, 8};
		QuickSort<Integer> qs = new QuickSort<Integer>(a);
		qs.sort();
	}

}
