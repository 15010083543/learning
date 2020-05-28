package com.base.Thread;

/**
 * @Author: liupeng
 * @DateTime: 2020/4/1 21:45
 * @Description: 线程的两种方式
 */
public class TestThread extends Thread{

    @Override
    public void run() {
        System.out.println("test thread");
    }

    public static void main(String[] args) {
        new TestThread().start();
    }
}
