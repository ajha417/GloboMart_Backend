package com.asite.ecommercebackend.repository;

import com.asite.ecommercebackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.asite.ecommercebackend.model.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.user.id=:userId AND (o.orderStatus='PLACED' OR o.orderStatus='CONFIRMED' " +
            "OR o.orderStatus='SHIPPED' OR o.orderStatus='DELIVERED')")
    public List<Order> getUserOrders(@Param("userId") Long userId);
}
