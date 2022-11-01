package com.example.mapstructexamplejava.model.test;

import lombok.Getter;
import lombok.Setter;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Getter
@Setter
public class OrderTest {
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
    private int orderStatus;

    /**
     * 订单是否关闭
     */
    private Boolean isClose;

    /**
     * 金额
     */
    private String price;
}
