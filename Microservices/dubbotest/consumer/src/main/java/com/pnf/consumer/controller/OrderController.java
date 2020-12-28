package com.pnf.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pnf.bean.Order;
import com.pnf.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Reference
    private OrderService OrderService;

    @RequestMapping("/getOrders")
    public List<Order> getAllOrder(){
        List<Order> orderList = OrderService.getUserOrder();
        return orderList;
    }
}
