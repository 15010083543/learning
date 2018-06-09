package com.sort;

/**
 * @author LiuPeng
 * @description 插入排序：数组的局部元素是有顺序的
 * @date 2018/5/31
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 2, 5, 7, 6};
        int in, out;
        // 从第二个元素开始比较
        for (out = 1; out < array.length; out ++) {
            int temp = array[out];
            in = out;
            // 找到应该插入的位置
            while (in > 0 && array[in - 1] >= temp){
                array[in] = array[in - 1];
                --in;
            }
            // 把待排序的元素存入指定位置
            array[in] = temp;
        }
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }

}
