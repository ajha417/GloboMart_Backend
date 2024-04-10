package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.model.OrderItems;
import com.asite.ecommercebackend.repository.OrderItemRepository;
import com.asite.ecommercebackend.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItems createOrderItem(OrderItems orderItems) {
        return orderItemRepository.save(orderItems);
    }
}
