package sort.merge;

/**
 * πÈ≤¢≈≈–Ú£¨µ›πÈ£¨o(nlogn), Œ»∂®
 * @author linjy
 *
 */
public class MergeSort {
	
	private void merge(int[] sortArray, int start, int mid, int end){
		int[] leftPart = new int[mid - start + 1];
		int[] rightPart = new int[end - mid];
		for(int i = 0; i < leftPart.length; i++){
			leftPart[i] = sortArray[start + i];
		}
		
		for(int i = 0; i < rightPart.length; i++){
			rightPart[i] = sortArray[mid + 1 + i];
		}
		
		int leftIndex = 0;
		int rightIndex = 0;
		int sortIndex = start;
		while((leftIndex < leftPart.length) && (rightIndex < rightPart.length)){
			if(leftPart[leftIndex] > rightPart[rightIndex]){
				sortArray[sortIndex] = rightPart[rightIndex];
				rightIndex++;
			}else{
				sortArray[sortIndex] = leftPart[leftIndex];
				leftIndex++;
			}
			sortIndex++;
		}
		
		for(; leftIndex < leftPart.length; leftIndex++, sortIndex++){
			sortArray[sortIndex] = leftPart[leftIndex];
		}
		
		for(; rightIndex < rightPart.length; rightIndex++, sortIndex++){
			sortArray[sortIndex] = rightPart[rightIndex];
		}
	}
	
	public void mergeSort(int[] sortArray, int start, int end){
		if(start < end){
			int mid = (start + end) / 2;
			mergeSort(sortArray, 0, mid);
			mergeSort(sortArray, mid + 1, end);
			merge(sortArray, start, mid, end);
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {12, 423, 543, 32, 6, 3, 67, 1990, -9};
		MergeSort ms = new MergeSort();
		ms.mergeSort(a, 0, a.length - 1);
		for(int i : a){
			System.out.println(i);
		}
	}

}
