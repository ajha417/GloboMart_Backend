package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.exception.CartItemException;
import com.asite.ecommercebackend.exception.UserException;
import com.asite.ecommercebackend.model.Cart;
import com.asite.ecommercebackend.model.CartItem;
import com.asite.ecommercebackend.model.Product;
import com.asite.ecommercebackend.repository.CartItemRepository;
import com.asite.ecommercebackend.repository.CartRepository;
import com.asite.ecommercebackend.service.CartItemService;
import com.asite.ecommercebackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service
public class CartItemServiceImpl implements CartItemService {
    private CartItemRepository cartItemRepository;
    private UserService userService;
    private CartRepository cartRepository;
    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        return null;
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        return null;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {

    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        return null;
    }
}
