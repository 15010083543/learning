package com.designPattens.decoratePatten.redPacket;

import java.math.BigDecimal;

public class BaseCount implements IBaseCount {

    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        orderDetail.setPayMoney(orderDetail.getMerchandise().getPrice());
        System.out.println("商品原单价金额为：" + orderDetail.getPayMoney());
        return orderDetail.getPayMoney();
    }
}