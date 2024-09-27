package com.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.TreeMap;

public class SlidingWindowRateLimiter {
    private final long windowSize; // 窗口大小，单位为毫秒
    private final long interval; // 时间段间隔，单位为毫秒
    private final int limit; // 每个时间段内的最大请求数
    private final TreeMap<Long, AtomicInteger> requestCounts; // 存储时间段和请求计数的映射

    public SlidingWindowRateLimiter(long windowSize, long interval, int limit) {
        this.windowSize = windowSize;
        this.interval = interval;
        this.limit = limit;
        this.requestCounts = new TreeMap<>();
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        long windowStart = now - (now % interval); // 计算当前时间段的开始时间
        long windowEnd = windowStart + windowSize; // 计算窗口结束时间

        // 滑动窗口，移除过期的时间段
        for (Long time : requestCounts.keySet()) {
            if (time < windowStart) {
                requestCounts.remove(time);
            }
        }

        // 增加当前时间段的请求计数
        AtomicInteger count = requestCounts.getOrDefault(windowStart, new AtomicInteger());
        if (count.incrementAndGet() > limit) {
            // 超过限制，拒绝请求
            count.decrementAndGet();
            return false;
        }

        // 检查并更新窗口内的总请求计数
        long totalRequests = 0;
        for (AtomicInteger count_ : requestCounts.values()) {
            totalRequests += count_.get();
        }
        if (totalRequests > (windowSize / interval) * limit) {
            // 窗口内总请求超过限制，拒绝请求
            requestCounts.entrySet().iterator().next().getValue().decrementAndGet();
            return false;
        }

        return true;
    }
}