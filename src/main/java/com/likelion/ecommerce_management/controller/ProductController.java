package com.likelion.ecommerce_management.controller;

import com.likelion.ecommerce_management.entity.Product;
import com.likelion.ecommerce_management.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    ResponseEntity<List<Product>> getProduct(@Param("price") BigDecimal price,
                                            @Param("condition") String condition){
        List<Product> productList = productService.getAllProduct(price, condition);
        if(productList.isEmpty())
        {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(productList);
        }
    }
}
