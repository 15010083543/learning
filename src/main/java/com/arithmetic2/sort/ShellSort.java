package com.arithmetic2.sort;

/**
 * @author LiuPeng
 * @description 希尔排序
 * 希尔排序的思想？
 * A：使数组中任意间隔为 h 的元素都是有序的。这样的数组被称为 h 有序数组，也就是说：
 * 一个 h 有序数组就是 h 个相互独立的有序数组编织在一起组成的一个数组。
 *
 * Q：它的一种实现方法？
 * A：在插入排序的代码中将移动元素的距离由 1 改为 h 即可。
 * Q：h 的取值？
 * A：增幅 h 的初始值是数组长度乘以一个常数因子，最小为 1 。
 * 例如： while( h < arr.length/3 ) h = 3 * h + 1 ； //（1、4、13、40、121、364、1093…）
 * 尝试使用  while( h < arr.length/5 ) h = 5 * h + 1 ；// 1、6、31、156、781... ，速度会变快。
 *
 * @date 2018/12/8
 */
public class ShellSort {

    public static void main(String [] args)
    {
      /*int[] array = Comment.genric(10, 0, 10);
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
        Comment.print(array);*/

      // 对h的取值进行优化
       // int[] arr = Comment.genric(10, 0, 10);
        int[] arr = {9,10,11,12,1,6,7,3,4,2};
        int length = arr.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;  // 1 , 4 , 13 , 40 , 121 , 364 , 1093...
        }
        while (h >= 1) {
            for (int i = 0; i < h; i++) { // 确定可以分成几个子列
                System.out.println("第一层for");
                for (int j = i + h; j < arr.length; j=j+h) { // 确定每个子列的最后一个元素
                    System.out.println("第二层for");
                    int temp = arr[j];//要比较的第二个元素
                    System.out.println("temp-="+temp);
                    int x;
                    for (x = j - h; x >= 0 && arr[x] > temp ; x= x-h) { // 确定每个子列的第一个元素，并且和第二个元素进行比较
                        System.out.println("第三层for=="+x);
                        System.out.println("arr[x]="+arr[x]);
                        arr[x+h] = arr[x];
                        System.out.println("arr[x + h]" +arr[x + h]);
                        System.out.println("arr[x]" +arr[x]);
                    }
                    arr[x+h] = temp;// 如何对比的值发生交换就是确认的第一个元素的值，如果没有交换就赋的第二个元素的值
                }
            }
            h = h / 3;
        }
        System.out.println(Comment.validate(arr));
        Comment.print(arr);
    }
}

