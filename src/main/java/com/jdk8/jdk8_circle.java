package com.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiuPeng
 * @description jdk1.8的特性
 * @date 2018/8/7
 */
public class jdk8_circle {
    public static void main(String[] args) {
       /* String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> list = Arrays.asList(atp);

        for (String l : list) {
            System.out.println(l+";");
        }
        System.out.println("----------");
        // 循环输出的方式一
        list.forEach((l) -> System.out.println(l+";"));
        System.out.println("----------");
        // 循环输出的方式二
        list.forEach(System.out :: println);*/

        // 使用匿名内部类
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("lamdba");
            }
        }).start();

        new Thread(()-> System.out.println("lamdba1")).start();*/

        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        };
        race1.run();

        Runnable race2 = () -> System.out.println("匿名内部类2");
        race2.run();
    }
}
