package com.likelion.ecommerce_management.repository;

import com.likelion.ecommerce_management.entity.Cart_item;
import com.likelion.ecommerce_management.model.Cart_item_id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<Cart_item, Cart_item_id> {
}
