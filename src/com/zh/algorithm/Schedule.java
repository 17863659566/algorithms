package com.zh.algorithm;
public class Schedule {
    public static void main(String[] args){
        int[] a = new int[]{10,4,3,12,45};
        int[] sort = scheduleInsertionSort(a);
        print(sort);


    }

    private static int[] scheduleInsertionSort(int[] a) {
//        return InsertionSort.sort(a);

        return new MergeSort().sort(a);
    }

    /**
     * 打印结果
     * @param sort  排好序的数组
     */
    private static void print(int[] sort) {
        System.out.print("[ ");
        for(int i = 0;i < sort.length;i++){
            System.out.print(sort[i] + " ");
        }
        System.out.print("]");
    }
}
