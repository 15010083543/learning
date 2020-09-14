package com.base.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/8/17 16:35
 * @version: 1.0
 * @Description: TODO
 */
public class AtomicDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.getAndIncrement();
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
    }
}
