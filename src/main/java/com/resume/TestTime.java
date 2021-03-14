package com.resume;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author: liupeng
 * @DateTime: Created in 2021/3/7 17:08
 * @version: 1.0
 * @Description: TODO
 */
public class TestTime {

    //  线程安全的ThreadLocal
    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

        public static void main(String[] args){
            //(1)获取当前系统时间
            Date date = new Date();
            System.out.println("系统当前时间      ："+simpleDateFormatThreadLocal.get().format(date));
            //(3)获取当前系统时间的前1秒种的时间
            Calendar c = new GregorianCalendar();
            c.setTime(date);//设置参数时间
            c.add(Calendar.SECOND,-1);//把日期往后增加SECOND 秒.整数往后推,负数往前移动
            c.get(Calendar.SECOND);
            date=c.getTime(); //这个时间就是日期往后推一天的结果
            String timepre = simpleDateFormatThreadLocal.get().format(date);
            System.out.println("系统前1秒时间："+timepre);
        }

}
