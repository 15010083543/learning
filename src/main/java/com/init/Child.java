package com.init;

/**
 * @author LiuPeng
 * @description 子类
 *
 * @date 2018/8/12
 */
public class Child extends Parent{

    public final static int num2 = 10;

    static{
        i = 1;
        //System.out.println(i);
    }

    static int i = 0;
    public static void main(String[] args) {
        //System.out.println("test init");
        System.out.println(Child.num);
    }

}
