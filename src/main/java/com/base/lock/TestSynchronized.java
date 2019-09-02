package com.base.lock;

/*
    一个是实例锁（锁在某一个实例对象上，如果该类是单例，那么该锁也具有全局锁的概念），
    一个是全局锁（该锁针对的是类，无论实例多少个对象，那么线程都共享该锁）。
    实例锁对应的就是synchronized关键字，而类锁（全局锁）对应的就是static synchronized（或者是锁在该类的class或者classloader对象上）

    一个锁的是类对象，一个锁的是实例对象。
    若类对象被lock，则类对象的所有同步方法全被lock；
    若实例对象被lock，则该实例对象的所有同步方法全被lock。

*/
public class TestSynchronized {
    public synchronized void test1() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                TestSynchronized.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
//         TestRunnable tr=new TestRunnable();  
//         Thread test3=new Thread(tr);  
//         test3.start();
    }

}  