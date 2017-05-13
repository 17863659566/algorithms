package com.zh.algorithm;

/**
 * 计算乘方 两种实现 1.使用普通的方法逐个相乘得到最后结果 2.使用divide and conquer的形式来处理 比较这两个算法实现的具体时间
 * 
 * @author young
 *
 */
public class PoweringNumber {

	static double nativeStartTime = 0;
	static double recursiveStartTime = 0;
	static double nativeEndTime = 0;
	static double recursiveEndTime = 0;

	public static void main(String[] args) {
		powerNumber();
	}

	private static void powerNumber() {

		/**
		 * 对于10000^10000来说，这个时间上就有差别了，结果为
		 * 	普通方法使用时间 ：1.0 -- 0递归方式使用时间 +  : 0.0 -- 0
		 * 	普通方法的时间复杂度为 T(n) = θ(n)
		 * 	而递归方法的时间复杂度为 T(n) = θ(lgn)  但是空间占据大，也就是拿空间来换时间
		 */
		nativeStartTime = System.currentTimeMillis();
		long nativePowerNumber = nativePowerNumber(10000, 10000);
		nativeEndTime = System.currentTimeMillis();

		recursiveStartTime = System.currentTimeMillis();
		long recursivePowerNumber = recursivePowerNumber(10000, 10000);
		recursiveEndTime = System.currentTimeMillis();

		System.out.println("普通方法使用时间 ：" + (nativeEndTime - nativeStartTime) + " -- " + nativePowerNumber
				+ "递归方式使用时间 +  : " + (recursiveEndTime - recursiveStartTime) + " -- " + recursivePowerNumber);
	}

	/**
	 * 使用递归形式计算乘方运算
	 * 
	 * @param power
	 *            次幂数
	 * @param number
	 *            结果数据
	 * @param originNumber
	 *            原始的数据
	 * @return 乘方的计算结果
	 */
	private static long recursivePowerNumber(long number, long power) {
		if (power == 1)
			return number;
		// 首先判断power是even还是odd
		if (power % 2 == 0) {
			return recursivePowerNumber(number, power / 2) * recursivePowerNumber(number, power / 2);

		} else {
			return recursivePowerNumber(number, (power - 1) / 2) * recursivePowerNumber(number, (power - 1) / 2)
					* number;
		}

	}

	/**
	 * 使用普通形式计算乘方运算
	 * 
	 * @param power
	 *            次幂数
	 * @param number
	 *            底数
	 * @return 乘方的计算结果
	 */
	private static long nativePowerNumber(int number, int power) {
		long result = 1;
		for (int i = 0; i < power; i++) {
			result *= number;
		}

		return result;
	}

}
