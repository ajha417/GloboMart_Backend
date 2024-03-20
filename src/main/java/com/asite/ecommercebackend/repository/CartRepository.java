package com.asite.ecommercebackend.repository;

import com.asite.ecommercebackend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {

}
