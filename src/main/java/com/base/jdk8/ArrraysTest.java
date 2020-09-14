package com.base.jdk8;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/9/2 15:54
 * @version: 1.0
 * @Description: TODO
 */
public class ArrraysTest {
    public static void main(String[] args) {
        String[] arrays = {"", "12", "22"};
        System.out.println(MessageFormat.format("aa{0},bb{1},cc{2}", arrays));
        Arrays.asList(arrays).stream().forEach(x -> System.out.println(x));
    }
}
