package com.cydeer.tool.demo.impl;

import com.cydeer.tool.demo.api.OrderService;
import com.cydeer.tool.demo.domain.Order;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author song.z
 * @date 2022/3/28 9:39 下午
 */
public class OrderServiceImpl implements OrderService {

    private Map<Long, Order> orders = new ConcurrentHashMap<>();

    @Override
    public Order findByOrderId(Long orderId) {
        return orders.get(orderId);
    }

    @Override
    public void insert(Order order) {
        orders.put(order.getOrderId(), order);
    }
}
