package com.base;

import org.junit.Test;

/**
 * @author LiuPeng
 * @description 基础测试
 * @date 2018/12/15
 */
public class TestBase {

    @Test
    public void test() {
        System.out.println((2+'a'));
        System.out.println((char)(2+'a'));
        System.out.println(Integer.toBinaryString(11));
        // 把int类型转成二进制
        String s = "";
        for (int n = 11 ; n>0; n/=2){
            System.out.println("=="+n);
            s = (n % 2) + s;
        }
        System.out.println(s);
        Comparable[] a = {1,5,7};
    }
}
