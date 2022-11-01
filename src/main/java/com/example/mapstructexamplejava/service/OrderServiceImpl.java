package com.example.mapstructexamplejava.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mapstructexamplejava.mapper.OrderMapper;
import com.example.mapstructexamplejava.model.convent.OrderConvent;
import com.example.mapstructexamplejava.model.dto.OrderDTO;
import com.example.mapstructexamplejava.model.enums.OrderStatusEnum;
import com.example.mapstructexamplejava.model.po.Order;
import com.example.mapstructexamplejava.model.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderConvent orderConvent;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderVO queryOrder(OrderDTO orderDTO) {
        OrderStatusEnum orderStatus = orderDTO.getOrderStatus();
        Order order = orderMapper.selectOne(Wrappers.<Order>lambdaQuery()
                .eq(Order::getOrderStatus, orderStatus.getStatus())
                .last("LIMIT 1"));
        Assert.notNull(order,"order is not found !");
        return orderConvent.copyOrderVo(order);
    }

    @Override
    public OrderVO insertOrder(OrderDTO copyOrderDto) {
        Order order = orderConvent.copyOrderPo(copyOrderDto);
        orderMapper.insert(order);
        return orderConvent.copyOrderVo(order);
    }
}
