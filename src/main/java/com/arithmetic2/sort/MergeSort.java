package com.arithmetic2.sort;

import java.util.Arrays;

/**
 * @author LiuPeng
 * @description 归并排序
 * @date 2018/12/10
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = Comment.genric(10, 0, 10);
        Comment.print(arr);
        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);
        int[] arr2 = Arrays.copyOfRange(arr, 0, arr.length);
        sort(arr1, 0, arr.length - 1); // 自上而下的方式
        Comment.print(arr1);
        merg2(arr2, arr.length); // 自下而上的方式
        Comment.print(arr2);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    public static void sort(int[] arr, int left, int right){
        if (left >= right) return;
        int mid = (left + right) >>> 1;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        System.out.println("111111111111111111111111");
        merg(arr, left, mid, right);
    }

    // 自上而下的方式
    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    public static void merg(int[] arr, int left, int mid, int right){
        System.out.println("-----------------------");
        // 复制数组
        int[] aux = Arrays.copyOfRange(arr, left, right + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = left, j = mid + 1;
        for (int k = left; k < right + 1; k++) {
            if ( i > mid){// 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-left]; j++;
            } else if (j > right) {// 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-left]; i++;
            } else if (aux[i-left] < aux[j-left]) {// 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-left]; i++;
            } else {// 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - left]; j++;
            }
        }
    }


    // 自下而上的方式
    public static void merg2(int arr[], int n){
        for (int sz = 1; sz <= n; sz+=sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                merg(arr, i, i + sz -1, min(i + sz + sz -1, n - 1));
            }
        }
    }

    public static int min(int count, int count2){
        if (count < count2) {
            return count;
        }
        return count2;
    }
}
