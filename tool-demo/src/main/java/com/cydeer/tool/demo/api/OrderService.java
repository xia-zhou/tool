package com.cydeer.tool.demo.api;

import com.cydeer.tool.demo.domain.Order;

/**
 * @author song.z
 * @date 2022/3/28 9:36 下午
 */
public interface OrderService {

    Order findByOrderId(Long orderId);

    void insert(Order order);
}
