package com.base.Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/9/25 16:05
 * @version: 1.0
 * @Description: 多个线程等到同一个时间节点开始同时执行
 */
@Slf4j
public class TestCyclicBarrier {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println("{} is ready"+ threadNum);
        barrier.await();
        System.out.println("{} continue" + threadNum);
    }
}
