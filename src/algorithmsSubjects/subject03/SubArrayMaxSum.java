package algorithmsSubjects.subject03;

/**
 * �������������
��Ŀ��
����һ���������飬������������Ҳ�и�����
������������һ�������������һ�������飬ÿ�������鶼��һ���͡�
������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��

�������������Ϊ1, -2, 3, 10, -4, 7, 2, -5��������������Ϊ3, 10, -4, 7, 2��
������Ϊ��������ĺ�18��

 * @author linjy
 *
 */
public class SubArrayMaxSum {
	
	//sum(n) = max{sum(n-1) + a[n], a[n], sum(n-1)};
	public int arrayMaxSum(int[] array){
		int totalSum = array[0];
		int max = array[0];
		for(int i = 1; i < array.length; i++){
			if((totalSum + array[i]) > array[i]){
				totalSum += array[i];
			}else{
				totalSum = array[i];
			}
			if(totalSum > max){
				max = totalSum;
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {10, -2, -3, -10, 3, -7, -2, -5};
		SubArrayMaxSum maxArraySum = new SubArrayMaxSum();
		int maxSum = maxArraySum.arrayMaxSum(a);
		System.out.println(maxSum);
	}

}
