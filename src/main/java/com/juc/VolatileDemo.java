package com.juc;

/**
 * @Author: liupeng
 * @DateTime: Created in 2021/2/23 9:54
 * @version: 1.0
 * @Description: TODO
 */
public class VolatileDemo {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
        while (true) {
            if (threadDemo.isFlag()) {
                System.out.println("主线程感知已修改" + threadDemo.isFlag());
                break;
            }
            System.out.println("----------------"+threadDemo.isFlag());
        }
    }


}
