package com.arithmetic.recursive;

/**
 * @author LiuPeng
 * @description 二分查找（有序的数组中查找）
 * @date 2018/6/9
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 4, 5, 6, 7, 9};
        System.out.println("recursive"+binaryRecursive(array, 8, 0, array.length - 1));
        System.out.println(binaryFor(array, 7));
    }

    public static int binaryFor(int[] array, int search){
        int low = 0;
        int up = array.length - 1; // 避免数组下标越界
        while (true) {
            int cur = (low + up) / 2;
            if (search == array[cur]) {
                return cur;
            } else if (low > up) {
                return -1;
            } else {
                if (search < array[cur]) {
                    up = cur - 1;
                } else {
                    low = cur + 1;
                }
            }
        }
    }

    public static int binaryRecursive(int[] array, int search, int low ,int up){
        int cur = (low + up ) / 2;
        if (search == array[cur]) {
            return cur;
        } else if (low > up) {
            return -1;
        } else {
            if (search < array[cur]) {
                return binaryRecursive(array, search, low, cur-1);
            } else {
                return binaryRecursive(array, search, cur + 1, up);
            }
        }
    }
}
