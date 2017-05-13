package com.zh.algorithm;

import java.util.Random;

/**
 * 实现快速排序（加强版）
 * 	因为快速排序的最坏情况出现在已经排好序的情况下，如果现在你使用二叉树将这个方法的
 *  分布情况画出来的话，你就会清楚的看到这个就是二叉树的最高的情况，而对于递归来说也是最深的情况
 *  我们知道递归的层数越多，就会越慢，时间也就花费的越多，所以这个加强版的基本思想是，无论你原始数据是
 *  怎样的，第一步就是打乱你这些数据，打乱的方式有多种，比如随机数的方法以及随机选取pivot的方法
 *  这里采取随机选取pivot的方法
 * @author young
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[]{10,2,8,7,22,19}; 
		int[] results = quickSort(array,0,array.length - 1);
		//打印结果
				StringBuffer buffer = new StringBuffer();
				buffer.append("[");
				for(int m = 0; m < results.length; m++){
					if(m == results.length - 1){
						buffer.append(results[m] + "]");
						continue;
					}
					buffer.append(results[m] + ",");
				}
				System.out.println(buffer.toString());
		
	}

	/**
	 * 实现快速排序
	 * @param array
	 * 			需要进行排序的数组
	 * @param start
	 * 			开始进行排序的位置
	 * @param end
	 * 			最终的位置
	 * @return
	 * 			已经排好序的数组
	 */
	private static int[] quickSort(int[] array, int start, int end) {
		
		
		if(start < end){
			int r = partition(array,start,end);
			quickSort(array, start, r - 1);
			
			quickSort(array, r + 1, end);
		}
		
		return array;
	}

	/**
	 * 进行分块的方法
	 * @param array
	 * 		需要分块的数组
	 * @param start
	 * 		开始分块的位置
	 * @param end
	 * 		结束分块的位置
	 * @return
	 * 		分好快的中间位置
	 */
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
	 * 产生符合要求的随机数   start < pivot < end 
	 * @param start
	 * @param end
	 */
	private static int getPivot(int start, int end) {
		boolean flag = true;
		int pivot = start;
		while(flag){
			pivot = (int) (Math.random() * ((start + end) / 2 ));
			if(pivot >= start && pivot <= end){
				flag = false;
				
			}
				
			
		}
		return pivot;
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
