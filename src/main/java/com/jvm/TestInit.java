package com.jvm;

/**
 * 描述
 *
 * @author liupeng
 * @version 1.0
 * @date 2022/04/25 20:04:03
 */
public class TestInit {

    public static int tmp = 1;

    static {
        tmp = 2;
        System.out.println(tmp);
    }

    public static void main(String[] args) {
        Long a = 0L;
        tmp = 3;
        System.out.println(tmp);
        ClassLoader classLoader = TestInit.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
    }
}
