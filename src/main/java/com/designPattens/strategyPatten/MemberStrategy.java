package com.designPattens.strategyPatten;

/**
 * @author LiuPeng
 * @description 会员价格策略
 * @date 2018/11/26
 */
public class MemberStrategy extends Price implements PriceStrategy {
    @Override
    public double PriceStrategy(Price price) {
        return price.getMoney() * 0.9;
    }
}
