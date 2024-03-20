package com.asite.ecommercebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "order_id")
    private int orderId;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems = new ArrayList<>();
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    @OneToOne
    private Address address;
    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();

    private double totalPrice;
    private int totalDiscountedPrice;
    private int discount;
    private String orderStatus;
    private int totalItem;
    private LocalDateTime createdAt;

}
