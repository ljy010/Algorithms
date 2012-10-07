package algorithmsSubjects.subject05;

/**
 * 查找最小的k个元素
题目：输入n个整数，输出其中最小的k个。
例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4
 * @author ljy
 *
 */
public class FindTopNMin {
	
	private int heapSize = 0;
	
	private int[] heap = null;
	
	
	private int leftChild(int i){
		return (i + 1) * 2 - 1;
	}
	
	private int rightChild(int i){
		return (i + 1) * 2;
	}
	
	private void adjustHeap(int index){
		if((index < 0) || (index > heapSize)){
			return;
		}
		int leftChild = leftChild(index);
		int rightChild = rightChild(index);
		int largestIndex = index;
		if((leftChild < heapSize) && (heap[leftChild] > heap[largestIndex])){
			largestIndex = leftChild;
		}
		if((rightChild < heapSize) && (heap[rightChild] > heap[largestIndex])){
			largestIndex = rightChild;
		}
		if(largestIndex != index){
			int tmp = heap[index];
			heap[index] = heap[largestIndex];
			heap[largestIndex] = tmp;
			adjustHeap(largestIndex);
		}
	}
	
	private void buildHeap(){
		for(int i = heapSize / 2 + 1; i >= 0; i--){
			adjustHeap(i);
		}
	}
	
	private void initHeap(int[] array, int topN){
		if(array.length < topN){
			topN = array.length;
		}
		heap = new int[topN];
		heapSize = topN;
		for(int i = 0; i < topN; i++){
			heap[i] = array[i];
		}
		
		buildHeap();
	}
	
	public void printTopN(){
		for(int i : heap){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public void findTopNMin(int[] array, int topN){
		//构造一个大顶堆
		initHeap(array, topN);
		int heapMax = 0;
		for(int i = topN; i < array.length; i++){
			heapMax = heap[0];
			if(array[i] < heapMax){
				heap[0] = array[i];
				adjustHeap(0);
			}
		}
		
		printTopN();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindTopNMin findTopNMin = new FindTopNMin();
		int[] a = {5, 1, 7, 2, 6, 3, 8, 4};
		findTopNMin.findTopNMin(a, 4);
	}

}
