package com.designPattens.decoratePatten.redPacket;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetail {
    private int id; //详细订单ID
    private int orderId;//主订单ID
    private Merchandise merchandise; //商品详情
    private BigDecimal payMoney; //支付单价
}