package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.exception.OrderException;
import com.asite.ecommercebackend.model.*;
import com.asite.ecommercebackend.repository.CartRepository;
import com.asite.ecommercebackend.service.CartService;
import com.asite.ecommercebackend.service.OrderService;
import com.asite.ecommercebackend.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;
    @Override
    public Order createOrder(User user, Address address) {
        Order order = new Order();
        Cart cart = cartService.findUserCart(user.getId());
        Set<CartItem> cartItemList = cart.getCartItems();
        for (CartItem item: cartItemList){
            
        }
        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> usersOrderHistory(Long userId) {
        return null;
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order cancelledOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) throws OrderException {

    }
}
