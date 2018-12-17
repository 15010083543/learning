package com.arithmetic3.sort;

import java.util.Arrays;

/**
 * @author LiuPeng
 * @description 模板类
 * @date 2018/12/15
 */
public class Example {

    public static void show(Comparable[] arr) {
        Arrays.asList(arr).stream().forEach(i -> System.out.println(i));
        System.out.println();
    }
}
