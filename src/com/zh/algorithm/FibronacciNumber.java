package com.zh.algorithm;

/**
 * 求解斐波那契数列
 * 使用普通形式求解和分治法求解
 * @author young
 *
 */
public class FibronacciNumber {

	public static void main(String[] args) {
		int result = fibonacciNumber(5);
		System.out.println("结果为 : " + result);
	}

	/**
	 * 求解斐波那契  时间复杂度为T(n) = Ω(ψ^n)
	 * @param limit  
	 * 			求解的斐波那契数列的项数
	 * @return
	 * 			返回最终结果
	 */
	private static int fibonacciNumber(int limit) {
//		int result = nativeFibonacciNumber(limit);
		int[] results = new int[]{
				1,1,
				1,0
		};
		int[] result = createFibonaccciNumber(limit,results);
		return result[1];
	}

	/**
	 * 时间复杂度为T(n) = θ(n)
	 * 使用分治法来解决斐波那契数列
	 * @param limit 
	 * 			求解的斐波那契数列的项数
	 * @param results
	 * 			这个是斐波那契数列的一个矩阵底数
	 * @return
	 * 			返回最终结果
	 */
	private static int[] createFibonaccciNumber(int limit,int[] results) {
		
		
		if(limit == 1){
			return results;
		}
		
		if(limit % 2 == 0){
			int[] matrix1 = createFibonaccciNumber(limit / 2,results);
			int[] matrix2 = createFibonaccciNumber(limit / 2, results);
			return computeMatrixPower(matrix1,matrix2);
			
		}else{
			int[] matrix1 = createFibonaccciNumber(limit / 2,results);
			int[] matrix2 = createFibonaccciNumber(limit / 2, results);
			int[] matrixPower = computeMatrixPower(matrix1, matrix2);
			return computeMatrixPower(matrixPower, results);
		}
	
	}

	private static int[] computeMatrixPower(int[] matrix1, int[] matrix2) {
		return new int[]{
				matrix1[0] * matrix2[0] + matrix1[1] * matrix2[2],matrix1[0] * matrix2[1] + matrix1[1] * matrix2[3],
				matrix1[2] * matrix2[0] + matrix1[2] * matrix2[3],matrix1[2] * matrix2[1] + matrix1[3] * matrix2[3],
			};
	}

	/**
	 * 使用普通的递归来求解斐波那契数列
	 * @param limit 
	 * 			求解的斐波那契数列的项数
	 * @return
	 * 			返回最终结果
	 */
	@SuppressWarnings("unused")
	private static int nativeFibonacciNumber(int limit) {
		if(limit <= 1){
			return limit;
		}else{
			return nativeFibonacciNumber(limit -1) + nativeFibonacciNumber(limit - 2);
		}
	}

}
