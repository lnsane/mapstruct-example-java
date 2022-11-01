package com.example.mapstructexamplejava.service;

import com.example.mapstructexamplejava.model.dto.OrderDTO;
import com.example.mapstructexamplejava.model.vo.OrderVO;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
public interface OrderService {
    OrderVO queryOrder(OrderDTO orderDTO);

    OrderVO insertOrder(OrderDTO copyOrderDto);
}
