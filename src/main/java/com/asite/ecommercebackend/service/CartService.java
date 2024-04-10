package com.asite.ecommercebackend.service;

import com.asite.ecommercebackend.exception.CartItemException;
import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.model.Cart;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.request.AddItemRequest;

public interface CartService {
    public Cart createCart(User user);
    public String addCartItem(Long userId, AddItemRequest request) throws ProductException;
    public Cart findUserCart(Long userId);
    public void removeItemFromCart(Long userId, Long itemId) throws CartItemException;
}
