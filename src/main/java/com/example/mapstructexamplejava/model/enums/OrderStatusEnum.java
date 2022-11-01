package com.example.mapstructexamplejava.model.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Getter
@NoArgsConstructor
public enum OrderStatusEnum {
    /**
     * 创建
     */
    CREATE(1),

    /**
     * 等待
     */
    PADDING(2),

    /**
     * 关闭
     */
    CLOSE(3);

    /**
     * 订单状态
     */
    private Integer status;
    OrderStatusEnum(Integer i) {
        this.status = i;
    }
}
