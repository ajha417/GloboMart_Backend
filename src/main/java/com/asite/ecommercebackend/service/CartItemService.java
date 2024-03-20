package com.asite.ecommercebackend.service;

import com.asite.ecommercebackend.exception.CartItemException;
import com.asite.ecommercebackend.exception.UserException;
import com.asite.ecommercebackend.model.Cart;
import com.asite.ecommercebackend.model.CartItem;
import com.asite.ecommercebackend.model.Product;

public interface CartItemService {
    public CartItem createCartItem(CartItem cartItem);
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;
    public CartItem isCartItemExist(Cart cart, Product product, String size,Long userId);
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
    public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
