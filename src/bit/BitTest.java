package bit;

public class BitTest {
	
	/**
	 * ���ƣ�*2�Ĵη�
	 * ���ƣ�/2�Ĵη�
	 */
	public static void mul(){
		int a = 5;
		a = a << 2;
		System.out.println(a);
		
		a = -20;
		a = a >> 2;
		System.out.println(a);
		
		double b = 12.456;
		b = (int)b << 2;
	    System.out.println(b);
	}
	
	/**
	 * ��������
	 * @param a
	 * @param b
	 */
	public static void swap(int a, int b){
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println("a = " + a + ", b = " + b);
	}
	
	/**
	 * ȡ��
	 * @param a
	 */
	public void inverse(int a){
		a = ~a + 1; // a = -a;
		System.out.println(a);
	}
	
	/**
	 * ���b��2�Ĵη���������ô˷�������ȡģ
	 * @param a
	 * @param b
	 */
	public void mod(int a, int b){
		a = a & (b - 1); // a = a % b;
		System.out.println(a);
	}
	
	/**
	 * �ж��Ƿ�Ϊż��
	 * @param a
	 * @return
	 */
	public boolean isEven(int a){
		return (a & 1) == 0 ? true : false;// (a % 2) == 0;
	}
	
	/**
	 * ����ȡ��
	 * @param a
	 * @return
	 */
	public static int inverse4Minus(int a){
		int b = (a ^ (a >> 31)) - (a >> 31); 
		System.out.println(b);
		return b;
	}
	
	/**
	 * ȡ����ֵ
	 * @param a
	 */
	public static void abs(int a){
		int b = (a ^ (a >> 31)) - (a >> 31);// int b = (a > 0) : a ? -a;
		System.out.println(b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mul();
		swap(-19, 30);
		inverse4Minus(-123);
		abs(-122);
		abs(23);
	}

}
