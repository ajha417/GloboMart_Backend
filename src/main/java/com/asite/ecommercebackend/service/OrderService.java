package com.asite.ecommercebackend.service;

import com.asite.ecommercebackend.exception.OrderException;
import com.asite.ecommercebackend.model.Address;
import com.asite.ecommercebackend.model.Order;
import com.asite.ecommercebackend.model.User;

import java.util.List;

public interface OrderService {
    public Order createOrder(User user, Address address);
    public Order findOrderById(Long orderId) throws OrderException;
    public List<Order> usersOrderHistory(Long userId);
    public Order placedOrder(Long orderId) throws OrderException;
    public Order confirmedOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order cancelledOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public List<Order> getAllOrders();
    public void deleteOrder(Long orderId) throws OrderException;
}
