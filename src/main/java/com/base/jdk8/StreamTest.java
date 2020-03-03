package com.base.jdk8;

import com.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * @author LiuPeng
 * @description
 * @date 2020/1/10
 */
public class StreamTest {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        //collect()方法深入源码详解
        //op1:集合转换为stream, 然后stream转换为List
        List<Student> students1 = students.stream().collect(Collectors.toList());
        students1.forEach(System.out::println);
        System.out.println("----------");
        System.out.println("count: "+ students.stream().collect(counting()));//Collectors类提供的counting()方法
        System.out.println("count: "+ students.stream().count()); //stream提供的方法 , 底层实现 mapToLong()->sum

    }
}
