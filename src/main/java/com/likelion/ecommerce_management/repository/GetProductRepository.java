package com.likelion.ecommerce_management.repository;

import com.likelion.ecommerce_management.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface GetProductRepository {
    @Select("SELECT * FROM PRODUCT")
    List<Product> getAllProduct();
    @Select("SELECT * FROM PRODUCT d WHERE d.PRICE = #{price}")
    List<Product> getAllProductEqual(BigDecimal price);

    @Select("SELECT * FROM PRODUCT d WHERE d.PRICE > #{price}")
    List<Product> getAllProductGreater(BigDecimal price);

    @Select("SELECT * FROM PRODUCT d WHERE d.PRICE < #{price}")
    List<Product> getAllProductLess(BigDecimal price);
}
