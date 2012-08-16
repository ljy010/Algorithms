package sort.radix;

public class RadixSort_VII {
	
	private int[] sortArray = null;
	
	private int[][] radixSortArray = null;
	
	private int maxInt = 0;
	
	private int digitNum = 0;
	
	public RadixSort_VII(int[] tarray){
		sortArray = tarray;
		radixSortArray = new int[10][sortArray.length];
		maxInt = getMax();
		digitNum = digitNum(maxInt);
	}
	
	public int getMax(){
		int max = 0;
		for(int sortItem : sortArray){
			max = Math.max(sortItem, max);
		}
		return max;
	}
	
	public int digitNum(int num){
		int digitNum = 1;
		while((num / 10) > 0){
			num = num / 10;
			digitNum++;
		}
		return digitNum;
	}
	
	private void radixSort(int digitIndex){
		int div = (int)Math.pow(10, digitIndex - 1);
		int mod = (int)Math.pow(10, digitIndex);
		int[] ord = new int[10];
		for(int sortItem : sortArray){
			int digitBit = (sortItem % mod) / div;
			radixSortArray[digitBit][ord[digitBit]] = sortItem;
			ord[digitBit]++;
		}
		
		int index = 0;
		for(int i = 0; i < radixSortArray.length; i++){
			for(int j = 0; j < ord[i]; j++){
				sortArray[index] = radixSortArray[i][j];
				index++;
				radixSortArray[i][j] = 0;
			}
			ord[i] = 0;
		}
	}
	
	public void sort(){
		for(int d = 1; d <= digitNum; d++){
			radixSort(d);
		}
		
		for(int sortItem : sortArray){
			System.out.println(sortItem);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {12, 3, 5, 6, 78, 12345, 6, 88, 99};
		RadixSort_VII rs2 = new RadixSort_VII(a);
		rs2.sort();
	}

}
