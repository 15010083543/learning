package com.arithmetic.sort;

/**
 * @author LiuPeng
 * @description 选择排序 第一个元素和之后的元素依次比较
 * @date 2018/12/7
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = Comment.genric(10, 0, 10);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[i] < array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                 }
            }
        }
        System.out.println(Comment.validate(array));
        Comment.print(array);
    }
}
