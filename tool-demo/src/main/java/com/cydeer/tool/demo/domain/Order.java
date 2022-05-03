package com.cydeer.tool.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author song.z
 * @date 2022/3/28 9:37 下午
 */
public class Order implements Serializable {

    private Long orderId;

    private BigDecimal orderAmount;

    private Long commodityId;

    private BigDecimal price;

    private Integer quantity;

    public Order(Long orderId, BigDecimal orderAmount, Long commodityId, BigDecimal price, Integer quantity) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.commodityId = commodityId;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
