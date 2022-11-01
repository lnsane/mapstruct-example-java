package com.example.mapstructexamplejava.model.dto;

import com.example.mapstructexamplejava.model.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Getter
@Setter
public class OrderDTO {
    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 订单时间
     */
    private LocalDateTime orderTime;

    /**
     * 订单状态
     */
    private OrderStatusEnum orderStatus;

    /**
     * 订单是否关闭
     */
    private Boolean isClose;

    /**
     * 价格
     */
    private BigDecimal price;
}
