package com.likelion.ecommerce_management.service;

import com.likelion.ecommerce_management.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> getAllProduct(BigDecimal price, String condition);
}
