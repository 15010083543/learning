package com.designPattens.strategyPatten;

/**
 * @author LiuPeng
 * @description
 * @date 2018/11/26
 */
public class Price {

    private int money;

    public Price(int money) {
        this.money = money;
    }

    public Price() {
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
