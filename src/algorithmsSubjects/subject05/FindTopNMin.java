package algorithmsSubjects.subject05;

/**
 * ������С��k��Ԫ��
��Ŀ������n�����������������С��k����
��������1��2��3��4��5��6��7��8��8�����֣�����С��4������Ϊ1��2��3��4
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
		//����һ���󶥶�
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
