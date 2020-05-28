package com.arithmetic.sort;

/**
 * @author LiuPeng
 * @description 插入排序 从第二个元素开始和第一个元素比，然后第三个元素和前两个比，然后依次进行并排序
 * 思想是先把前面的一部分元素排好序，再把新元素插入到适合位置,就不需要全部都排序了
 *
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
 * @date 2018/12/7
 */
public class InsertSort {

    public static void main(String[] args) {
        /*int[] array = Comment.genric(10, 0, 10);
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (array[j-1] > array[j]) {
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println(Comment.validate(array));
        Comment.print(array);
*/
        // 优化版本：给要比的值做一个副本，不是直接交换,只是处理与其对比值的位置，最后找到合适的位置才给对比的值赋值
        int[] array = Comment.genric(10, 0, 10);
        // 从第二个元素开始比较
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            // 找到应该插入的位置
            for ( ; j > 0 && array[j-1] > tmp; j--) { // 注意j的取值，只有在交换的时候j的值才会发生变化
                    array[j] = array[j-1];
            }
            array[j] = tmp;
        }
        System.out.println(Comment.validate(array));
        Comment.print(array);
    }
}
