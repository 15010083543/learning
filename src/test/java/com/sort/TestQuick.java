package com.sort;

import com.arithmetic.sort.Comment;
import org.junit.Test;

/**
 * @author LiuPeng
 * @description 测试快速排序
 * @date 2018/12/14
 */
public class TestQuick {

    @Test
    public void testQuick() {
        int[] arr = Comment.genric(10, 0, 10);
        Comment.print(arr);
        System.out.println("--------------");
        quick(arr, 0, arr.length-1);
        Comment.print(arr);
    }

    private void quick(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = partion(arr, left, right);
        quick(arr, left, mid - 1);
        quick(arr, mid + 1, right);
    }

    // 注意数组的边界问题
    private int partion(int[] arr, int left, int right) {
        // 定义一个基准元素值
        int benchMark = arr[left];
        int j = left; // 定义元素变化的位置
        for (int i = left + 1; i <= right ; i++) { // 从基准元素的下一位开始比较, 然后交换位置
            if (arr[i] < benchMark) {
                int tmp = arr[i];
                arr[i] = arr[++j];// 交换的位置也是从基准元素的下一个位置
                arr[j] = tmp;
            }
        }
        int tmp = arr[left]; // 交换基准值的具体位置
        arr[left] = arr[j];
        arr[j] = tmp;
        return j;
    }
}
