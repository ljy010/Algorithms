package sort.counter;


/**
 * º∆ ˝≈≈–Ú£¨o(n + k), Œ»∂®
 * @author linjy
 *
 */
public class CounterSort {
	
	private int[] sortArray = null;
	
	
	public int[] counter = null;
	
	private int getMax(){
		int max = 0;
		for(int i : sortArray){
			max = Math.max(max, i);
		}
		return max;
	}
	
	public CounterSort(int[] sortArray){
		this.sortArray = sortArray;
		int max = getMax();
		counter = new int[max + 1];
	}
	
	public int[] sort(){
		int[] result = new int[sortArray.length];
		
		for(int sortItem : sortArray){
			counter[sortItem]++;
		}
		
		for(int i = 1; i < counter.length; i++){
			counter[i] = counter[i] + counter[i - 1];
		}
		
		for(int i = sortArray.length - 1; i >= 0; i--){
			int sortItem = sortArray[i];
			result[counter[sortItem] - 1] = sortItem;
			counter[sortItem]--;
		}
		
		for(int sortedItem : result){
			System.out.println(sortedItem);
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {2, 34, 56, 3, 100, 89, 56, 77, 8, 3};
		CounterSort cs = new CounterSort(a);
		cs.sort();
	}

}
