package com.arithmetic.recursive;

/**
 * @author LiuPeng
 * @description 归并算法(归并已经有序的两个数组)
 * @date 2018/6/9
 */
public class Merge {

    public static void main(String[] args) {
        int[] a = new int[]{1,5,7};
        int[] b = new int[]{2,4,6};
        int[] c = new int[6];
        int aIndex = a.length;
        int bIndex = b.length;
        int sizeA = 0;
        int sizeB = 0;
        int sizeC = 0;
        while (sizeA < aIndex && sizeB < bIndex) {
            // 1.进行顺序比较
            if (a[sizeA] < b[sizeB]) {
                c[sizeC++] = a[sizeA++];
            } else {
                c[sizeC++] = b[sizeB++];
            }
        }
        while (sizeA < aIndex){ // 2.当数组B已经为空时，把数组A移到数组C中
            c[sizeC++] = a[sizeA++];
        }
        while (sizeB < bIndex){// 3.当数组A已经为空时，把数组B移到数组C中
            c[sizeC++] = b[sizeB++];
        }
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
