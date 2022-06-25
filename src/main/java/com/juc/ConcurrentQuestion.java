package com.juc;

/**
 * 描述
 *
 * @author liupeng
 * @version 1.0
 * @date 2022/04/02 17:57:24
 */
public class ConcurrentQuestion {

    static int addValue = 0;

    synchronized int get(){
        return addValue;
    }

    synchronized static int add(){
        for (int i = 0; i < 10000; i++) {
            addValue = addValue + 1;
        }
        return addValue;
    }

    public static void main(String[] args) throws InterruptedException {
        final int a = 0;
        ConcurrentQuestion concurrentQuestion = new ConcurrentQuestion();
         Thread thread1 = new Thread(() -> {
             concurrentQuestion.add();
             System.out.println(a);
        });
        Thread thread2 = new Thread(() -> {
            concurrentQuestion.add();
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(concurrentQuestion.get());


    }

}
