package com.designPattens.decoratePatten.redPacket;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Merchandise {
    private String sku;//商品SKU
    private String name; //商品名称
    private BigDecimal price; //商品单价
    private Map<PromotionType, SupportPromotions> supportPromotions; //支持促销类型
}