package com.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author LiuPeng
 * @description jdk1.8提供的异步Future
 * @date 2019/7/17
 */
public class CompeltableFutrueTest {

    private static final Random random = new Random();

    public static String randomDelay() {
        int delay = 500 + random.nextInt(2000);
        try {
            System.out.println(String.format("%s sleep in %d", Thread.currentThread().getName(), delay));
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s sleep in %s", Thread.currentThread().getName(), "end"));
        return Thread.currentThread().getName() + " return";
    }

    public static void main(String[] args) {
       /* CompletableFuture[] futures = {
                CompletableFuture.supplyAsync(() -> randomDelay()),
                CompletableFuture.supplyAsync(() -> randomDelay()),
                CompletableFuture.supplyAsync(() -> randomDelay())
        };
        Void join = CompletableFuture.allOf(futures).join();
        System.out.println("all timeout process end");*/

        CompletableFuture[] futures = {
                CompletableFuture.supplyAsync(() -> randomDelay()),
                CompletableFuture.supplyAsync(() -> randomDelay()),
                CompletableFuture.supplyAsync(() -> randomDelay())
        };
        Object join = CompletableFuture.anyOf(futures).join();
        System.out.println("all timeout process end");

        /*CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "test ";
        }).thenApply(u -> {
            System.out.println(Thread.currentThread().getName());
            return u + " in thenApply first ";
        }).thenCompose(u -> CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return u + "in thenCompose second ";
        })).thenAccept(u -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(u + "in thenAccept last");
        });*/
    }
}
