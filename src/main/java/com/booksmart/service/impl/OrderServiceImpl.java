package com.booksmart.service.impl;


import com.booksmart.entity.CartItem;
import com.booksmart.entity.Order;
import com.booksmart.entity.ShoppingCart;
import com.booksmart.entity.User;
import com.booksmart.repository.OrderRepository;
import com.booksmart.service.CartItemService;
import com.booksmart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemService cartItemService;

    public synchronized Order createOrder(ShoppingCart shoppingCart, User user) {
        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        Order order = Order.builder()
                .orderTotal(shoppingCart.getGrandTotal())
                .cartItemList(cartItemList)
                .user(user)
                .build();

        for (CartItem cartItem : cartItemList) {
            cartItem.setOrder(order);
        }

        order = orderRepository.save(order);

        return order;
    }
}
