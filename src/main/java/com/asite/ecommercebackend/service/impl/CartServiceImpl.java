package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.model.Cart;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.repository.CartRepository;
import com.asite.ecommercebackend.request.AddItemRequest;
import com.asite.ecommercebackend.service.CartItemService;
import com.asite.ecommercebackend.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    private CartItemService cartItemService;
    @Override
    public Cart createCart(User user) {
        return null;
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest request) throws ProductException {
        return null;
    }

    @Override
    public Cart findUserCart(Long userId) {
        return null;
    }
}
