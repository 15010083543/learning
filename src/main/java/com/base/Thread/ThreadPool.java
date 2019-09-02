package com.base.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuPeng
 * @description 线程池
 * @date 2018/6/16
 */
public class ThreadPool {

    // private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(3000);
    private static int availableProcessors = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executorService = new ThreadPoolExecutor(availableProcessors,
            availableProcessors * 2 + 1, 0L, TimeUnit.MICROSECONDS, queue,
            new ThreadPoolExecutor.CallerRunsPolicy());

    public ThreadPool() {
    }

    /**
     * 获取执行线程服务
     *
     * @param
     * @return ExecutorService
     * @author lusp
     * @created 2018年06月13日 13:35
     */
    public static ExecutorService getExecutorService() {
        return executorService;
    }
}
