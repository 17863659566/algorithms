package com.zh.algorithm;
/**
 * 伪代码
 * merge_sort a[n]
 * if n > 1
 * merge_sort a[1..a[n/2]]   取下限
 * merge_sort a[a[n/2]+1..n]
 * merge a[1..n]
 */
public class MergeSort {

    private int[] numbers; //需要排序的数组
    private int number;  //需要排序的数组的长度
    private int[] helper; //最后排序的时候使用

    public int[] sort(int[] numbers) {
        this.numbers = numbers;
        this.number = numbers.length;
        this.helper = new int[number];
        mergeSort(0, number - 1);
        return numbers;
    }

    private void mergeSort(int low, int high) {
        //检查low < high 在mergeSort的过程中由于两端的list越来越小，所以可能会出现low = high或者
        //low > high 如果出现这种情况就代表这个sort的list已经完成了
        if(low < high){
            int middle = low + (high - low) / 2;
            mergeSort(low,middle);
            mergeSort(middle + 1, high);
            merge(low,middle,high);
        }
    }

    /*
     * 将排序好的n个list合并,这是个树形的结构，因为是前面使用的是递归算法，所以这个合并
     * 也是从树叶处开始的合并
     * @param low
     * @param middle
     * @param high
     */
    private void merge(int low, int middle, int high) {
        //先将这一部分数据拷贝到helper中
        for(int i = low;i <= high;i++){
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;  //i,j  用于去处理原来的list  k 用于处理helper
        int k = low;

        //将较小的数据拷贝到原始数组
        while(i <= middle && j <= high){
            if(helper[i] <= helper[j]){
                numbers[k] = helper[i];
                i++;
            }else{
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        while(i <= middle){
            numbers[k] = helper[i];
            i++;
            k++;
        }
    }
}
