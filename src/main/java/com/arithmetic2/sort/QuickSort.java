package com.arithmetic2.sort;

import java.util.Arrays;

/**
 * @author LiuPeng
 * @description 快速排序
 * 思想：把第一个元素作为基准，然后把小于这个元素的其它元素向左移动，把大于这个元素的其它元素向右移动，
 *     用递归的思想依次移动，关键是找到这个基准元素的位置
 *
 * 优化：
 *      1.如何小于16个元素可以插入元素
 * @date 2018/12/11
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = {9,10,11,12,1,6,7,3,4,2};
        Arrays.asList(arr).stream().forEach(i -> System.out.print(i));
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        Arrays.asList(arr).stream().forEach(i -> System.out.println(i));
    }

    private static void quickSort(Integer[] arr, int i, int h) {
        if (i >= h) {
            return;
        }
        int partion = getPartion(arr, i, h);// 找到元素的固定位置，然后再把两边的子数组重新排序
        System.out.println("partion=="+partion);
        Arrays.asList(arr).stream().forEach(x -> System.out.print(x));
        System.out.println();
        quickSort(arr, i, partion - 1); // 小于partion左边的数组进行排序
        quickSort(arr, partion + 1, h);// 大于partion左边的数组进行排序
    }

    private static int getPartion(Integer[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                int tmp = arr[++ j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        int tmp = arr[l];
        arr[l] = arr[j];
        arr[j] = tmp;
        return j;
    }
}
