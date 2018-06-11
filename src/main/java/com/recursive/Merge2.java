package com.recursive;

/**
 * @author LiuPeng
 * @description 归并算法2
 * @date 2018/6/9
 */
public class Merge2 {

    private static int[] theArray = new int[]{9, 8, 3, 5, 1, 4, 2, 10};

    public static void main(String[] args) {
        int[] workSpace = new int[theArray.length];// 待复制的数组，长度一样
        recMergeSort(workSpace, 0, theArray.length - 1);
        System.out.println("-----------------------------");
        for (int i = 0; i < theArray.length; i++) {
            System.out.println(theArray[i]);
        }
    }

    public static void recMergeSort(int[] array, int low, int up) {
        System.out.println("low:" + low + ",up:" + up);
        int mid = 0;
        if (low == up) {
            return;
        } else {
            mid = (low + up) / 2;
            recMergeSort(array, low, mid);
            recMergeSort(array, mid + 1, up);// up的值一直在变化
            merg(array, low, mid + 1, up);// 归并两个有序的部分
        }
        /*
        low:0,up:7
        low:0,up:3
        low:0,up:1
        low:0,up:0
        low:1,up:1
        归并：highPtr:1,low:0,up:1
        low:2,up:3
        low:2,up:2
        low:3,up:3
        归并：highPtr:3,low:2,up:3
        归并：highPtr:2,low:0,up:3
        low:4,up:7
        low:4,up:5
        low:4,up:4
        low:5,up:5
        归并：highPtr:5,low:4,up:5
        low:6,up:7
        low:6,up:6
        low:7,up:7
        归并：highPtr:7,low:6,up:7
        归并：highPtr:6,low:4,up:7
        归并：highPtr:4,low:0,up:7
        */

    }

    public static void merg(int[] array, int low, int highPtr, int up) {
        System.out.println("归并：highPtr:" + highPtr + ",low:" + low + ",up:" + up);
        int j = 0;
        int lowerBound = low;
        int mid = highPtr - 1;
        int n = up - lowerBound + 1;
        while (low <= mid && highPtr <= up) {
            if (theArray[low] < theArray[highPtr]) {
                array[j++] = theArray[low++];
            } else {
                array[j++] = theArray[highPtr++];
            }
        }
        while (low <= mid) {
            array[j++] = theArray[low++];
        }
        while (highPtr <= up) {
            array[j++] = theArray[highPtr++];
        }

        for (j = 0; j < n; j++) {
            theArray[lowerBound + j] = array[j];
        }
    }
}
