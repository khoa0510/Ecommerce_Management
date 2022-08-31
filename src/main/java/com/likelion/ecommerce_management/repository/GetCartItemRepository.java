package com.likelion.ecommerce_management.repository;

import com.likelion.ecommerce_management.entity.Cart_item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface GetCartItemRepository {
    @Select("SELECT i.CART_ID, i.PRODUCT_ID, QUANTITY_WISHED, DATE_ADDED, TOTAL_AMOUNT "+
            "FROM CART_ITEM i, PRODUCT p, CUSTOMER c "+
            "WHERE CUSTOMER_ID = #{customerId} AND i.CART_ID = c.CART_ID AND i.PRODUCT_ID = p.PRODUCT_ID AND NAME_PRODUCT = #{product_name}")
    List<Cart_item> getCartItemByCustomerIdAndProductName(Integer customerId, String product_name, RowBounds rowBounds);
}
