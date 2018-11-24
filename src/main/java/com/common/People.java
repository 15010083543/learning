package com.common;

/**
 * @author LiuPeng
 * @description 实体类
 * @date 2018/11/23
 */
public class People {

    private int age = 25;
    private String name;

    public People() {
    }

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name="+this.name+"==========age="+this.age;
    }
}
