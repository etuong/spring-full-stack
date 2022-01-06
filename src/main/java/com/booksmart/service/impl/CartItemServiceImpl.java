package com.booksmart.service.impl;


import com.booksmart.entity.*;
import com.booksmart.repository.CartItemRepository;
import com.booksmart.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartItemRepository.findByShoppingCart(shoppingCart);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        BigDecimal updatedSubtotal = new BigDecimal(cartItem.getBook().getOurPrice()).multiply(new BigDecimal(cartItem.getQuantity()));

        updatedSubtotal = updatedSubtotal.setScale(2, RoundingMode.HALF_UP);
        cartItem.setSubtotal(updatedSubtotal);

        cartItemRepository.save(cartItem);

        return cartItem;
    }

    public CartItem addBookToCartItem(Book book, User user, int quantity) {
        List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());

        for (CartItem cartItem : cartItemList) {
            if (book.getId() == cartItem.getBook().getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItem.setSubtotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(quantity)));
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(user.getShoppingCart());
        cartItem.setBook(book);
        cartItem.setQuantity(quantity);
        cartItem.setSubtotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(quantity)));
        cartItem = cartItemRepository.save(cartItem);

        return cartItem;
    }

    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).get();
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> findByOrder(Order order) {
        return cartItemRepository.findByOrder(order);
    }

    public int getNumberOfCartItems(User user) {
        List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
        return cartItemList.size();
    }
}
