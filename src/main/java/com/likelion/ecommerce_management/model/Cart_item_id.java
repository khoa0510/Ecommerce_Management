package com.likelion.ecommerce_management.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Cart_item_id implements Serializable {
    Integer cart_id;
    Integer product_id;
}
