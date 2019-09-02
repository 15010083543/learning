package com.sort;

import com.arithmetic.sort.Comment;
import org.junit.Test;

/**
 * @author LiuPeng
 * @description 测试希尔排序
 * @date 2018/12/14
 */
public class TestShell {
    @Test
    public void testQuick() {
        //int[] arr = Comment.genric(10, 0, 10);
        int[] arr = {90,10,11,12,20,6,7,3,4,2};
        Comment.print(arr);
        System.out.println("--------------");
        merger(arr, 0, arr.length);
        Comment.print(arr);
    }


    private void merger(int[] arr, int left, int right) {
        int h = arr.length; // 10
        while (h >= 1) {
            h = h/2; // h=2
            for (int i = 0; i < h; i++) { // i=0，
                for (int j = i + h; j < arr.length; j+=h) { // j=2,4
                    int tmp = arr[j]; // tmp= 11,20
                    int k;
                    for (k = j - h; k >= 0 && arr[k] > tmp ; k-=h) { // k= 0,-2,2
                        /*int tmp1 = arr[k]; // 交换基准值的具体位置
                        arr[k] = tmp;
                        tmp = tmp1;*/
                        arr[k + h] = arr[k]; // 交换一次,交换一次
                        // {9,10,11,12,20,6,7,3,4,2};
                    }
                    arr[k + h] = tmp;// 赋值，赋值

                }
            }
            if (h == 1) {
                break;
            }
        }
    }

    /*private void merger(int[] arr, int left, int right) {
        int h = arr.length;
        while (h >= 1) {
            h = h/2;
            for (int i = 0; i < h; i++) { // 把数组可以分为几段
                for (int j = i + h; j < arr.length; j+=h) { // 找到要比较的第二个元素
                    int tmp = arr[j];
                    int k;
                    for (k = j - h; k >= 0 && arr[k] > tmp ; k-=h) { // 找到要比较的第一个元素
                        *//*int tmp1 = arr[k]; // 交换基准值的具体位置
                        arr[k] = tmp;
                        tmp = tmp1;*//*
                       arr[k + h] = arr[k]; // 只先个第二个元素赋值
                    }
                    arr[k + h] = tmp; //为什么不能用arr[j]，因为有可能这个值已经发生了变化; 最后给第一个元素赋值
                }
            }
            if (h == 1) {
                break;
            }
        }
    }*/

}