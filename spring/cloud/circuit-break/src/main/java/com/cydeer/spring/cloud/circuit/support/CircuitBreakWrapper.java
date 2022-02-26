package com.cydeer.spring.cloud.circuit.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

/**
 * @author song.z
 * @date 2022/2/25 9:40 下午
 */
public class CircuitBreakWrapper {

    /**
     * 失败多少次开始熔断
     */
    private final static int FAILED_THRESHOLD = 3;

    /**
     * 熔断5次之后尝试一次
     */
    private final static int CIRCUIT_BREAK_THRESHOLD = 5;


    /**
     * 失败次数统计
     */
    private final static Map<String, AtomicLong> FAILED_COUNT = new ConcurrentHashMap<>();

    /**
     * 熔断次数统计
     */
    private final static Map<String, AtomicLong> CIRCUIT_BREAK_COUNT = new ConcurrentHashMap<>();


    /**
     * 包装实际调用，调用异常，或者熔断之后使用默认值
     *
     * @param key          给断路器分类
     * @param supplier     实际调用
     * @param defaultValue 默认值
     * @param <T>          范型参数
     * @return 调用结果
     */
    public <T> T wrap(String key, Supplier<T> supplier, Supplier<T> defaultValue) {
        if (FAILED_COUNT.containsKey(key)) {
            // 失败次数大于阈值则触发熔断，使用默认值
            if (FAILED_COUNT.get(key).get() > FAILED_THRESHOLD) {
                // 熔断次数小于熔断阈值则继续熔断
                if (CIRCUIT_BREAK_COUNT.get(key).get() < CIRCUIT_BREAK_THRESHOLD) {
                    // 熔断次数累计
                    CIRCUIT_BREAK_COUNT.get(key).incrementAndGet();
                    return defaultValue.get();
                }
                // 熔断次数已经达到阈值则尝试实际调用一次
            }
        } else {
            FAILED_COUNT.put(key, new AtomicLong());
            CIRCUIT_BREAK_COUNT.put(key, new AtomicLong());
        }
        try {
            T result = supplier.get();
            // 清空失败次数和熔断次数统计
            FAILED_COUNT.get(key).set(0);
            CIRCUIT_BREAK_COUNT.get(key).set(0);
            return result;
        } catch (Exception e) {
            // 累计失败次数
            FAILED_COUNT.get(key).incrementAndGet();
            // 重新累计熔断次数
            CIRCUIT_BREAK_COUNT.get(key).set(0);
            return defaultValue.get();
        }
    }

}
