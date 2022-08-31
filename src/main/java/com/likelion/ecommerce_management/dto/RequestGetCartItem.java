package com.likelion.ecommerce_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestGetCartItem {
    String name_product;
    Integer offset;
    Integer limit;
}
