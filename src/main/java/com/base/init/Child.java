package com.base.init;

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
        System.out.println((1-1)/0 +1);
        System.out.println(Math.ceil(-1.01));
    }

}
