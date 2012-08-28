package sort.quick;

/**
 * øÏ≈≈£¨≤ªŒ»∂®
 * @author ljy
 *
 */
public class QuickSortVII<T extends Comparable<T>> {
	
	private T[] sortArray;
	
	public QuickSortVII(T[] sortArray){
		this.sortArray = sortArray;
	}
	
	private void quickSort(int begin, int end){
		if(begin >= end){
			return;
		}
		int left = begin;
		int right = end;
		T key = sortArray[begin];
		while(left < right){
			while((left < right) && (sortArray[right].compareTo(key) > 0)){
				right--;
			}
			if(left < right){
				sortArray[left++] = sortArray[right];
			}
			while((left < right) && (sortArray[left].compareTo(key) < 0)){
				left++;
			}
			if(left < right){
				sortArray[right--] = sortArray[left];
			}
		}
		sortArray[left] = key;
		quickSort(begin, left - 1);
		quickSort(left + 1, end);
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
		QuickSortVII<Integer> qs = new QuickSortVII<Integer>(a);
		qs.sort();
	}

}
