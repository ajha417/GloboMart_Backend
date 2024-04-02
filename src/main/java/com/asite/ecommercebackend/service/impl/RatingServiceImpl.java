package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.model.Product;
import com.asite.ecommercebackend.model.Ratings;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.repository.RatingRepository;
import com.asite.ecommercebackend.request.RatingRequest;
import com.asite.ecommercebackend.service.ProductService;
import com.asite.ecommercebackend.service.RatingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {
    RatingRepository ratingRepository;
    ProductService productService;
    @Override
    public Ratings createRating(RatingRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());
        Ratings rating = new Ratings();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRatings(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Ratings> getProductRatings(Long productId) {
        return ratingRepository.getAllProductRatings(productId);
    }
}
