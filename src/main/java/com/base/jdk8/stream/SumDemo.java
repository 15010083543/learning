package com.base.jdk8.stream;

import java.util.stream.LongStream;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/8/16 16:38
 * @version: 1.0
 * @Description: TODO
 */
public class SumDemo {

    public static void main(String[] args) {
        // 用stream并行流，求1，到1亿的和
        Long sum = LongStream.rangeClosed(1, 1_0000_10000).parallel().reduce(1, Long::sum);
        System.out.println(sum);
    }
}
