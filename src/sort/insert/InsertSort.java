package sort.insert;

import sort.SortUtils;

public class InsertSort<T extends Comparable<T>> {

	private T[] sortItemArray = null;
	
	public InsertSort(T[] tarray){
		this.sortItemArray = tarray;
	}
	
	public void sort(){
		for(int i = 1; i < sortItemArray.length; i++){
			T insertItem = sortItemArray[i];
			int j = i - 1;
			for(; j >= 0; j--){
				if(sortItemArray[j].compareTo(insertItem) > 0  ){
					sortItemArray[j + 1] = sortItemArray[j];
				}
				else{
					break;
				}
			}
			sortItemArray[j + 1] = insertItem;
		}
		SortUtils.printSortArray(sortItemArray);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = {20, 9, 8, 10, 94,100, 1};
		InsertSort<Integer> insertSort = new InsertSort<Integer>(array);
		insertSort.sort();
	}

}
