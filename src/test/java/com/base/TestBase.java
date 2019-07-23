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

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    @Test
    public void testvolatile() {
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        increase();
                };
            }.start();
        }
        System.out.println(inc);

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(inc);
    }
}
