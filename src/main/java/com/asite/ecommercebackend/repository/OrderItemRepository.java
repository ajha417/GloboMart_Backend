package com.asite.ecommercebackend.repository;

import com.asite.ecommercebackend.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems, Long> {
}
