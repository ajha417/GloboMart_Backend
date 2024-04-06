package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.model.Cart;
import com.asite.ecommercebackend.model.CartItem;
import com.asite.ecommercebackend.model.Product;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.repository.CartRepository;
import com.asite.ecommercebackend.request.AddItemRequest;
import com.asite.ecommercebackend.service.CartItemService;
import com.asite.ecommercebackend.service.CartService;
import com.asite.ecommercebackend.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CartServiceImpl implements CartService {
     @Autowired
     CartRepository cartRepository;
     @Autowired
     CartItemService cartItemService;
     @Autowired
     ProductService productService;

//    public CartServiceImpl(CartRepository cartRepository, CartItemService cartItemService, ProductService productService) {
//        this.cartRepository = cartRepository;
//        this.cartItemService = cartItemService;
//        this.productService = productService;
//    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest request) throws ProductException {
        Cart cart = cartRepository.findByUserId(userId);
        Product product = productService.findProductById(request.getProductId());
        CartItem isPresent = cartItemService.isCartItemExist(cart,product, request.getSize(), userId);
        if (isPresent == null){
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setQuantity(request.getQuantity());
            cartItem.setUserId(userId);

            int price = request.getQuantity() * product.getDiscountedPrice();
            cartItem.setPrice(price);
            cartItem.setSize(request.getSize());

            CartItem createdCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createdCartItem);
        }
        return "Item added to Cart Successfully!!!";
    }

    @Override
    public Cart findUserCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItem = 0;
        for (CartItem cartItem: cart.getCartItems()) {
            totalPrice = totalPrice + cartItem.getPrice();
            totalDiscountedPrice = totalDiscountedPrice + cartItem.getDiscountedPrice();
            totalItem = totalItem + cartItem.getQuantity();
        }
        cart.setTotal_price(totalPrice);
        cart.setTotalDiscountedPrice(totalDiscountedPrice);
        cart.setTotalItem(totalItem);
        cart.setDiscount(totalPrice - totalDiscountedPrice);
        return cartRepository.save(cart);
    }
}
