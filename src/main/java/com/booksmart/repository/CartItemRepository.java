package com.booksmart.repository;

import com.booksmart.entity.CartItem;
import com.booksmart.entity.Order;
import com.booksmart.entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    List<CartItem> findByOrder(Order order);
}
