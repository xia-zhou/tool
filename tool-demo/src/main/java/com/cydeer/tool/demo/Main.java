package com.cydeer.tool.demo;

import com.cydeer.tool.demo.api.OrderService;
import com.cydeer.tool.demo.domain.Order;
import com.cydeer.tool.demo.impl.OrderServiceImpl;
import com.cydeer.tool.demo.proxy.OrderServiceInvocationHandler;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

/**
 * @author song.z
 * @date 2022/3/28 9:42 下午
 */
public class Main {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Order order = new Order(1L, BigDecimal.TEN, 1L, BigDecimal.ONE, 10);
        OrderService orderService = new OrderServiceImpl();
        OrderServiceInvocationHandler handler = new OrderServiceInvocationHandler(orderService);

        OrderService proxyService = (OrderService) Proxy.newProxyInstance(orderService.getClass().getClassLoader(),
                                                                          orderService.getClass().getInterfaces(),
                                                                          handler);
        proxyService.insert(order);

        System.out.println(proxyService.findByOrderId(1L).getOrderAmount());

    }
}
