package com.likelion.ecommerce_management.service.Impl;

import com.likelion.ecommerce_management.entity.Product;
import com.likelion.ecommerce_management.repository.GetProductRepository;
import com.likelion.ecommerce_management.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    GetProductRepository getProductRepository;

    public List<Product> getAllProduct(BigDecimal price, String condition){
        List<Product> products;
        if(price==null || condition==null)
            products = getProductRepository.getAllProduct();
        else
        switch (condition) {
            case "LESS_THAN" -> products = getProductRepository.getAllProductLess(price);
            case "GREATER_THAN" -> products = getProductRepository.getAllProductGreater(price);
            case "EQUAL" -> products = getProductRepository.getAllProductEqual(price);
            default -> products = null;
        }
        return products;
    }
}
