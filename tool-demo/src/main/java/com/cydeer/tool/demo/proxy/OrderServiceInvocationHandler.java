package com.cydeer.tool.demo.proxy;

import com.cydeer.tool.demo.api.OrderService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author song.z
 * @date 2022/3/28 9:41 下午
 */
public class OrderServiceInvocationHandler implements InvocationHandler {

    private OrderService orderService;

    public OrderServiceInvocationHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + ":" + args);
        return method.invoke(orderService, args);
    }
}
