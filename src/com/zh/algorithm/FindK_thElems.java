package com.zh.algorithm;

import java.util.Random;

public class FindK_thElems {

	public static void main(String[] args) {
		int[] A = {4,1,3,2,16,9,10,14,8,7};
		for(int i = 0;i < A.length;i++)
		System.err.println(findKthElements(A,0,A.length - 1,i+1) + ",");
	}

	/**
	 * 在不排序的状态下获取第i小的元素
	 * 
	 * 
	 * pseudo code :
	 * 	Random Select(A,p,r,i)
	 * 		if p = r
	 * 			then return A[p]
	 * 		q ← Random-Partition(A,p,r)
	 * 		k ← q - p + 1
	 * 		if i == k
	 *          then return A[q]
	 *      if i < k
	 *      	then return Random-Select(A,p,q-1,i)
	 *      else
	 *      	then return Random-Select(A,q+1,r,i-k)
	 * @param a
	 * 		需要查找
	 * @param p
	 * 		要查找数组的开始位置
	 * @param r
	 * 		要查找数组的结束位置
	 * @param i
	 * 		要查找的元素的位置
	 * @return
	 * 		查找到的元素
	 */
	private static int findKthElements(int[] a,int p,int r,int i) {
		if(p == r)
			return a[p];
		int q = partition(a, p, r);
		int k = q - p + 1;
		if(k == i)
			return a[q];
		else if(k < i)
			return findKthElements(a, q + 1, r, i - k);
		else
			return findKthElements(a, p, q - 1, i);
	
	}
	
	private static int partition(int[] array, int start, int end) {
		// =============================================
			//这一部分不会对分界产生很大的影响，但是却解决了排好序的数列的尴尬
		Random random = new Random();
		int pivot = random.nextInt(end - start) + start;
		
		swap(array, start, pivot);
		
		//===============================================
		int x = array[start];
		int i = start;
		int j = start + 1;
		for(;j <= end;j++){
			if(array[j] <= x){
				i = i + 1;
				swap(array,i,j);
			}
		}
		
		swap(array,start,i);
		
		
		
		
		
		return i;
		
				
	}
	
	/**
	 * 交换两个数据
	 * @param array
	 * 			需要交换的数组 
	 * @param i
	 * 			第一个参数
	 * @param j
	 * 			第二个参数
	 */
	private static void swap(int[] array, int i, int j) {
		//打印结果
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
