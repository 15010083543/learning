package com.arithmetic.sort;

/**
 * 描述
 * 随机找到基准位的数字，放到数组的第一个位置，从左往右找比基准数小的第一个值，从右往左找比基准值大的第一个值，两数进行交换，直到两个变量相等，然后交换基准值和当前值
 * 然后把数组切成两半，重复上面的操作
 * @author liupeng
 * @version 1.0
 * @date 2022/04/27 17:48:45
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        int i,j,temp,t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        // 基准位
        temp = arr[low];

        while(i < j){
            // 先看右边，依次从右往左，找到小于基准数的数字
            while (temp <= arr[j] && i < j){
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        // 将基准数与i和j相等位置的数字进行交换
        arr[low] = arr[i];
        arr[i] = temp;
        // 递归调用右半部分
        quickSort(arr, low, j-1);
        // 递归调用左半部分
        quickSort(arr, j + 1, high);
    }
}