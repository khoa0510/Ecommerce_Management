package com.likelion.ecommerce_management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID", nullable = false)
    int product_id;

    @Column(name = "NAME_PRODUCT", nullable = false)
    String name_product;

    @Column(name = "TYPE")
    String type;

    @Column(name = "SIZE")
    String size;

    @Column(name = "PRICE", nullable = false)
    BigDecimal price;
}
