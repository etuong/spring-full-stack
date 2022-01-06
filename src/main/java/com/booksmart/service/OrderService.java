package com.booksmart.service;

import com.booksmart.entity.Order;
import com.booksmart.entity.ShoppingCart;
import com.booksmart.entity.User;

public interface OrderService {
    Order createOrder(ShoppingCart shoppingCart, User user);
}
