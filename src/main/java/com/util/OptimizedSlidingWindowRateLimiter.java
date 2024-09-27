package com.util;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

public class OptimizedSlidingWindowRateLimiter {
    private final long windowSize; // 窗口大小，单位为毫秒
    private final long interval; // 时间段间隔，单位为毫秒
    private final int limit; // 每个时间段内的最大请求数
    private final ConcurrentSkipListMap<Long, AtomicLong> requestCounts; // 存储时间段和请求计数的映射
    private final Thread cleanupThread; // 用于定期清理过期时间段的后台线程

    public OptimizedSlidingWindowRateLimiter(long windowSize, long interval, int limit) {
        this.windowSize = windowSize;
        this.interval = interval;
        this.limit = limit;
        this.requestCounts = new ConcurrentSkipListMap<>();
        this.cleanupThread = new Thread(this::cleanup, "SlidingWindowCleanupThread");
        this.cleanupThread.start();
    }

    private void cleanup() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(interval);
                cleanupExpiredWindows();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private void cleanupExpiredWindows() {
        /*long now = System.currentTimeMillis();
        long expiredWindowEnd = now - windowSize;
        Iterator<Long, AtomicLong> iterator = requestCounts.tailMap(expiredWindowEnd).iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }*/
    }

    public boolean tryAcquire() {
        long now = System.currentTimeMillis();
        long windowStart = now - (now % interval);
        AtomicLong count = requestCounts.get(windowStart);
        if (count == null) {
            count = new AtomicLong(0);
            requestCounts.put(windowStart, count);
        }

        if (count.incrementAndGet() <= limit) {
            return true;
        }

        count.decrementAndGet();
        return false;
    }
}