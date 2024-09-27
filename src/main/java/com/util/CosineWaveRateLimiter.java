package com.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.TimeUnit;

public class CosineWaveRateLimiter {

    private final AtomicInteger permits = new AtomicInteger(0);
    private final int maxPermits;
    private final long interval;
    private final long halfInterval;
    private long lastTick;

    public CosineWaveRateLimiter(int maxPermits, long interval) {
        this.maxPermits = maxPermits;
        this.interval = interval;
        this.halfInterval = interval / 2;
        this.lastTick = System.currentTimeMillis() - (System.currentTimeMillis() % interval);
    }

    public boolean tryAcquire() {
        long now = System.currentTimeMillis();
        if (now - lastTick >= interval) {
            // 时间窗口已过，重置许可数量
            permits.set(0);
            lastTick = now;
        }

        // 计算当前时间在时间窗口内的余弦值
        double cosineValue = Math.cos(2 * Math.PI * ((now - lastTick) % interval) / interval);
        int availablePermits = (int) (maxPermits * cosineValue);

        // 尝试获取许可
        if (availablePermits > 0 && permits.incrementAndGet() <= availablePermits) {
            return true;
        }

        // 释放许可
        permits.decrementAndGet();
        return false;
    }

    public static void main(String[] args) {
        CosineWaveRateLimiter rateLimiter = new CosineWaveRateLimiter(10, 60000); // 每秒10个许可，时间窗口60秒

        for (int i = 0; i < 100; i++) {
            try {
                if (rateLimiter.tryAcquire()) {
                    System.out.println("Request " + i + " allowed at " + System.currentTimeMillis());
                } else {
                    System.out.println("Request " + i + " blocked at " + System.currentTimeMillis());
                }
                Thread.sleep(50); // 模拟请求间隔
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}