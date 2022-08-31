package com.likelion.ecommerce_management.service;

import com.likelion.ecommerce_management.dto.RequestAddToCartElement;
import com.likelion.ecommerce_management.dto.RequestGetCartItem;
import com.likelion.ecommerce_management.entity.Cart_item;

import java.util.List;

public interface CartService {
    String addToCart(Integer customerId, List<RequestAddToCartElement> requestAddToCartList);
    List<Cart_item> getCartItemByCustomerIdAndProductNameWithOffsetAndLimit(Integer customerId, String name_product, Integer offset, Integer limit);
}
