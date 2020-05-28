package com.base.Thread;

/**
 * @Author: liupeng
 * @DateTime: 2020/4/1 21:48
 * @Description: TODO
 */
public class TestRunable implements Runnable {

    @Override
    public void run() {
        System.out.println("---------");
    }

    public static void main(String[] args) {
        TestRunable testRunable = new TestRunable();
        Thread thread = new Thread(testRunable);
        thread.start();
    }
}
