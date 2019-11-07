package com.base.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author LiuPeng
 * @description 排序
 * @date 2018/8/7
 */
public class jdk8_sort {

    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });

        /*Comparator<String> comparator = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, comparator);*/
        // 简化
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));

        List<String> list = Arrays.asList(players);
        System.out.println("-------------------------");
        list.forEach(System.out :: println);
        System.out.println("-------------------------");
        list.forEach((l) -> System.out.println(l + ";"));

       // 使用lamda遍历list获取list下标的两种方式
        /*List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Stream.iterate(0, i -> i + 1).limit(list.size()).forEach(i -> {
            System.out.println(list.get(i));
        });
        IntStream.range(0,list.size()).forEach(i->{
            System.out.println(list.get(i));
        });*/

    }
}
