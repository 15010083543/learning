package com.arithmetic.sort;

/**
 * 描述
 *
 * @author liupeng
 * @version 1.0
 * @date 2022/04/28 20:45:41
 */
public class MergeSort2 {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 11, 62, 3, 21, 5, 1, 8, 9, 19};
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (high + low) >> 1;
            mergeSort(arr, low, mid, tmp); // 对左边排序
            //System.out.println("mergeSort1");
            mergeSort(arr, mid + 1, high, tmp);  // 对右边排序
            //System.out.println("mergeSort2");
            mergeSortFun(arr, low, mid, high, tmp);  // 合并
            //System.out.println("mergeSort3");
        }
    }

    private static void mergeSortFun(int[] arr, int low, int mid, int high, int[] tmp) {
        System.out.println("low=" + low + "&mid=" + mid + "&high=" + high );
        int i = 0;
        int j = low; // 左边的起始索引
        int k = mid+1; // 右边的起始索引   
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        while (k <= high) {
            tmp[i++] = arr[k++];
        }

        for (int l = 0; l < i; l++) {
            arr[low + l] = tmp[l];
        }
        //for (int l = 0; l < tmp.length; l++) {
        //    System.out.print(tmp[l] + ",");
        //}
                                      
                                        
    }                                
}
