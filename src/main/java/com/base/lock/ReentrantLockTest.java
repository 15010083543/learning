package com.base.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/8/15 10:02
 * @version: 1.0
 * @Description: TODO
 * 在使用阻塞等待获取锁的方式中，必须在try代码块之外，并且在加锁方法与try代码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在finally中无法解锁。
 * 说明一：如果在lock方法与try代码块之间的方法调用抛出异常，那么无法解锁，造成其它线程无法成功获取锁。
 * 说明二：如果lock方法在try代码块之内，可能由于其它方法抛出异常，导致在finally代码块中，unlock对未加锁的对象解锁，它会调用AQS的tryRelease方法（取决于具体实现类），抛出IllegalMonitorStateException异常。
 * 说明三：在Lock对象的lock方法实现中可能抛出unchecked异常，产生的后果与说明二相同。 java.concurrent.LockShouldWithTryFinallyRule.rule.desc
 *
 * Positive example：
 *     Lock lock = new XxxLock();
 *     // ...
 *     lock.lock();
 *     try {
 *         doSomething();
 *         doOthers();
 *     } finally {
 *         lock.unlock();
 *     }
 *
 *
 *
 * Negative example：
 *     Lock lock = new XxxLock();
 *     // ...
 *     try {
 *         // If an exception is thrown here, the finally block is executed directly
 *         doSomething();
 *         // The finally block executes regardless of whether the lock is successful or not
 *         lock.lock();
 *         doOthers();
 *
 *     } finally {
 *         lock.unlock();
 *     }
 *
 *
 *
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        boolean failed = false;
        /*try {
            int cout = 0;
            for (;;) {
                int sum = 1/0;
                    if (cout == 1){

                        failed = false;
                        System.out.println("run");
                        return;

                    }
                cout++;
            }
        } finally {

                System.out.println("final");
        }*/









        StampedLock stampedLock = new StampedLock();
        stampedLock.readLock();
        ReadWriteLock readLock = new ReentrantReadWriteLock();
        LockSupport.park();

        Lock lock = new ReentrantLock(false);
        lock.lock();
        try {
            System.out.println("11111");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        TestSemaphore();

    }

    private static void TestSemaphore(){
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();

        // 只能5个线程同时访问

        final Semaphore semp = new Semaphore(5);
        Lock lock = new ReentrantLock(false);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                @Override
                public void run() {

                    lock.lock();
                    try {
                        System.out.println("11111");
                        Thread.sleep((long) (100));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                    /*try {
                        // 获取许可
                        semp.acquire();

                        System.out.println("Accessing: " + NO);

                        Thread.sleep((long) (1000));

                        // 访问完后，释放
                        semp.release();
                    } catch (InterruptedException e) {

                    }*/

                }

            };
            exec.execute(run);
        }

        // 退出线程池
        exec.shutdown();
    }
}
