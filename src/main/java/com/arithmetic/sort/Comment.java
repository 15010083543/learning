package com.arithmetic.sort;

import java.util.Random;

/**
 * @author LiuPeng
 * @description 公共类
 * @date 2018/12/6
 */
public class Comment {

    public static int[] genric(int start, int rangL, int rangR){
        int[] array = new int[start];
        for (int i = 0; i < start; i++) {
            array[i] = new Random().nextInt(rangR - rangL) + 1;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = genric(100,0,100);
        print(array);
    }

    public static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static boolean validate(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) return false;
        }
        return true;
    }

}
