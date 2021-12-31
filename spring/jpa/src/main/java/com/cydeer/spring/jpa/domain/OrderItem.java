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
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
///**
// * @author song.z
// * @date 2021/12/27 10:42 下午
// */
//@Table(name = "order_item")
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class OrderItem implements Serializable {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String name;
//
//    private Long commodityId;
//    @Column
//    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount", parameters = {
//            @org.hibernate.annotations.Parameter(name = "CurrencyCode", value = "CNY")})
//    private Money amount;
//    @Column
//    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount", parameters = {
//            @org.hibernate.annotations.Parameter(name = "CurrencyCode", value = "CNY")})
//    private Money price;
//    private Integer quantity;
//
//    @Column(updatable = false)
//    @CreationTimestamp
//    private LocalDateTime gmtCreated;
//
//    @UpdateTimestamp
//    private LocalDateTime gmtModified;
//}
