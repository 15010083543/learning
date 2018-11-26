package com.designPattens.strategyPatten;

/**
 * @author LiuPeng
 * @description 具体如何使用价格
 * @date 2018/11/26
 */
public class PriceUse {

    private PriceStrategy priceStrategy;

    public PriceUse(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public double opreationPrice(Price price){
       return priceStrategy.PriceStrategy(price);
    }
}
