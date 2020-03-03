package com;

import lombok.Data;

/**
 * @author LiuPeng
 * @description
 * @date 2020/1/10
 */
@Data
public class Student {
    private int age;
    private String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
