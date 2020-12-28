package com.pnf.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.pnf.bean.Order;
import com.pnf.service.OrderService;


import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl  implements OrderService {
    @Override
    public List<Order> getUserOrder() {
        Order order1 = new Order();
        order1.setOrderCode("20124000");
        order1.setUserId("1");
        order1.setPrice(200.00);
        order1.setSize(2);

        Order order2 = new Order();
        order2.setOrderCode("20124005");
        order2.setUserId("1");
        order2.setPrice(200.00);
        order2.setSize(1);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        return orderList;
    }
}
