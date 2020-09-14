package com.base.jdk8.stream;

import java.util.function.Function;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/8/16 17:03
 * @version: 1.0
 * @Description: TODO
 */
public class FunctionDemo {
    public static void main(String[] args) {
/*
       Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String accept) {
                System.out.println("aaa");
                return accept;
            }
        };
*/
        Function<String, String> function = (b) -> { return b;};
        System.out.println(function.apply("aaa"));
    }
}
