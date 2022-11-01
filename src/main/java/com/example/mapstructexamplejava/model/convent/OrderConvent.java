package com.example.mapstructexamplejava.model.convent;

import com.example.mapstructexamplejava.model.dto.OrderDTO;
import com.example.mapstructexamplejava.model.enums.OrderStatusEnum;
import com.example.mapstructexamplejava.model.params.OrderParams;
import com.example.mapstructexamplejava.model.po.Order;
import com.example.mapstructexamplejava.model.vo.OrderVO;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class OrderConvent {
    @BeforeMapping
    protected void conventPrice(OrderParams orderParams) {
        orderParams.setPrice(String.valueOf(Double.parseDouble(orderParams.getPrice()) * Math.pow(10,6)));
    }
    @Mapping(target = "orderStatus",expression = "java(orderStatusEnumMap(orderParams.getOrderStatus()))")
    @Mapping(target = "price",numberFormat = "#")
    @Mapping(target = "orderTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    public abstract OrderDTO copyOrderDto(OrderParams orderParams);

    @Mapping(target = "orderStatus",expression = "java(orderDTO.getOrderStatus().getStatus())")
    public abstract OrderVO copyOrderVo(OrderDTO orderDTO);

    @Mapping(target = "orderStatus",expression = "java(orderDTO.getOrderStatus().getStatus())")
    public abstract Order copyOrderPo(OrderDTO orderDTO);

    @Mapping(target = "orderTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    public abstract OrderVO copyOrderVo(Order order);

    @AfterMapping
    protected void conventPrice(@MappingTarget OrderVO orderVO) {
        orderVO.setPrice(new BigDecimal(orderVO.getPrice()).divide(BigDecimal.valueOf(Math.pow(10,6)),4, RoundingMode.HALF_UP).toString());
    }

    protected OrderStatusEnum orderStatusEnumMap(Integer value) {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.getStatus().equals(value)) {
                return orderStatusEnum;
            }
        }
        return null;
    }
}
