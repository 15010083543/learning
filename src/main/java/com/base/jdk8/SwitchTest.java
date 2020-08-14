package com.base.jdk8;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/8/14 14:22
 * @version: 1.0
 * @Description: TODO
 */
public class SwitchTest {

    public static void test(String falg, String falg2){
        switch (falg){
            case "a":
            case "b":
                System.out.println("b");
                break;
            case "c":
                switch (falg2) {
                    case "b":
                        System.out.println("b");
                        break;
                }
            default:
                System.out.println("d");
                break;
        }
    }
}
