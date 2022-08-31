package com.likelion.ecommerce_management.entity;

import com.likelion.ecommerce_management.model.Cart_item_id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CART_ITEM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(Cart_item_id.class)
public class Cart_item {
    @Id
    @Column(name = "CART_ID", nullable = false)
    Integer cart_id;

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    Integer product_id;

    @Column(name = "QUANTITY_WISHED", nullable = false)
    Integer quantity_wished;

    @Column(name = "DATE_ADDED", nullable = false)
    Date date_added;

    @Column(name = "TOTAL_AMOUNT", nullable = false)
    BigDecimal total_amount;
}
