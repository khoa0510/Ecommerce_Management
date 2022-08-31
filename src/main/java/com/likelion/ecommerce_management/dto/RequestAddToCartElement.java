package com.likelion.ecommerce_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAddToCartElement {
    Integer productId;
    Integer quantity;
}
