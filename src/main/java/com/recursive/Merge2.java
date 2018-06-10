package com.recursive;

/**
 * @author LiuPeng
 * @description 归并算法2
 * @date 2018/6/9
 */
public class Merge2 {

    private static  int[] theArray = new int[]{9,8,3,5};
    public static void main(String[] args) {
        int[] workSpace = new int[theArray.length];// 待复制的数组，长度一样
        recMergeSort(workSpace, 0, theArray.length - 1);
        System.out.println("-----------------------------");
        for (int i = 0; i < theArray.length; i++) {
            System.out.println(theArray[i]);
        }
    }

    public static void recMergeSort(int[] array, int low, int up){
        int mid = 0;
        if (low == up) {
            return;
        } else {
            mid = (low + up) / 2;
            recMergeSort(array, low, mid);
            recMergeSort(array, mid + 1, up);
            merg(array, low, mid + 1, up);
        }
        System.out.println(mid);
    }

    public static void merg(int[] array, int low,
                            int highPtr, int up){
        int j = 0;
        int lowerBound = low;
        int mid = highPtr -1;
        int n = up- lowerBound + 1;
        while (low <= mid && highPtr <= up){
            if (theArray[low] < theArray[highPtr]) {
                array[j++] = theArray[low++];
            } else {
                array[j++] = theArray[highPtr ++];
            }
        }
        while (low <= mid) {
            array[j++] = theArray[low++];
        }
        while (highPtr <= up){
            array[j++] = theArray[highPtr++];
        }

        for (j = 0; j < n; j++) {
            theArray[lowerBound+j] = array[j];
        }
    }
}
