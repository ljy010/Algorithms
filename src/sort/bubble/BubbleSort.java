package sort.bubble;

import sort.SortUtils;


public class BubbleSort<T extends Comparable<T>> {
	
	private T[] tarray = null;
	
	public BubbleSort(T[] t){
		tarray = t;
	}
	
	public void sort(){
		for(int i = 0; i < tarray.length; i ++){
		    for(int j = tarray.length - 1; j > i; j--){
		    	if(tarray[j].compareTo(tarray[j - 1]) < 0 ){
		    		SortUtils.swap(tarray, j, j - 1);
		    	}
		    }
		}
		SortUtils.printSortArray(tarray);
	}

	/**
	 * @param args
	 * */
	public static void main(String[] args) {
		Integer[] a = {4, 6, 10, 23, 1, 88};
		BubbleSort<Integer> b = new BubbleSort<Integer>(a);
		b.sort();

	}

}
