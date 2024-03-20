package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.exception.OrderException;
import com.asite.ecommercebackend.model.Address;
import com.asite.ecommercebackend.model.Order;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.repository.CartRepository;
import com.asite.ecommercebackend.service.CartService;
import com.asite.ecommercebackend.service.OrderService;
import com.asite.ecommercebackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private CartRepository cartRepository;
    private CartService cartService;
    private ProductService productService;
    @Override
    public Order createOrder(User user, Address address) {
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
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) throws OrderException {

    }
}
