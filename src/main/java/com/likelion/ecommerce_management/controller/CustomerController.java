package com.likelion.ecommerce_management.controller;

import com.likelion.ecommerce_management.dto.RequestAddToCartElement;
import com.likelion.ecommerce_management.dto.RequestGetCartItem;
import com.likelion.ecommerce_management.service.CartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CartService cartService;

    @PostMapping("/{customerId}/cart")
    ResponseEntity<?> addToCard(@PathVariable("customerId") Integer customerId,
                             @RequestBody List<RequestAddToCartElement> requestAddToCartList){
        String response = cartService.addToCart(customerId, requestAddToCartList);
        if (response.equals("ok")) return ResponseEntity.ok().build();
        else return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{customerId}/cart")
    ResponseEntity<?> getItemFromCart(@PathVariable("customerId") Integer customerId,
                                      @Param("name_product") String name_product,
                                      @Param("offset") Integer offset,
                                      @Param("limit") Integer limit){
        return ResponseEntity.ok(cartService.getCartItemByCustomerIdAndProductNameWithOffsetAndLimit(customerId, name_product, offset, limit));
    }
}
