package sort;

public class SortUtils {
	
	public static<T extends Comparable<T>> void swap(T[] t, int i, int j){
		T ti = t[i];
		T tj = t[j];
		T tmp = ti;
		t[i] = tj;
		t[j] = tmp;
	}
	
	public static <T extends Comparable<T>> void printSortArray(T[] sortArray){
		for(T t: sortArray){
			System.out.println(t);
		}
	}
	
	public static <T extends Comparable<T>> T max(T t1, T t2){
		return t1.compareTo(t2) > 0 ? t1 : t2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
