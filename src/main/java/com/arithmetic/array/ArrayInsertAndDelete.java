package com.arithmetic.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiuPeng
 * @description Array插入和删除
 * 数组不能同时即定义长度，又定义元素
 * @date 2019/12/17
 */
public class ArrayInsertAndDelete {

    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        for (int i = 0; i< 7; i++){
            array[i] = i;
        }
        print(array);
        insert(array, 7, 10);
        delete(array, 2);
        print(array);
    }

    public static void print(Integer[] array){
        List<Integer> list = Arrays.asList(array);
        list.stream().forEach(x -> System.out.println(x));
    }

    /*
    *@description 插入元素:从最后的元素开始往后移
    *@param array 原数组
    @param index 插入下标
    @param value 插入值
    *@return void
    */
    public static void insert(Integer[] array, int index, int value){
        if (null == array || index < 0 || index > array.length) {
            System.out.println("error");
            return;
        }
        for (int count = array.length-1; count > index; count--) {
            array[count] = array[count-1];
        }
        array[index] = value;
    };

    /*
    *@description 删除元素
    *@param array 原数组
    @param index 删掉下标
    */
    public static void delete(Integer[] array, int index){
        if (null == array || index < 0 || index > array.length) {
            System.out.println("error");
            return;
        }
        for (int count = index +1; count < array.length; count++) {
            array[count-1] = array[count];
        }
    };


}
