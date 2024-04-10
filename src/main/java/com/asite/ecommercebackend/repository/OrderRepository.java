package com.asite.ecommercebackend.repository;

import com.asite.ecommercebackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.asite.ecommercebackend.model.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.user.id=:userId AND (o.orderStatus=:placed OR o.orderStatus=:confirmed OR o.orderStatus=:shipped OR o.orderStatus=:delivered)")
    public List<Order> getUserOrders(@Param("userId") Long userId,@Param("placed") OrderStatus placed,
                                     @Param("confirmed") OrderStatus confirmed,
                                     @Param("shipped") OrderStatus shipped,
                                     @Param("delivered") OrderStatus delivered);
}
