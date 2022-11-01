package com.example.mapstructexamplejava.model.params;

import lombok.Getter;
import lombok.Setter;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Getter
@Setter
public class OrderParams {
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
