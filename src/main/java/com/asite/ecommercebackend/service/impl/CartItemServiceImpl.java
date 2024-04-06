package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.exception.CartItemException;
import com.asite.ecommercebackend.exception.UserException;
import com.asite.ecommercebackend.model.Cart;
import com.asite.ecommercebackend.model.CartItem;
import com.asite.ecommercebackend.model.Product;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.repository.CartItemRepository;
import com.asite.ecommercebackend.repository.CartRepository;
import com.asite.ecommercebackend.service.CartItemService;
import com.asite.ecommercebackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
     @Autowired
     CartItemRepository cartItemRepository;
     @Autowired
     UserService userService;
     @Autowired
     CartRepository cartRepository;
    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        CartItem item = findCartItemById(id);
        User user = userService.findUserById(item.getUserId());
        if(user.getId().equals(userId)){ //cart item can be updated by actual user not by anyone
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getQuantity() * item.getProduct().getPrice());
            item.setDiscountedPrice(item.getQuantity() * item.getProduct().getDiscountedPrice());
        }
        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        return cartItemRepository.isCartItemExist(cart, product, size, userId);
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
        CartItem cartItem = findCartItemById(cartItemId);
        User user = userService.findUserById(cartItem.getUserId());
        User reqUser = userService.findUserById(userId);
        if (user.getId().equals(reqUser.getId())) {
            cartItemRepository.deleteById(cartItemId);
        }
        else {
            throw new UserException("You can't remove another users item!!!");
        }
    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        Optional<CartItem> cartItem = cartItemRepository.findById(cartItemId);
        if (cartItem.isPresent()) {
            return cartItem.get();
        }
        throw new CartItemException("cart item not found with id:"+cartItemId);
    }
}
