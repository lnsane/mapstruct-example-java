package com.example.mapstructexamplejava.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Getter
@Setter
public class OrderVO {
    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 订单时间
     */
    private String orderTime;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 订单是否关闭
     */
    private Boolean isClose;

    /**
     * 价格
     */
    private String price;
}
