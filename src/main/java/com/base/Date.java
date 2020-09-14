package com.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/8/20 11:17
 * @version: 1.0
 * @Description: TODO
 */
public class Date {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String format = dateTimeFormatter.format(LocalDateTime.parse("2007-12-03T10:15:30"));
        System.out.println(format);
        // System.out.println(parse.toString());
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.isAfter(LocalDateTime.of(2020, 8, 20, 10, 00, 00)));
        System.out.println(now.isBefore(LocalDateTime.of(2020, 8, 20, 12, 00, 00)));


        // 在这个日期之前
        System.out.println(now.isAfter(LocalDateTime.parse("2020-08-03T10:15:30")));
        // 在这个日期之后
        System.out.println(now.isBefore(LocalDateTime.parse("2020-12-03T10:15:30")));

        dateTimeFormatter.format(LocalDateTime.now());
    }
}
