//package com.cydeer.spring.jpa.domain;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.Type;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.joda.money.Money;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.List;
//
///**
// * @author song.z
// * @date 2021/12/27 10:42 下午
// */
//@Table(name = "order")
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class Order implements Serializable {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String name;
//
//    @Column
//    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount", parameters = {
//            @org.hibernate.annotations.Parameter(name = "CurrencyCode", value = "CNY")})
//    private Money totalAmount;
//
//
//    @JoinColumn(name = "orderId")
//    private List<OrderItem> orderItems;
//
//    @Column(nullable = false)
//    private Integer status;
//    @Column(updatable = false)
//    @CreationTimestamp
//    private LocalDateTime gmtCreated;
//
//    @UpdateTimestamp
//    private LocalDateTime gmtModified;
//}
