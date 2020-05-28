package com.base.Thread;

import java.util.concurrent.*;

/**
 * @Author: liupeng
 * @DateTime: 2020/4/10 12:22
 * @Description: TODO
 */
public class CompletableFutureTest {



    public static void main(String[] args) {
        Executor executor = ThreadPool.getExecutorService();
        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println("hello world");
                return "result";
            }).thenApply((r) -> {
                System.out.println(r);
                return "aaa";
            }).thenApply((r) -> {
                System.out.println(r);
                return 1;
            });
            // runAsync是Runnable任务，不带返回值的，如果入参有executor，则使用executor来执行异步任务
            /*public static CompletableFuture<Void> runAsync(Runnable runnable)
            public static CompletableFuture<Void>  runAsync(Runnable runnable, Executor executor)
// supplyAsync是待返回结果的异步任务
            public static <U> CompletableFuture<U>  supplyAsync(Supplier<U> supplier)
            public static <U> CompletableFuture<U>  supplyAsync(Supplier<U> supplier, Executor executor)
*/
// 使用示例
            /*CompletableFuture.runAsync(() -> {
                System.out.println("hello world");
            }, executor);
            CompletableFuture<String> supplyAsync= CompletableFuture.supplyAsync(() -> {
                System.out.println("hello world");
                return "result";
            }, executor);
            System.out.println(supplyAsync.get());*/
















           /* // 创建一个带result的CompletableFuture
            CompletableFuture<String> future = CompletableFuture.completedFuture("result");
            future.get();

// 默认创建的CompletableFuture是没有result的，这时调用future.get()会一直阻塞下去知道有result或者出现异常
            future = new CompletableFuture<>();
            try {
                future.get(1, TimeUnit.SECONDS);
            } catch (Exception e) {
                // no care
            }

// 给future填充一个result
            future.complete("result");
            assert "result".equals(future.get());

// 给future填充一个异常
            future = new CompletableFuture<>();
            future.completeExceptionally(new RuntimeException("exception"));
            try {
                future.get();
            } catch (Exception e) {
                assert "exception".equals(e.getCause().getMessage());
            }
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
