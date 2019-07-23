package com.base;

/**
 * @author LiuPeng
 * @description 子类
 * @date 2019/7/18
 */
public class Son extends Father {

    private String love;

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public Son(String love) {
        this.love = love;
    }

    @Override
    public String toString() {
        return "Son{" +
                "love='" + love + '\'' +
                '}';
    }

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类构造代码块");
    }

    public Son(){
        System.out.println("子类构造方法");
    }



}
