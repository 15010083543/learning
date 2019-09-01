package com.hystrix;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuPeng
 * @description 过载保护和有损服务
 * @date 2019/8/26
 */
public class TestSave {

    private static Map<Integer, Long> map = new HashMap<>();

    static {
        map.put(1, 1000 * 10L); // 10ms
        map.put(2, 1000 * 120L); // 2m
        map.put(1, 1000 * 300L); // 5m
    }

    // 四个限流级别
    private static int[] level = {0, 1, 2, 3};
    // 当前限流级别
    private static int curlevel = 0;
    // 记录时间
    private static long time = 0L;

    private static void invoker(int curlevel) {
        switch (curlevel) {
            case 0:
                // 方法
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("0");
                curlevel = 0; // 恢复默认级别
                break;
        }
    }

    public static void main(String[] args) {
        // 检测时间
        Long intervalTtime = map.get(curlevel);
        Lock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
            // 时间的检测一个级别对应不同的时间间隔，限流级别可以动态
            if (System.currentTimeMillis() - time > intervalTtime && curlevel > 0) {
                time = System.currentTimeMillis();
                curlevel--;
            }
        } finally {
            reentrantLock.unlock();
        }
        invoker(curlevel);
    }

    // 修改级别
    public static void updateLevel() {
        // 超时的处理（不应该修改级别）取消超时开关设置
        // 并发修改的处理（利用时间戳来修改）
        Lock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
            if (System.currentTimeMillis() - time < 10) { // 10ms
                curlevel++;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

}
