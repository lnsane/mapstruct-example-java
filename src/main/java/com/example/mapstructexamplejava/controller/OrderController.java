package com.example.mapstructexamplejava.controller;

import com.example.mapstructexamplejava.model.convent.OrderConvent;
import com.example.mapstructexamplejava.model.params.OrderParams;
import com.example.mapstructexamplejava.model.vo.OrderVO;
import com.example.mapstructexamplejava.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.mapstructexamplejava.controller.OrderController.OrderApi.PREFIX;


/**
 * @author CunLu Wang
 * @since 2022/10/31
 */
@RestController
@RequestMapping(value = PREFIX)

public class OrderController {
    public interface OrderApi {
        String PREFIX = "/order";
        String QUERY_ORDER = "/query";
        String QUERY_ORDER_LIST = "/query/list";
        String SAVE_ORDER = "/save";
    }

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderConvent orderConvent;


    @GetMapping(OrderController.OrderApi.QUERY_ORDER)
    public OrderVO queryOrder(@ModelAttribute OrderParams orderParams) {
        return orderService.queryOrder(orderConvent.copyOrderDto(orderParams));
    }

    @PostMapping(OrderApi.SAVE_ORDER)
    public OrderVO saveOrder(@RequestBody OrderParams orderParams) {
        return orderService.insertOrder(orderConvent.copyOrderDto(orderParams));
    }

}
