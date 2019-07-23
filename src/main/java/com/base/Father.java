package com.base;

/**
 * @author LiuPeng
 * @description 父类
 * @date 2019/7/18
 */
public class Father {

    private int age;
    private String name;

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

    // 执行时机
    //　　静态代码块在类被加载的时候就运行了，而且只运行一次，并且优先于各种代码块以及构造函数。
    // 如果一个类中有多个静态代码块，会按照书写顺序依次执行。后面在比较的时候会通过具体实例来证明。
    static {
        System.out.println("父类静态代码块");
    }

    //执行时机
    //　　构造代码块在创建对象时被调用，每次创建对象都会调用一次，但是优先于构造函数执行
    {
        System.out.println("父类构造代码块");
    }

    public Father(){
        System.out.println("父类构造方法");
    }

}
