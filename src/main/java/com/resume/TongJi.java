package com.resume;

import org.apache.commons.lang3.math.NumberUtils;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: liupeng
 * @DateTime: Created in 2021/3/8 10:03
 * @version: 1.0
 * @Description: TODO
 */
public class TongJi {

    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private static Long serverNum;

    public static void getServerNum(){
        // 1.给服务器编号
        //实例化一个客户端
        Jedis jedis = new Jedis("localhost");
        serverNum = jedis.incr("server_num");
        System.out.println(serverNum);
        serverNum = jedis.incr("server_num");
        System.out.println(serverNum);
        serverNum = jedis.incr("server_num");
        System.out.println(serverNum);
    }


    // 流量等级划分
    public static int getType(int num) {
        if (num < 2) {
            return 1;
        } else if (num < 4) {
            return 2;
        } else if (num < 6) {
            return 3;
        }  else {
            return 4;
        }

    }

    public static int getTimes() {
        // 1.给服务器编号
        //实例化一个客户端
        Jedis jedis = new Jedis("localhost");
        Calendar calendar = Calendar.getInstance();
        //把日期往后增加SECOND 秒.整数往后推,负数往前移动
        calendar.add(Calendar.SECOND,-1);
        // 上一秒的时间戳
        Long preSecond = calendar.getTimeInMillis()/1000;
        // 2.统计请求量
        String redisKey = serverNum + "_timeSum_" + preSecond;
        return NumberUtils.toInt(jedis.get(redisKey));
    }


    // 每天晚上定时任务去删除前一天的自增数据
    public static void main(String[] args) {
        getServerNum();
        for (int j = 0; j < 20; j++) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int threads = new Random().nextInt(8);
            System.out.println("线程数" + threads);
            CountDownLatch countDownLatch = new CountDownLatch(threads);
            for (int i = 1; i <= threads; i++) {
                new Thread(() -> {
                    inter();
                    countDownLatch.countDown();
                }, "thread - " + i).start();
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inter(){
        // 1. 获取上一秒的访问次数
        int num = getTimes();
        // 2. 获取流量等级
        int type = getType(num);
        System.out.println("流量等级" + type);
        // 3. 增加当前的请求次数
        incrTime();
    }

    public static void incrTime() {
        // 1.给服务器编号
        //实例化一个客户端
        Jedis jedis = new Jedis("localhost");
        Calendar calendar = Calendar.getInstance();
        // 这一秒的时间戳
        Long second = calendar.getTimeInMillis()/1000;
        // 2.统计请求量
        String redisKey = serverNum + "_timeSum_" + second;
        jedis.incr(redisKey);
    }
}
