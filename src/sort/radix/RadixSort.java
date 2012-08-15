package sort.radix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基数排序
 * @author ljy
 *
 */
public class RadixSort {
	
	private int[] sortArray = null;
	
	private Queue<Integer>[] digitArray = new Queue[10];
	
	private void initQueue(){
		for(int i = 0; i < digitArray.length; i++){
			digitArray[i] = new LinkedList<Integer>();
		}
	}
	
	private void clear(){
		for(Queue<Integer> queue : digitArray){
			if(queue != null){
			  queue.clear();
			}
		}
	}
	
	public RadixSort(int[] tArray){
		this.sortArray = tArray;
		initQueue();
	}
	
	private int max(){
		int max = 0;
		for(int i : sortArray){
			max = Math.max(max, i);
		}
		return max;
	}
	
	private int getDigit(int num){
		int digitNum = 1;
		while((num / 10) > 0){
			num = num / 10;
			digitNum++;
		}
		return digitNum;
	}
	
	/**
	 * 依赖于稳定的排序，这里使用链表，o(d(n+n^2))
	 * @param digit
	 */
	private void radixSort(int digit){
		int base = (int) Math.pow(10, digit);
		int k = (int)Math.pow(10, digit - 1);
		clear();
		for(int i : sortArray){
			int baseDig = (i % base) / k;
			int insertIndex = 0;
			for(; insertIndex < digitArray[baseDig].size(); insertIndex++){
			   Integer qi = digitArray[baseDig].peek();
			   if(qi > i){
				   break;
			   }
			}
			((LinkedList<Integer>)digitArray[baseDig]).add(insertIndex, i);
		}
		
		int index = 0;
		for(Queue<Integer> queue : digitArray){
			for(int v: queue){
				  sortArray[index] = v;
				  index++;
				
			}
		}
		
		
	}
	
	public void sort(){
		int max = max();
		int digitNum = getDigit(max);
		for(int i = 1; i <= digitNum; i++){
		    radixSort(i);	
		}
		for(int i : sortArray){
			System.out.println(i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1234, 33, 3, 50, 6, 7, 9, 100};
		RadixSort rs = new RadixSort(a);
		rs.sort();
	}
}
