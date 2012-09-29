package algorithmsSubjects.subject03;

/**
 * 求子数组的最大和
题目：
输入一个整形数组，数组里有正数也有负数。
数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
求所有子数组的和的最大值。要求时间复杂度为O(n)。

例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
因此输出为该子数组的和18。

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
