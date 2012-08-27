package sort.shell;


/**
 * œ£∂˚≈≈–Ú£¨≤ªŒ»∂®£¨O(n^2)
 * @author linjy
 *
 * @param <T>
 */
public class ShellSort <T extends Comparable<T>> {

	private int[] steps = {1, 3, 5};
	private T[] sortArray = null;
	
	public ShellSort(T[] sortArray){
		this.sortArray = sortArray;
	}
	
	private void sortByStep(int step){
		for(int i = step; i < sortArray.length; i++){
			T tmp = sortArray[i];
			int j = i - step;
			while((j >= 0) && (sortArray[j].compareTo(tmp) > 0)){
				sortArray[j + step] = sortArray[j]; 
				j = j - step;
			}
			sortArray[j + step] = tmp;
		}
	}
	
	public void sort(){
		for(int i = steps.length - 1; i >= 0; i--){
			int step = steps[i];
			sortByStep(step);
		}
		for(T t : sortArray){
			System.out.println(t);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = {23, 4, 5, 67, 89, 122, 34, 55, 78, 90, 9, 1};
		ShellSort<Integer> ss = new ShellSort<Integer>(a);
		ss.sort();
	}

}
