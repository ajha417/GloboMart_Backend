package com.asite.ecommercebackend.repository;

import com.asite.ecommercebackend.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    @Query("SELECT r FROM Reviews r WHERE r.product.id=:productId")
    public List<Reviews> getAllProductReviews(@Param("productId") Long productId);
}
