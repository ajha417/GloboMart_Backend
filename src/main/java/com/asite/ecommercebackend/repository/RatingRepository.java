package com.asite.ecommercebackend.repository;

import com.asite.ecommercebackend.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Ratings, Long> {
    @Query("SELECT r FROM Ratings r WHERE r.product.id=:productId")
    public List<Ratings> getAllProductRatings(@Param("productId") Long productId);
}
