package com.zh.algorithm;

/**
 * 实现插入排序
 *
 * 伪代码 ：（由小到大排序）
 *  insert_sort(A[n])
 *      for i = 2 to n;
 *         key = A[n];
 *         j = i - 1;
 *         while j > 0 and A[j] > key do
 *              A[j + 1] = A[j];
 *              j = j - 1;
 *         A[j + 1 ] = key;
 */
public class InsertionSort {


    /**
     * 实现插入排序，按照伪代码的思路来实现
     * @param a 来进行排序的数组
     */
    public static int[] sort(int[] a) {
        int key;
        int j;
        for(int i = 1;i < a.length;i++){
            key = a[i];
            j = i - 1;
            while(j >= 0 && a[j] > key){
                a[j + 1] = a[j];
                j -= 1;
            }
            a[j + 1] = key;
        }
        return a;
    }
}
