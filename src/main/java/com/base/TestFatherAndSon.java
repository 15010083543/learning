package com.base;

/**
 * @author LiuPeng
 * @description
 * @date 2019/7/23
 */
public class TestFatherAndSon {

    public static void main(String[] args) {
        FatherInterface sonInterface = new SonInterface();
        Father father = sonInterface.get();
        System.out.println("aa");
    }
}
