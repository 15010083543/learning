package com.util;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;

/**
 * @author LiuPeng
 * @description cpu
 * @date 2019/12/1
 */
public class CPUMonitorCalc {
    private static CPUMonitorCalc instance = new CPUMonitorCalc();

    private OperatingSystemMXBean osMxBean;
    private ThreadMXBean threadBean;
    private long preTime = System.nanoTime();
    private long preUsedTime = 0;

    private CPUMonitorCalc() {
        osMxBean = ManagementFactory.getOperatingSystemMXBean();
        threadBean = ManagementFactory.getThreadMXBean();
    }

    public static CPUMonitorCalc getInstance() {
        return instance;
    }

    public double getProcessCpu() {
        long totalTime = 0;
        for (long id : threadBean.getAllThreadIds()) {
            totalTime += threadBean.getThreadCpuTime(id);
        }
        long curtime = System.nanoTime();
        long usedTime = totalTime - preUsedTime;
        long totalPassedTime = curtime - preTime;
        preTime = curtime;
        preUsedTime = totalTime;
        return (((double) usedTime) / totalPassedTime / osMxBean.getAvailableProcessors()) * 100;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    long bac = 1000000;
                    bac = bac >> 1;
                }
            }).start();;
        }
        while (true) {
            Thread.sleep(5000);
            System.out.println(CPUMonitorCalc.getInstance().getProcessCpu());
        }

    }
}
