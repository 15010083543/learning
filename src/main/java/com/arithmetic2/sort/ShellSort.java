package com.arithmetic2.sort;

/**
 * @author LiuPeng
 * @description 希尔排序
 * @date 2018/12/8
 */
public class ShellSort {

    public static void main(String [] args)
    {
        int[] array = Comment.genric(10, 0, 10);
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
        // 确定子列的长度(按长度的一半) （每次分组中元素的物理位置间隔（以元素大小为单位））
        int h = array.length;
        while (true){
            h = h/2;
            for (int i = 0; i < h; i++) { // 确定可以分成几个子列
                System.out.println("第一层for");
                for (int j = i + h; j < array.length; j=j+h) { // 确定每个子列的最后一个元素
                    System.out.println("第二层for");
                    int temp = array[j];//要比较的第二个元素
                    int x;
                    for (x = j - h; x >= 0 && array[x] > temp ; x= x-h) {// 确定每个子列的第一个元素，并且和第二个元素进行比较
                        System.out.println("第三层for");
                        array[x+h] = array[x];
                    }
                    array[x+h] = temp;// 如何对比的值发生交换就是确认的第一个元素的值，如果没有交换就赋的第二个元素的值
                }
            }
            if (h == 1) {
                break;
            }
        }
        System.out.println(Comment.validate(array));
        Comment.print(array);
    }
}

