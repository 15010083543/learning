package com.base;

/**
 * @author LiuPeng
 * @description 代码块的顺序
 * @date 2019/7/18
 */
public class CodeSortTest {

    public static void main(String[] args) {
        Father father = new Son();
    }

    /** 输出
     父类代码块
     子类代码块
     父类普通代码块
     父类构造方法
     子类普通代码块
     子类构造方法
    */
}
