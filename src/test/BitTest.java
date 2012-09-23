package test;

public class BitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int bitInt = 1024 * 64 + 100;
		
		bitInt |= bitInt >>> 1;
		bitInt |= bitInt >>> 2;
		bitInt |= bitInt >>> 4;
		bitInt |= bitInt >>> 8;
		bitInt |= bitInt >>> 16;

		System.out.println(bitInt);
	}

}
