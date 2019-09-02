package com.base.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LiuPeng
 * @description 10个线程如何同时开启
 * @date 2019/8/26
 */
public class TestConcurrent {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " time : " + System.currentTimeMillis());
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("-----");
    }
}
