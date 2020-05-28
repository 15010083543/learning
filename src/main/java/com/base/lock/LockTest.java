package com.base.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: liupeng
 * @DateTime: 2020/4/12 15:39
 * @Description: TODO
 */
public class LockTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
    }
}
