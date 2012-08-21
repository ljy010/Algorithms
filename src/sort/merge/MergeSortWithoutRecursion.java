package sort.merge;


/**
 * 归并排序，非递归，稳定
 * @author linjy
 *
 */
public class MergeSortWithoutRecursion {
	
	/**
	 * 分为两个区域，左区域，和右区域，每次做合并，是对这两个已排好序的区域做合并
	 * @param sortArray
	 */
	public void sort(int[] sortArray){
		int mergeStep = 1;
		while(mergeStep < sortArray.length){
		    int leftPartMin = 0;
		    int leftPartMax = 0;
		    int rightPartMin = 0;
		    int rightPartMax = 0;
		    while(leftPartMin < sortArray.length){
		    	leftPartMax = leftPartMin + mergeStep - 1;
			    rightPartMin = leftPartMax + 1;
			    if(rightPartMin >= sortArray.length){
			    	rightPartMin = sortArray.length - 1;
			    }
			    rightPartMax = rightPartMin + mergeStep - 1;
			    if(rightPartMax >= sortArray.length){
			    	rightPartMax = sortArray.length - 1;
			    }
			    int[] tmp = new int[rightPartMax - leftPartMin + 1];
			    int tmpIndex = 0;
			    int tmpLeftStartIndex = leftPartMin;
			    while((leftPartMin <= leftPartMax) && (rightPartMin <= rightPartMax)){
			    	if(sortArray[leftPartMin] < sortArray[rightPartMin]){
			    		tmp[tmpIndex++] = sortArray[leftPartMin++];
			    	}else{
			    		tmp[tmpIndex++] = sortArray[rightPartMin++];
			    	}
			    }
			    for(; (leftPartMin <= leftPartMax) && (tmpIndex < tmp.length); leftPartMin++){
			    	tmp[tmpIndex++] = sortArray[leftPartMin];
			    }
			    for(; (rightPartMin <= rightPartMax) && (tmpIndex < tmp.length); rightPartMin++){
			    	tmp[tmpIndex++] = sortArray[rightPartMin];
			    }
			    
			    for(int i = 0; i < tmp.length; i++){
					sortArray[tmpLeftStartIndex++] = tmp[i];
				}
			    leftPartMin = rightPartMax + 1;	
		    }
		    mergeStep *= 2;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSortWithoutRecursion mswr = new MergeSortWithoutRecursion();
		int[] a = {23, 45, 6, 7, 23, 1, 456, 777, -1, -2};
		mswr.sort(a);
		for(int i : a){
			System.out.println(i);
		}
	}

}
