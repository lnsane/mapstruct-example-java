package com.example.mapstructexamplejava.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Getter
@Setter
@TableName(value = "`order`")
public class Order {
    /**
     * 主键id
     */
    private Integer id;
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
    private Integer orderStatus;

    /**
     * 是否关闭
     */
    private Boolean isClose;

    /**
     * 价格
     */
    private Long price;
}
