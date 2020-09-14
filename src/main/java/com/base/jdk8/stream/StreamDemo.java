package com.base.jdk8.stream;

import com.common.People;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/8/16 16:45
 * @version: 1.0
 * @Description: TODO
 */
public class StreamDemo {
    public static void main(String[] args) {
        // 求年龄为偶数,年龄大于27,用户名转为大写，倒序，输出第一个人的name
        People people1 = new People(30, "a");
        People people2 = new People(26, "b");
        People people3 = new People(27, "c");
        People people4 = new People(28, "d");
        People people5 = new People(29, "e");
        List<People> people = Arrays.asList(people1, people2, people3, people4, people5);
        people.stream()
                .filter(p->{return p.getAge() % 2 ==0;})
                .filter(p->{return p.getAge()>26;})
                .map(p -> {return p.getName().toUpperCase();})
                .sorted((p1,p2)-> {return p2.compareTo(p1);})
                .limit(1)
                .forEach(System.out::println);

    }
}
