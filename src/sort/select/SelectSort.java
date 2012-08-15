package sort.select;

import sort.SortUtils;

public class SelectSort<T extends Comparable<T>> {

	private T[] sortArray = null;
	
	public SelectSort(T[] tarray){
		sortArray = tarray;
	}
	
	public void sort(){
		for(int i = 0; i < sortArray.length; i++){
			T key = sortArray[i];
			int minIndex = i;
			for(int j = i + 1; j < sortArray.length; j++){
				if(sortArray[j].compareTo(key) < 0){
					minIndex = j;
				}
			}
			SortUtils.swap(sortArray, i, minIndex);
		}
		SortUtils.printSortArray(sortArray);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = {20, 9, 8, 10, 94,100, 1, 45};
		SelectSort<Integer> selectSort = new SelectSort<Integer>(array);
		selectSort.sort();
	}

}
