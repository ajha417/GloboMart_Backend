package com.asite.ecommercebackend.controller;

import com.asite.ecommercebackend.exception.OrderException;
import com.asite.ecommercebackend.model.Order;
import com.asite.ecommercebackend.response.ApiResponse;
import com.asite.ecommercebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrdersHandler() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
    }
    @PutMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> confirmOrderHandler(@PathVariable Long orderId,
                                                     @RequestHeader("Authorization") String jwt) throws OrderException{
        Order order = orderService.confirmedOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PutMapping("/{orderId}/ship")
    public ResponseEntity<Order> shippedOrderHandler(@PathVariable Long orderId,
                                                     @RequestHeader("Authorization") String jwt) throws OrderException{
        Order order = orderService.shippedOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PutMapping("/{orderId}/deliver")
    public ResponseEntity<Order> deliveredOrderHandler(@PathVariable Long orderId,
                                                     @RequestHeader("Authorization") String jwt) throws OrderException{
        Order order = orderService.deliveredOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelledOrderHandler(@PathVariable Long orderId,
                                                       @RequestHeader("Authorization") String jwt) throws OrderException{
        Order order = orderService.cancelledOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PutMapping("/{orderId}/delete")
    public ResponseEntity<ApiResponse> deleteOrderHandler(@PathVariable Long orderId,
                                                          @RequestHeader("Authorization") String jwt) throws OrderException{
        orderService.deleteOrder(orderId);
        ApiResponse response = new ApiResponse();
        response.setMessage("Order deleted successfully!!!");
        response.setJwt(jwt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
