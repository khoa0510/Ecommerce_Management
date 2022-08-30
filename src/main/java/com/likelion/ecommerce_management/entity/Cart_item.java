package com.likelion.ecommerce_management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CART_ITEM")
@Getter
@Setter
public class Cart_item {
    @Id
    @Column(name = "CART_ID", nullable = false)
    int cart_id;

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    int product_id;

    @Column(name = "QUANTITY_WISHED", nullable = false)
    int quantity_wished;

    @Column(name = "DATE_ADDED", nullable = false)
    Date date_added;

    @Column(name = "TOTAL_AMOUNT", nullable = false)
    BigDecimal total_amount;
}
