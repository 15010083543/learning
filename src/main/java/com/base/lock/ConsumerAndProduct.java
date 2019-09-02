package com.base.lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiuPeng
 * @description 生产者消费者
 * @date 2019/8/31
 */
public class ConsumerAndProduct {

    protected static final ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
            100, 2,
            TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(),
            new ThreadFactory() {
                public AtomicInteger id = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("home-service-" + id.addAndGet(1));
                    return thread;
                }
            }, new ThreadPoolExecutor.CallerRunsPolicy());
    static boolean falg = false;
    static int cur = 1;

    public static void main(String[] args) {
        ConsumerAndProduct consumerAndProduct = new ConsumerAndProduct();
        for (int i = 0; i < 100; i++) {
            executor.submit(new Consumer(consumerAndProduct));
            executor.submit(new Product(consumerAndProduct));
        }
    }

    // 生产者
    static class Consumer implements Runnable {
        private ConsumerAndProduct consumerAndProduct;
        public Consumer(ConsumerAndProduct consumerAndProduct){
            this.consumerAndProduct = consumerAndProduct;
        }
        @Override
        public void run() {
            synchronized (consumerAndProduct) {
                if (falg) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                cur++;
                System.out.println("生产者" + cur);
                falg = true;
                this.notify();
            }
        }
    }

    // 消费者
    static class Product implements Runnable {
        private ConsumerAndProduct consumerAndProduct;
        public Product(ConsumerAndProduct consumerAndProduct){
            this.consumerAndProduct = consumerAndProduct;
        }
        @Override
        public void run() {
            synchronized (consumerAndProduct) {
                if (!falg) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                cur--;
                System.out.println("消费者 " + cur);
                falg = false;
                this.notify();
            }
        }
    }
}
