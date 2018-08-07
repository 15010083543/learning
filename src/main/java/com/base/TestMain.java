package com.base;

/**
 * @author LiuPeng
 * @description 垃圾回收
 * vm 参数配置：-verbose:gc -XX:+PrintGCDetails（打印GC日志）
 * @date 2018/8/6
 */
public class TestMain {

    public static void main(String[] args) {

        TestMain main = new TestMain();
        main = null;

        System.gc();

    }

}
