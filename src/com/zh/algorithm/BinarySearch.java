package com.zh.algorithm;
/**
 * BinarySearch算法的实现
 *  1. BinarySearch 算法建立在已经排好序的一组有序数上
 *  2. 然后采用Divide and Conquer的形式进行处理查找
 */
public class BinarySearch {
    public static void main(String[] args){
        int [] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        int goal = 3;
        //1. 使用非递归的实现方法
//        int result = binarySearch(goal, array);
        int result = binarySearch(goal, 0 ,array.length - 1, array);
        if(result == -1){
        	System.out.println("查找失败");
        }else{
        	System.out.println("查找成功位置为 ： " + result);
        }
       
    }

    /**
     * 采用非递归的方法实现二分搜索
     * @param goal
     *          查找的目标
     * @param mArray
     *          需要进行查找的数组
     * @return
     *         返回最终查找结果的位置，如果查找失败返回-1
     */
    @SuppressWarnings("unused")
	private static int binarySearch(int goal, int[] mArray) {
        //初始化初始查找位置信息
        int low = 0, high=mArray.length - 1;
        int middle = 0;
        //开始分查
        while(low <= high){
        	middle=(low + high) / 2;
            if(goal == mArray[middle]){
                return middle;
            }else if(goal < mArray[middle]){
                high = middle - 1;
            }else if(goal > mArray[middle]){
                low = middle + 1;
            }
            
        }

        return -1;
    }

    /**
     * 采用递归的方式实现二分搜索
     * @param low
     *          需要查找的数组的最低位
     * @param high
     *          需要查找的数组的最高位
     * @param mArray
     *          需要查找的数组
     * @param goal
     *          需要查找的目标
     * @return
     * 			返回最终查找结果的位置，如果查找失败返回-1
     */
    private static int binarySearch(int goal,int low,int high,int[] mArray) {
    	if(low <= high){
    		int middle = (low + high) / 2;
    		if(goal < mArray[middle]){
    			return binarySearch(goal, low,middle - 1,mArray);
    		}else if(goal > mArray[middle]){
    			return binarySearch(goal, middle + 1,high,mArray);
    		}else{
    			return middle;
    		}
    	}else
    		return -1;

    }
}
