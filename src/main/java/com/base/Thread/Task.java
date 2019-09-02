package com.base.Thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author LiuPeng
 * @description 任务
 * @date 2018/6/16
 */
public class Task {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.get(0);
        List<Integer> b = new LinkedList<>();
        b.get(0);
        try {
            ExecutorService executorService = ThreadPool.getExecutorService();
            Future<Long> long1 = getValueAddedHouseDoc();
            Future<Long> long2 = getValueAddedHouseDoc2();
            Future<Long> long3 = getValueAddedHouseDoc3();
            Future<Long> long4 = getValueAddedHouseDoc4();
            System.out.println("main");
            Thread.sleep(1000);
            // long1.get(3000, TimeUnit.SECONDS);
            //Long aLong = long1.get();
            //System.out.println(aLong);

            //System.out.println(;
            System.out.println(long1.isDone());
            System.exit(-1);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Future<Long> getValueAddedHouseDoc() {
        return ThreadPool.getExecutorService().submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Thread.sleep(2000);
                System.out.println("111");
                return 11L;
            }
        });
    }

    private static Future<Long> getValueAddedHouseDoc2() {
        return ThreadPool.getExecutorService().submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                System.out.println("2222");
                return 11L;
            }
        });
    }
    private static Future<Long> getValueAddedHouseDoc3() {
        return ThreadPool.getExecutorService().submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                System.out.println("33333333");
                return 11L;
            }
        });
    }
    private static Future<Long> getValueAddedHouseDoc4() {
        return ThreadPool.getExecutorService().submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                System.out.println("4444444444444");
                return 11L;
            }
        });
    }
}
