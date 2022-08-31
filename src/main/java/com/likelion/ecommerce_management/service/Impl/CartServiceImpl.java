package com.likelion.ecommerce_management.service.Impl;

import com.likelion.ecommerce_management.dto.RequestAddToCartElement;
import com.likelion.ecommerce_management.dto.RequestGetCartItem;
import com.likelion.ecommerce_management.entity.Cart;
import com.likelion.ecommerce_management.entity.Cart_item;
import com.likelion.ecommerce_management.entity.Customer;
import com.likelion.ecommerce_management.entity.Product;
import com.likelion.ecommerce_management.repository.*;
import com.likelion.ecommerce_management.service.CartService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Resource
    GetCartItemRepository getCartItemRepository;
    public String addToCart(Integer customerId, List<RequestAddToCartElement> requestAddToCartList){
        if(requestAddToCartList.isEmpty())
            return "No product";
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty())
            return "Customer not found";

        Integer cartId = getCartIdFromCustomer(optionalCustomer.get());
        List<Cart_item> cartItemList = new ArrayList<>();

        for (RequestAddToCartElement item : requestAddToCartList) {
            Optional<Product> optionalProduct = productRepository.findById(item.getProductId());
            if(optionalProduct.isEmpty())
                return "Product ID " + item.getProductId() + " not found";
            cartItemList.add(productToCartItem(cartId, optionalProduct.get(), item.getQuantity()));
        }

        cartItemRepository.saveAll(cartItemList);
        return "ok";
    }

    public List<Cart_item> getCartItemByCustomerIdAndProductNameWithOffsetAndLimit(Integer customerId, String name_product, Integer offset, Integer limit) {
        if (offset == null)
            offset = 0;
        if (limit == null)
            limit = 30;
        RowBounds rowBounds = new RowBounds(offset, limit);
        return getCartItemRepository.getCartItemByCustomerIdAndProductName(customerId,name_product, rowBounds);
    }

    Integer getCartIdFromCustomer(Customer customer){
        if (customer.getCart_id() == null) {
            Cart cart = new Cart();
            customer.setCart_id(cartRepository.save(cart).getCart_id());
            customerRepository.save(customer);
        }
        return customer.getCart_id();
    }

    Cart_item productToCartItem(Integer cartId, Product product, Integer quantity){
        Date date = new Date();
        BigDecimal total = product.getPrice().multiply(BigDecimal.valueOf(quantity));
        Cart_item cart_item = new Cart_item(cartId, product.getProduct_id(), quantity, date, total);
        return cart_item;
    }
}
